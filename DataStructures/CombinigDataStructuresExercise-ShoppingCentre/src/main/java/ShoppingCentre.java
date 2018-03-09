import java.util.*;

public class ShoppingCentre {

    private Map<String, AVL<Product>> byProducer = new HashMap<>();
    private Map<String, AVL<Product>> byName = new HashMap<>();
    private NavigableMap<Double, List<Product>> byPrice = new TreeMap<>();

    public String addProduct(String name, double price, String producer) {
        Product product = new Product(name, price, producer);
        if (!this.byProducer.containsKey(producer)) {
            this.byProducer.put(product.getProducer(), new AVL<>());
        }
        this.byProducer.get(product.getProducer()).insert(product);
        if (!this.byName.containsKey(name)) {
            this.byName.put(product.getName(), new AVL<>());
        }
        this.byName.get(product.getName()).insert(product);
        if (!this.byPrice.containsKey(price)) {
            this.byPrice.put(product.getPrice(), new ArrayList<>());
        }
        this.byPrice.get(product.getPrice()).add(product);
        return "Product added\n";
    }

    public String delete(String name, String producer) {
        if (this.byProducer.containsKey(producer)) {
            List<Product> forDelete = new ArrayList<>();
            this.byProducer.get(producer).eachInOrder(p -> {
                if (p.getName().equals(name)) {
                    forDelete.add(p);
                }
            });

            for (Product product : forDelete) {
                this.byProducer.get(producer).delete(product);
                if (this.byProducer.get(producer).getSize() == 0) {
                    this.byProducer.remove(producer);
                }
                this.byName.get(name).delete(product);
                if (this.byName.get(name).getSize() == 0) {
                    this.byName.remove(name);
                }
                this.byPrice.get(product.getPrice()).remove(product);
                if (this.byPrice.get(product.getPrice()).size() == 0) {
                    this.byPrice.remove(product.getPrice());
                }
            }

            if (forDelete.size() > 0) {
                return String.format("%d products deleted\n", forDelete.size());
            }

            return "No products found\n";
        }

        return "No products found\n";
    }

    public String delete(String producer) {
        if (this.byProducer.containsKey(producer)) {
            String message = String.format("%d products deleted\n", this.byProducer.get(producer).getSize());
            this.byProducer.get(producer).eachInOrder(p -> {
                this.byName.get(p.getName()).delete(p);
                if (this.byName.get(p.getName()).getSize() == 0) {
                    this.byName.remove(p.getName());
                }
            });
            this.byProducer.get(producer).eachInOrder(p -> {
                this.byPrice.get(p.getPrice()).remove(p);
                if (this.byPrice.get(p.getPrice()).size() == 0) {
                    this.byPrice.remove(p.getPrice());
                }
            });
            this.byProducer.remove(producer);
            return message;
        }

        return "No products found\n";
    }

    public String findProductsByName(String name) {
        StringBuilder builder = new StringBuilder();
        if (this.byName.containsKey(name)) {
            this.byName.get(name)
                    .eachInOrder(p -> builder.append(String.format("{%s;%s;%.2f}\n", p.getName(), p.getProducer(), p.getPrice())));
        } else {
            builder.append("No products found\n");
        }

        return builder.toString();
    }

    public String findProductsByProducer(String producer) {
        StringBuilder builder = new StringBuilder();
        if (this.byProducer.containsKey(producer)) {
            this.byProducer.get(producer)
                    .eachInOrder(p -> builder.append(String.format("{%s;%s;%.2f}\n", p.getName(), p.getProducer(), p.getPrice())));
        } else {
            builder.append("No products found\n");
        }

        return builder.toString();
    }

    public String findProductsByPriceRange(double priceFrom, double priceTo) {
        NavigableMap<Double, List<Product>> priceRange =
                this.byPrice.subMap(priceFrom, true, priceTo, true);

        AVL<Product> result = new AVL<>();
        for (List<Product> products : priceRange.values()) {
            products.forEach(result::insert);
        }

        StringBuilder builder = new StringBuilder();
        result.eachInOrder(p -> builder.append(String.format("{%s;%s;%.2f}\n", p.getName(), p.getProducer(), p.getPrice())));
        if (result.getSize() == 0) {
            builder.append("No products found\n");
        }

        return builder.toString();
    }
}
