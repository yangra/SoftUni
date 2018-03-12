package instock;

import com.google.common.collect.Multiset;
import com.google.common.collect.TreeMultiset;

import java.util.*;
import java.util.stream.Collectors;

public class Instock implements ProductStock {

    private List<Product> byIndex;
    private TreeMap<String, Product> byLabel;
    private TreeMap<Double, List<Product>> byPrice;
    private Multiset<Product> byPriceOrder;
    private Map<Integer, List<Product>> byQuantity;

    public Instock() {
        this.byLabel = new TreeMap<>();
        this.byIndex = new ArrayList<>();
        this.byPrice = new TreeMap<>(Comparator.reverseOrder());
        this.byPriceOrder = TreeMultiset.create((p1, p2) -> {
            if (p1.getPrice() != p2.getPrice()) {
                return Double.compare(p2.getPrice(), p1.getPrice());
            }
            return p1.getLabel().compareTo(p2.getLabel());
        });
        this.byQuantity = new HashMap<>();
    }

    @Override
    public int getCount() {
        return this.byIndex.size();
    }

    @Override
    public boolean contains(Product product) {
        return this.byPriceOrder.contains(product);
    }

    @Override
    public void add(Product product) {
        this.byIndex.add(product);

        this.byPrice.putIfAbsent(product.getPrice(), new ArrayList<>());
        this.byPrice.get(product.getPrice()).add(product);

        this.byLabel.put(product.getLabel(), product);

        this.byPriceOrder.add(product);

        this.byQuantity.putIfAbsent(product.getQuantity(), new ArrayList<>());
        this.byQuantity.get(product.getQuantity()).add(product);
    }

    @Override
    public void changeQuantity(String label, int quantity) {
        if (!byLabel.containsKey(label)) {
            throw new IllegalArgumentException();
        }
        Product original = this.byLabel.get(label);
        this.byQuantity.get(original.getQuantity()).remove(original);
        original.setQuantity(quantity);
        this.byQuantity.putIfAbsent(quantity, new ArrayList<>());
        this.byQuantity.get(quantity).add(original);
    }

    @Override
    public Product find(int index) {
        if (index < 0 || index >= byIndex.size()) {
            throw new IndexOutOfBoundsException();
        }
        return this.byIndex.get(index);
    }

    @Override
    public Product findByLabel(String label) {
        if (!this.byLabel.containsKey(label)) {
            throw new IllegalArgumentException();
        }
        return this.byLabel.get(label);
    }

    @Override
    public Iterable<Product> findFirstByAlphabeticalOrder(int count) {
        if (count < 0 || count > this.byLabel.size()) {
            throw new IllegalArgumentException();
        }
        List<Product> result = new ArrayList<>();
        if (count == 0) {
            return result;
        }
        return this.byLabel.values().stream().limit(count).collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllInRange(double lo, double hi) {
        Collection<List<Product>> values = this.byPrice.subMap(hi, true,lo, false).values();
        List<Product> result = new ArrayList<>();
        for (List<Product> value : values) {
            result.addAll(value);
        }
        return result;
    }

    @Override
    public Iterable<Product> findAllByPrice(double price) {
        if (!this.byPrice.containsKey(price)) {
            return new ArrayList<>();
        }
        return this.byPrice.get(price);
    }

    @Override
    public Iterable<Product> findFirstMostExpensiveProducts(int count) {

        if (count == 0) {
            return new ArrayList<>();
        }
        if (this.byIndex.size() < count || count < 0) {
            throw new IllegalArgumentException();
        }


        return this.byPriceOrder.stream().limit(count).collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllByQuantity(int quantity) {
        if(!this.byQuantity.containsKey(quantity)){
            return new ArrayList<>();
        }
        return this.byQuantity.get(quantity);
    }

    @Override
    public Iterator<Product> iterator() {
        return this.byIndex.iterator();
    }
}
