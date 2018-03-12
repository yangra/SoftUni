import instock.Instock;
import instock.Product;
import instock.ProductStock;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CorrectnessInstock {


    @Test
    public void add_MultipleElements_ShouldWorkCorrectly() {
        //Arrange
        ProductStock stock = new Instock();
        Product product1 = new Product("Salam", 2.50, 50);
        Product product2 = new Product("Bekon", 2.65, 43);
        Product product3 = new Product("Mayoneza", 1.30, 13);

        //Act
        stock.add(product1);
        stock.add(product2);
        stock.add(product3);

        //Assert
        Assert.assertEquals(product1, stock.find(0));
        Assert.assertEquals(product2, stock.find(1));
        Assert.assertEquals(product3, stock.find(2));
    }

    //Addition
    @Test
    public void add_Single_Product_ShouldAddProduct() {

        //Arrange
        ProductStock stock = new Instock();
        Product product = new Product("Salam", 2.50, 50);

        //Act
        stock.add(product);

        //Assert
        boolean pass = false;
        for(Product item : stock)
        {
            if (item == product
                    && (product.getPrice() == item.getPrice()
                    && product.getLabel().equals(item.getLabel())
                    && product.getQuantity() == item.getQuantity())) {
                pass = true;
            }
        }

        Assert.assertEquals(true, pass);
    }

    @Test
    public void add_MultipleElements_Should_Increase_Count() {
        //Arrange
        ProductStock stock = new Instock();
        Product product1 = new Product("Getter", 20.5, 15);
        Product product2 = new Product("OtherPRoduct", 206.1, 67);
        Product product3 = new Product("50CentPoster", 50, 50);
        //Act
        stock.add(product1);
        stock.add(product2);
        stock.add(product3);
        //Assert
        Assert.assertEquals(3, stock.getCount());
    }

    //Contains
    @Test
    public void add_SingleElement_Contains_ShouldReturnTrue() {
        //Arrange
        ProductStock stock = new Instock();
        Product product = new Product("Pizza", 4.30, 1510);

        //Act
        stock.add(product);

        //Assert
        boolean actual = stock.contains(product);
        Assert.assertTrue(actual);
    }

    @Test
    public void contains_On_Non_ExistingElement_ShouldReturnFalse() {
        //Arrange
        ProductStock stock = new Instock();
        Product product = new Product("Pizza", 4.30, 1510);
        Product product2 = new Product("Rizza", 4.30, 1510);

        //Act
        stock.add(product);

        //Assert
        boolean actual = stock.contains(product2);
        Assert.assertFalse(actual);

    }

    @Test
    public void contains_On_Empty_Collection_ShouldReturnFalse() {
        //Arrange
        ProductStock stock = new Instock();
        //Act
        //Assert
        Assert.assertFalse(stock.contains(new Product("Bakar", 5.5, 15)));
    }

    //FindProductByIndex (InsertionOrder)
    @Test(expected = IndexOutOfBoundsException.class)
    public void find_Product_WrongIndex_ShouldThrow() {
        //Arrange
        ProductStock stock = new Instock();
        Product product = new Product("Salam", 2.50, 50);
        //Act
        stock.add(product);
        //Assert
        boolean throwed = false;
        try{
            stock.find(-5);
        }
        catch(IndexOutOfBoundsException ex){
            throwed = true;
        }
        Assert.assertTrue(throwed);

        stock.find(1);
    }

    @Test
    public void find_Product_On_ExistingProduct_ShouldWorkCorrectly() {
        //Arrange
        ProductStock stock = new Instock();
        Product product1 = new Product("Balsam", 5.3, 12);
        Product product2 = new Product("Korab", 12.6, 1255);
        Product product3 = new Product("Meduza", 53.1, 55);
        //Act
        stock.add(product1);
        stock.add(product2);
        stock.add(product3);
        //Assert
        Assert.assertSame(product3, stock.find(2));
        Assert.assertNotSame(product1, stock.find(1));
        Assert.assertSame(product1, stock.find(0));
    }

    @Test
    public void fdd_Single_Product_ShouldBeAt_0_Index() {
        //Arrange
        ProductStock stock = new Instock();
        Product product = new Product("Salam", 2.50, 50);
        //Act
        stock.add(product);
        //Assert
        Assert.assertEquals(product, stock.find(0));
    }

    //ChangeQuantity
    @Test
    public void changeQuantity_On_ExistingProduct_ShouldWorkCorrectly() {
        //Arrange
        ProductStock stock = new Instock();
        Product product1 = new Product("SalamShpekov", 3.50, 50);
        Product product2 = new Product("BekonNov", 2.65, 43);
        Product product3 = new Product("MayonezaNiskomaslena", 1.30, 13);

        //Act
        stock.add(product1);
        stock.add(product2);
        stock.add(product3);

        stock.changeQuantity("SalamShpekov", 3);
        int expected = 3;
        int actual = stock.findByLabel("SalamShpekov").getQuantity();
        //Assert
        Assert.assertEquals(3, stock.getCount());
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void changeQuantity_On_NonExisting_Product_ShouldThrow() {
        //Arrange
        ProductStock stock = new Instock();
        Product product1 = new Product("SalamShpekov", 3.50, 50);
        Product product2 = new Product("BekonNov", 2.65, 43);
        Product product3 = new Product("MayonezaNiskomaslena", 1.30, 13);

        //Act

        //Assert
        stock.changeQuantity("Barekov", 0);
    }

    @Test
    public void changeQuantity_On_Multiple_Elements_ShouldWorkCorrectly() {
        //Arrange
        ProductStock stock = new Instock();
        Product product1 = new Product("SalamShpekov", 3.50, 560);
        Product product2 = new Product("BekonNov", 2.65, 43);
        Product product3 = new Product("MayonezaNiskomaslena", 1.30, 13);
        Product product4 = new Product("Ketchup", 1.80, 73);
        Product product5 = new Product("Jelqzo", 0.70, 130);
        Product product6 = new Product("Belina", .75, 240);
        Product product7 = new Product("Sirene", .77, 30);

        //Act
        stock.add(product1);
        stock.add(product2);
        stock.add(product3);
        stock.add(product4);
        stock.add(product5);
        stock.add(product6);
        stock.add(product7);

        stock.changeQuantity(product4.getLabel(), 50);
        stock.changeQuantity(product7.getLabel(), 50);
        stock.changeQuantity(product3.getLabel(), 50);

        //Assert
        Product[] expected = new Product[]{
                product4,product7,product3
        };
        List<Product> result = new ArrayList<>();

        Iterable<Product> res = stock.findAllByQuantity(50);
        for(Product p : res){
            result.add(p);
        }
        Product[] actual = new Product[result.size()];
        for(int i = 0 ; i < result.size(); i++){
            actual[i] = result.get(i);
        }
        Assert.assertArrayEquals(expected, actual);
    }

    //FindProductByLabel
    @Test
    public void findByLabel_Should_Work_Correctly() {
        //Arrange
        ProductStock stock = new Instock();
        Product product1 = new Product("SalamShpekov", 3.50, 50);
        Product product2 = new Product("BekonNov", 2.65, 43);
        Product product3 = new Product("MayonezaNiskomaslena", 1.30, 13);

        //Act
        stock.add(product1);
        stock.add(product2);
        stock.add(product3);

        stock.changeQuantity("SalamShpekov", 3);
        //Assert
        Assert.assertTrue(stock.contains(product1));
        Assert.assertSame(product2, stock.findByLabel("BekonNov"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void findByLabel_NoExistingProduct_ShouldThrow() {
        //Arrange
        ProductStock stock = new Instock();
        Product product1 = new Product("SalamShpekov", 3.50, 50);
        Product product2 = new Product("BekonNov", 2.65, 43);
        Product product3 = new Product("MayonezaNiskomaslena", 1.30, 13);

        //Act
        stock.add(product1);
        stock.add(product2);
        stock.add(product3);
        //Assert
        stock.findByLabel("BoroTreti");
    }

    //One more mby
    //FindFirstByAlphabeticalOrder
    @Test
    public void findFirstByAlphabeticalOrder_Should_ReturnCorrectEnumeration() {
        //Arrange
        ProductStock stock = new Instock();
        Product product1 = new Product("Abra", 3.50, 50);
        Product product2 = new Product("Bobar", 2.65, 43);
        Product product3 = new Product("Caza", 1.30, 13);
        Product product4 = new Product("Darfield", 1.80, 73);
        Product product5 = new Product("Eil*", 0.70, 20);
        Product product6 = new Product("Flen", .75, 50);
        Product product7 = new Product("Giilqzo", .77, 50);
        //Act
        stock.add(product1);
        stock.add(product2);
        stock.add(product3);
        stock.add(product4);
        stock.add(product5);
        stock.add(product6);
        stock.add(product7);
        //Assert
        Product[] expected = new Product[] {
                product1,product2,product3,product4,product5,product6,product7
        };
        Iterable<Product> res = stock.findFirstByAlphabeticalOrder(stock.getCount());
        List<Product> result = new ArrayList<>();
        for(Product p : res){
            result.add(p);
        }
        Product[] actual = new Product[result.size()];
        for(int i = 0 ; i < result.size(); i++){
            actual[i] = result.get(i);
        }
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void findFirstByAlphabeticalOrder_On_EmptyStock_ShouldReturn_EmptyEnumeration() {
        //Arrange
        ProductStock stock = new Instock();
        //Act
        //Assert
        List<Product> result = new ArrayList<>();
        Iterable<Product> res = stock.findFirstByAlphabeticalOrder(0);
        for(Product p : res){
            result.add(p);
        }
        Product[] actual = new Product[result.size()];
        for(int i = 0 ; i < result.size(); i++){
            actual[i] = result.get(i);
        }
        Assert.assertArrayEquals(new Product[0], actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findFirstByAlphabetical_On_WrongArgumentShouldThrow() {
        //Arrange
        ProductStock stock = new Instock();
        Product product5 = new Product("Jelqzo", 0.70, 20);
        Product product6 = new Product("Belina", .75, 50);
        Product product7 = new Product("Sirene", .77, 50);
        //Act
        stock.add(product5);
        stock.add(product6);
        stock.add(product7);
        //Assert

        stock.findFirstByAlphabeticalOrder(5).iterator().hasNext();
    }

    //FindAllInPriceRange
    @Test
    public void findAllByPriceRange_On_NonExistingRange_ShouldReturnEmpty_Enumeration() {
        //Arrange
        ProductStock stock = new Instock();
        Product product1 = new Product("SalamShpekov", 3.50, 50);
        Product product2 = new Product("BekonNov", 2.65, 43);
        Product product3 = new Product("MayonezaNiskomaslena", 1.30, 13);
        Product product4 = new Product("Ketchup", 1.80, 73);
        Product product5 = new Product("Jelqzo", 0.70, 20);
        Product product6 = new Product("Belina", .75, 50);
        Product product7 = new Product("Sirene", .77, 50);
        //Act
        stock.add(product1);
        stock.add(product2);
        stock.add(product3);
        stock.add(product4);
        stock.add(product5);
        stock.add(product6);
        stock.add(product7);

        //Assert
        List<Product> result = new ArrayList<>();
        Iterable<Product> res = stock.findAllInRange(0.55, 0.69);
        for(Product p : res){
            result.add(p);
        }

        Product[] actual = new Product[result.size()];
        for(int i = 0 ; i < result.size(); i++){
            actual[i] = result.get(i);
        }
        Assert.assertArrayEquals(new Product[0], actual);
    }

    //FindFirstMostExpensiveItems
    @Test
    public void findFirstMostExpensiveProducts_Should_Return_CorrectEnumeration() {
        //Arrange
        ProductStock stock = new Instock();
        Product product2 = new Product("BekonNov", 2.65, 43);
        Product product3 = new Product("MayonezaNiskomaslena", 1.30, 13);
        Product product1 = new Product("SalamShpekov", 3.50, 50);
        //Act
        stock.add(product1);
        stock.add(product2);
        stock.add(product3);
        //Assert
        Product[] expected = new Product[] {
                product1,product2
        };
        List<Product> result = new ArrayList<>();
        Iterable<Product> res = stock.findFirstMostExpensiveProducts(2);
        for(Product p : res){
            result.add(p);
        }
        Product[] actual = new Product[result.size()];
        for(int i = 0 ; i < result.size(); i++){
            actual[i] = result.get(i);
        }
        Assert.assertArrayEquals(expected, actual);
        expected = new Product[] {
                product1
        };
        result = new ArrayList<>();
        res =  stock.findFirstMostExpensiveProducts(1);
        for(Product p : res){
            result.add(p);
        }
        actual = new Product[result.size()];
        for(int i = 0 ; i < result.size(); i++){
            actual[i] = result.get(i);
        }
        Assert.assertArrayEquals(expected, actual);
    }


    @Test(expected = IllegalArgumentException.class)
    public void findFirstMostExpensiveProducts_On_WrongArgumentPassed_ShouldThrow() {
        //Arrange
        ProductStock stock = new Instock();
        Product product1 = new Product("SalamShpekov", 3.50, 50);
        Product product2 = new Product("BekonNov", 2.65, 43);
        Product product3 = new Product("MayonezaNiskomaslena", 1.30, 13);
        //Act
        stock.add(product1);
        stock.add(product2);
        stock.add(product3);
        //Assert
        Assert.assertEquals(3, stock.getCount());
        stock.findFirstMostExpensiveProducts(5).iterator().next();
    }

    @Test
    public void findFirstMostExpensiveProducts_ShouldReturn_OrderedEnumeration() {
        //Arrange
        ProductStock stock = new Instock();
        Product product1 = new Product("SalamShpekov", 3.50, 50);
        Product product2 = new Product("BekonNov", 2.65, 43);
        Product product3 = new Product("MayonezaNiskomaslena", 1.30, 13);
        Product product4 = new Product("Ketchup", 1.80, 73);
        Product product5 = new Product("Jelqzo", 0.70, 20);
        Product product6 = new Product("Belina", .75, 50);
        Product product7 = new Product("Sirene", .77, 50);
        //Act
        stock.add(product1);
        stock.add(product2);
        stock.add(product3);
        stock.add(product4);
        stock.add(product5);
        stock.add(product6);
        stock.add(product7);
        //Assert
        Product[] expected = new Product[] {
                product1,product2,product4,product3,product7,product6,product5
        };
        List<Product> result = new ArrayList<>();
        Iterable<Product> res = stock.findFirstMostExpensiveProducts(stock.getCount());
        for(Product p : res){
            result.add(p);
        }
        Product[] actual = new Product[result.size()];
        for(int i = 0 ; i < result.size(); i++){
            actual[i] = result.get(i);
        }
        Assert.assertArrayEquals(expected, actual);
    }

    //FindByQuantity
    @Test
    public void findAllByQuantity_Should_Return_Correct_Enumeration() {
        //Arrange
        ProductStock stock = new Instock();
        Product product1 = new Product("SalamShpekov", 3.50, 50);
        Product product2 = new Product("BekonNov", 2.65, 43);
        Product product3 = new Product("MayonezaNiskomaslena", 1.30, 13);
        Product product4 = new Product("Ketchup", 1.80, 73);
        Product product5 = new Product("Jelqzo", 0.70, 20);
        Product product6 = new Product("Belina", .75, 50);
        Product product7 = new Product("Sirene", .77, 50);
        //Act
        stock.add(product1);
        stock.add(product2);
        stock.add(product3);
        stock.add(product4);
        stock.add(product5);
        stock.add(product6);
        stock.add(product7);
        //Assert
        Product[] expected = new Product[] {
                product1,product6,product7
        };
        List<Product> result = new ArrayList<>();
        Iterable<Product> res = stock.findAllByQuantity(50);
        for(Product p : res){
            result.add(p);
        }
        Product[] actual = new Product[result.size()];
        for(int i = 0 ; i < result.size(); i++){
            actual[i] = result.get(i);
        }
        Assert.assertArrayEquals(expected, actual);
    }


    @Test
    public void findAllByQuantity_Should_Return_EmptyEnumeration_After_Change_Qty() {
        //Arrange
        ProductStock stock = new Instock();
        Product product1 = new Product("SalamShpekov", 3.50, 50);
        Product product2 = new Product("BekonNov", 2.65, 43);
        Product product3 = new Product("MayonezaNiskomaslena", 1.30, 13);
        Product product4 = new Product("Ketchup", 1.80, 73);
        Product product5 = new Product("Jelqzo", 0.70, 20);
        Product product6 = new Product("Belina", .75, 50);
        Product product7 = new Product("Sirene", .77, 50);
        //Act
        stock.add(product1);
        stock.add(product2);
        stock.add(product3);
        stock.add(product4);
        stock.add(product5);
        stock.add(product6);
        stock.add(product7);
        stock.changeQuantity("Sirene", 5);
        stock.changeQuantity("SalamShpekov", 5);
        stock.changeQuantity("Belina", 5);
        //Assert
        Product[] expected = new Product[0];
        List<Product> result = new ArrayList<>();
        Iterable<Product> res = stock.findAllByQuantity(50);
        for(Product p : res){
            result.add(p);
        }

        Product[] actual = new Product[result.size()];
        for(int i = 0 ; i < result.size(); i++){
            actual[i] = result.get(i);
        }
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void findAllByQuantity_On_WrongArgument_ShouldReturnEmpty_Enumeration() {
        //Arrange
        ProductStock stock = new Instock();
        Product product1 = new Product("SalamShpekov", 3.50, 50);
        Product product2 = new Product("BekonNov", 2.65, 43);
        Product product3 = new Product("MayonezaNiskomaslena", 1.30, 13);
        Product product4 = new Product("Ketchup", 1.80, 73);
        Product product5 = new Product("Jelqzo", 0.70, 20);
        Product product6 = new Product("Belina", .75, 50);
        Product product7 = new Product("Sirene", .77, 50);
        //Act
        stock.add(product1);
        stock.add(product2);
        stock.add(product3);
        stock.add(product4);
        stock.add(product5);
        stock.add(product6);
        stock.add(product7);
        stock.changeQuantity("Sirene", 5);
        stock.changeQuantity("SalamShpekov", 5);
        stock.changeQuantity("Belina", 5);
        //Assert
        Product[] expected = new Product[0];
        List<Product> result = new ArrayList<>();
        Iterable<Product> res = stock.findAllByQuantity(500);
        for (Product p : res) {
            result.add(p);
        }

        Product[] actual = new Product[result.size()];
        for(int i = 0 ; i < result.size(); i++){
            actual[i] = result.get(i);
        }
        Assert.assertArrayEquals(expected, actual);
    }

    //Enumerator
    @Test
    public void enumerator_ShouldReturn_ProductsInInsertionOrder_After_Adding_Multiple() {
        //Arrange
        ProductStock stock = new Instock();
        Product product1 = new Product("SalamShpekov", 3.50, 50);
        Product product2 = new Product("BekonNov", 2.65, 43);
        Product product3 = new Product("MayonezaNiskomaslena", 1.30, 13);
        Product product4 = new Product("Ketchup", 1.80, 73);
        Product product5 = new Product("Jelqzo", 0.70, 20);
        Product product6 = new Product("Belina", .75, 50);
        Product product7 = new Product("Sirene", .77, 50);
        //Act
        stock.add(product1);
        stock.add(product2);
        stock.add(product3);
        stock.add(product4);
        stock.add(product5);
        stock.add(product6);
        stock.add(product7);
        //Assert
        Product[] expected = new Product[] {
                product1,product2,
                product3,product4,
                product5,product6,
                product7,
        };
        Product[] actual = new Product[stock.getCount()];
        int i = 0 ;
        for(Product p : stock){
            actual[i] = p;
            i++;
        }
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void enumerator_ShouldReturn_EmptyEnumeration_On_Empty_Stock() {
        //Arrange
        ProductStock stock = new Instock();
        //Act
        //Assert
        Product[] expected = new Product[0];
        Product[] actual = new Product[stock.getCount()];
        int i = 0 ;
        for(Product product : stock){
            actual[i] = product;
            i++;
        }
        Assert.assertArrayEquals(expected, actual);
    }


    @Test
    public void findAllByPriceRange_On_ExistingRange_ShouldReturn_Correct_Enumeration() {
        //Arrange
        ProductStock stock = new Instock();
        Product product1 = new Product("SalamShpekov", 3.50, 50);
        Product product2 = new Product("BekonNov", 2.65, 43);
        Product product3 = new Product("MayonezaNiskomaslena", 1.30, 13);
        Product product4 = new Product("Ketchup", 1.80, 73);
        Product product5 = new Product("Jelqzo", 0.70, 20);
        Product product6 = new Product("Belina", .75, 50);
        Product product7 = new Product("Sirene", .77, 50);
        Product[] expected = new Product[] {
                product7,product6
        };
        //Act
        stock.add(product1);
        stock.add(product2);
        stock.add(product3);
        stock.add(product4);
        stock.add(product5);
        stock.add(product6);
        stock.add(product7);

        //Assert
        List<Product> result = new ArrayList<>();
        Iterable<Product> res = stock.findAllInRange(0.70, 0.77);
        for (Product p : res) {
            result.add(p);
        }

        Product[] actual = new Product[result.size()];
        for(int i = 0 ; i < result.size(); i++){
            actual[i] = result.get(i);
        }
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void findAllByPriceRange_LowerEndExclusive_HigherEndInclusive_ShouldWorkCorrectly() {
        //Arrange
        ProductStock stock = new Instock();
        Product product1 = new Product("SalamShpekov", 3.50, 50);
        Product product2 = new Product("Kurban", 2.0, 2);
        //Act
        stock.add(product1);
        stock.add(product2);
        //Assert
        Product[] expected = new Product[]{
                product1
        };
        List<Product> result = new ArrayList<>();
        Iterable<Product> res = stock.findAllInRange(2.0, 3.50);
        for (Product p : res) {
            result.add(p);
        }

        Product[] actual = new Product[result.size()];
        for(int i = 0 ; i < result.size(); i++){
            actual[i] = result.get(i);
        }
        Assert.assertArrayEquals(expected, actual);
    }

    //FindAllByPrice
    @Test
    public void findByPrice_On_ExistingItems_ShouldReturn_Correct_Enumeration() {
        //Arrange
        ProductStock stock = new Instock();
        Product product1 = new Product("SalamShpekov", 2.65, 50);
        Product product2 = new Product("BekonNov", 2.65, 43);
        Product product3 = new Product("MayonezaNiskomaslena", 1.30, 13);
        Product product4 = new Product("Ketchup", 2.65, 73);
        Product product5 = new Product("Jelqzo", 0.70, 20);
        Product product6 = new Product("Belina", .75, 50);
        Product product7 = new Product("Sirene", .77, 50);
        Product[] expected = new Product[] {
                product1,product2,product4
        };
        //Act
        stock.add(product1);
        stock.add(product2);
        stock.add(product3);
        stock.add(product4);
        stock.add(product5);
        stock.add(product6);
        stock.add(product7);

        //Assert
        List<Product> result = new ArrayList<>();
        Iterable<Product> res = stock.findAllByPrice(2.65);
        for (Product p : res) {
            result.add(p);
        }

        Product[] actual = new Product[result.size()];
        for(int i = 0 ; i < result.size(); i++){
            actual[i] = result.get(i);
        }
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void findByPrice_On_Non_ExistantPrice_ShouldReturn_Empty_Enumeration() {
        //Arrange
        ProductStock stock = new Instock();
        Product product1 = new Product("SalamShpekov", 3.50, 50);
        Product product2 = new Product("BekonNov", 2.65, 43);
        Product product3 = new Product("MayonezaNiskomaslena", 1.30, 13);

        //Act
        stock.add(product1);
        stock.add(product2);
        stock.add(product3);

        //Assert
        List<Product> result = new ArrayList<>();
        Iterable<Product> res = stock.findAllByPrice(0.70);
        for (Product p : res) {
            result.add(p);
        }

        Product[] actual = new Product[result.size()];
        for(int i = 0 ; i < result.size(); i++){
            actual[i] = result.get(i);
        }
        Assert.assertArrayEquals(new Product[0], actual);
    }

    @Test
    public void findByPrice_UnderFloatingPoint_PrecisionSurcumstances_ShouldNotFail() {
        //Arrange
        ProductStock stock = new Instock();
        Product product1 = new Product("SalamShpekov", 3.50, 50);
        Product product2 = new Product("BekonNov", 2.65, 43);
        Product product3 = new Product("MayonezaNiskomaslena", 1.30, 13);

        //Act
        stock.add(product1);
        stock.add(product2);
        stock.add(product3);

        //Assert
        //Assert
        List<Product> result = new ArrayList<>();
        Iterable<Product> res = stock.findAllByPrice(1.2999999);
        for (Product p : res) {
            result.add(p);
        }

        Product[] actual = new Product[result.size()];
        for(int i = 0 ; i < result.size(); i++){
            actual[i] = result.get(i);
        }
        Assert.assertArrayEquals(new Product[0], actual);
    }

}
