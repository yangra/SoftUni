import instock.Instock;
import instock.Product;
import instock.ProductStock;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class PerformanceInstock {
    @Test
    public void add_100000_Elements_ShouldWorkFast()
    {
        //Arrange
        ProductStock stock = new Instock();
        long start = System.currentTimeMillis();
        //Act
        for (int i = 0; i < 50000; i++)
        {
            stock.add(new Product(String.valueOf(i), i, i));
        }
        long stop = System.currentTimeMillis();
        //Assert
        Assert.assertTrue(stop - start < 450);
    }

    @Test
    public void contains_100000_Elements_ShouldExecuteFast()
    {
        // Arrange
        ProductStock stock = new Instock();
        int count = 100000;
        LinkedList<Product> products = new LinkedList<Product>();

        for (int i = 0; i < count; i++)
        {
            products.addLast(new Product(String.valueOf(i), i, i));
            stock.add(products.getLast());
        }

        // Act
        long start = System.currentTimeMillis();

        for(Product p : products)
        {
            Assert.assertTrue(stock.contains(p));
        }

        long end = System.currentTimeMillis();
        Assert.assertTrue(end - start < 250);
    }

    @Test
    public void findAtIndex_On_100_000_Elements_ShouldWorkFast()
    {
        // Arrange
        ProductStock stock = new Instock();
        int count = 100000;
        List<Product> people = new ArrayList<Product>();

        for (int i = 0; i < count; i++)
        {
            people.add(new Product(String.valueOf(i), i, i));
            stock.add(people.get(i));
        }

        // Act
        long start = System.currentTimeMillis();
        Random rand = new Random();
        for (int i = 0; i < 50000; i++)
        {
            int rnd = rand.nextInt(count - 1);
            Assert.assertSame(people.get(rnd), stock.find(rnd));
        }
        // Assert
        long end = System.currentTimeMillis();
        Assert.assertTrue(end - start < 200);
    }

    @Test
    public void findByLabel_Shoul_WorkFast_On_100000_Products()
    {
        // Arrange
        ProductStock stock = new Instock();
        int count = 100000;
        List<Product> names = new ArrayList<Product>(100000);

        for (int i = 0; i < count; i++)
        {
            Product p = new Product(String.valueOf(i), i, i);
            stock.add(p);
            names.add(p);
        }

        // Act
        long start = System.currentTimeMillis();
        // Assert
        for (int i = 0; i < count; i++)
        {
            Assert.assertTrue(stock.findByLabel(names.get(i).getLabel()) == names.get(i));
        }

        long end = System.currentTimeMillis();
        Assert.assertTrue(start - end <230);
    }

    @Test
    public void changeQuantity_On_100000_ShouldWorkFast()
    {
        // Arrange
        ProductStock stock = new Instock();
        int count = 100000;
        List<Product> products = new ArrayList<Product>(100000);

        for (int i = 0; i < count; i++)
        {
            Product p = new Product(String.valueOf(i), i, i);
            stock.add(p);
            products.add(p);
        }

        // Act & Assert
        long start = System.currentTimeMillis();
        Random rand = new Random();
        for (int i = 0; i < 50000; i++)
        {
            int qty = rand.nextInt(50000);
            int index = rand.nextInt(99999);
            stock.changeQuantity(products.get(i).getLabel(), qty);
            Assert.assertEquals(products.get(i).getQuantity(), qty);
        }
        long end = System.currentTimeMillis();
        Assert.assertTrue(end - start < 250);
    }

    @Test
    public void changeQuantity_100000_OnSameProduct_ShouldWorkFast()
    {
        // Arrange
        ProductStock stock = new Instock();
        int count = 100000;
        List<Product> products = new ArrayList<Product>(100000);

        for (int i = 0; i < count; i++)
        {
            Product p = new Product(String.valueOf(i), i, i);
            stock.add(p);
            products.add(p);
        }

        // Act & Assert
        long start = System.currentTimeMillis();
        Random rand = new Random();
        for (int i = 0; i < 50000; i++)
        {
            int qty = rand.nextInt(10000);
            stock.changeQuantity(products.get(576).getLabel(), qty);
            Assert.assertEquals(products.get(576).getQuantity(), qty);
        }
        long end = System.currentTimeMillis();
        Assert.assertTrue(end - start <  200);
    }

    @Test
    public void productByInsertOrder_ShouldWorkFast()
    {
        // Arrange
        ProductStock stock = new Instock();
        int count = 100000;
        List<Product> people = new ArrayList<>();

        for (int i = 0; i < count; i++)
        {
            people.add(new Product(String.valueOf(i), i, i));
            stock.add(people.get(i));
        }

        long start = System.currentTimeMillis();
        // Act & Assert
        int c = 0;
        for(Product p : stock){
            Assert.assertSame(p, people.get(c));
            c++;
        }

        long end = System.currentTimeMillis();
        Assert.assertEquals(c, people.size());
        Assert.assertTrue(end - start < 150);
    }

    @Test
    public void findAllByPrice_On100000ElementsWithRandomPrice_ShouldWorkFast()
    {
        // Arrange
        ProductStock stock = new Instock();
        int count = 100000;
        List<Product> expected = new ArrayList<Product>();

        Random random = new Random();
        for (int i = 0; i < count; i++)
        {
            int price = random.nextInt(30);
            Product p = new Product(String.valueOf(i), price, 25);
            if (price == 21)
            {
                expected.add(p);
            }
            stock.add(p);
        }

        long start = System.currentTimeMillis();
        // Act
        Iterable<Product> result = stock.findAllByPrice(21);

        // Assert
        Iterator<Product> iter = result.iterator();
        for(int i = 0 ; i < expected.size();i++){

            Assert.assertTrue(iter.hasNext());
            Assert.assertSame(expected.get(i),iter.next());
        }
        long end = System.currentTimeMillis();
        Assert.assertTrue(end - start < 25);
    }

    @Test
    public void findFirstByAlphabeticOrder_On100000Elements_ShouldWorkFast()
    {
        // Arrange
        ProductStock stock = new Instock();
        int count = 100000;
        List<Product> products = new ArrayList<Product>();

        for (int i = 0; i < count; i++)
        {

            products.add(new Product(String.valueOf(i), i,i));
            stock.add(products.get(i));
        }
        products.sort(Comparator.comparing(Product::getLabel));
        long start = System.currentTimeMillis();
        // Act
        Iterable<Product> result = stock.findFirstByAlphabeticalOrder(50000);

        // Assert
        Iterator<Product> iter = result.iterator();
        for(int i = 0 ; i < 50000;i++){

            Assert.assertTrue(iter.hasNext());
            Assert.assertSame(products.get(i),iter.next());
        }
        long end = System.currentTimeMillis();

        Assert.assertTrue(end - start < 100);
    }

    @Test
    public void FindFirstMostExpensiveItems_On100000Elements_ShouldWorkFast()
    {
        // Arrange
        ProductStock stock = new Instock();
        int count = 100000;
        LinkedList<Product> products = new LinkedList<Product>();

        for (int i = 0; i < count; i++)
        {

            products.addFirst(new Product(String.valueOf(i), i, i));
            stock.add(products.getFirst());
        }
        long start = System.currentTimeMillis();
        // Act
        Iterable<Product> result = stock.findFirstMostExpensiveProducts(50000);

        // Assert
        Iterator<Product> iter = result.iterator();
        for(int i = 0 ; i < 50000;i++){

            Assert.assertTrue(iter.hasNext());
            Assert.assertSame(products.get(i),iter.next());
        }
        long end = System.currentTimeMillis();

        Assert.assertTrue(end - start <  120);
    }

    @Test
    public void FindAllByQuantity_On_100000_Elements_ShouldWorkFast()
    {
        // Arrange
        ProductStock stock = new Instock();
        int count = 100000;
        HashMap<Integer, ArrayList<Product>> products
                = new HashMap<Integer, ArrayList<Product>>();

        for (int i = 0; i < count; i+=400)
        {
            for(int j = 0; j < 400; j++)
            {
                Product p = new Product(String.valueOf((i + j)), j, j);
                products.putIfAbsent(j, new ArrayList<Product>());
                stock.add(p);
                products.get(j).add(p);
            }
        }
        long start = System.currentTimeMillis();
        // Act

        // Assert
        for(int i = 0; i < 100; i++)
        {
            Iterable<Product> iterable = stock.findAllByQuantity(i);
            int c = 0;
            for(Product p : iterable) {
                Assert.assertSame(p, products.get(i).get(c));
                c++;
            }

            Assert.assertEquals(c, products.get(i).size());
        }
        long end = System.currentTimeMillis();

        Assert.assertTrue(end - start < 100);
    }

    @Test
    public void FindAllInPriceRange_OnLargeRange_ShouldWorkFast() {
        // Arrange
        ProductStock stock = new Instock();
        int count = 100000;
        int expected = 0;

        Random random = new Random();
        for (int i = 0; i < count; i++) {
            int price = random.nextInt(50000);
            if (price > 105 && price <= 10000) expected++;

            stock.add(new Product(String.valueOf(i), price, i));
        }

        long start = System.currentTimeMillis();
        // Act
        // Assert
        Assert.assertEquals(expected, ((ArrayList) stock.findAllInRange(105, 10000)).size());

        long end = System.currentTimeMillis();
        Assert.assertTrue(end - start < 300);
    }
}
