package test.bg.softuni.dataStructures;

import main.bg.softuni.dataStructures.SimpleSortedList;
import main.bg.softuni.dataStructures.contracts.SimpleOrderedBag;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SimpleOrderedBagTests {

    private SimpleOrderedBag<String> names;

    @Before
    public void setUp() {
        this.names = new SimpleSortedList<>(String.class);
    }

    @Test
    public void testEmptyCtor() {
        this.names = new SimpleSortedList<>(String.class);
        Assert.assertEquals(16, this.names.capacity());
        Assert.assertEquals(0, this.names.size());
    }

    @Test
    public void testCtorWithInitialCapacity() {
        this.names = new SimpleSortedList<>(String.class, 20);
        Assert.assertEquals(20, this.names.capacity());
        Assert.assertEquals(0, this.names.size());
    }

    @Test
    public void testCtorWithInitialComparer() {
        this.names = new SimpleSortedList<>(String.class, String.CASE_INSENSITIVE_ORDER);
        Assert.assertEquals(16, this.names.capacity());
        Assert.assertEquals(0, this.names.size());
    }

    @Test
    public void testCtorWithAllParams() {
        this.names = new SimpleSortedList<>(String.class, String.CASE_INSENSITIVE_ORDER, 30);
        Assert.assertEquals(30, this.names.capacity());
        Assert.assertEquals(0, this.names.size());
    }

    @Test
    public void testAddIncreasesSize() {
        this.names.add("Nasko");
        Assert.assertEquals(1, this.names.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddNullThrowsException() {
        this.names.add(null);
    }

    @Test
    public void testAddUnsortedDataIsHeldSorted() {
        this.names.add("Rosen");
        this.names.add("Georgi");
        this.names.add("Balkan");

        Iterator<String> iterator = this.names.iterator();

        Assert.assertEquals("Balkan",iterator.next());
        Assert.assertEquals("Georgi",iterator.next());
        Assert.assertEquals("Rosen",iterator.next());
    }

    @Test
    public void testAddingMoreThanInitialCapacity() {
        for (int i = 0; i < 17; i++) {
            this.names.add("Name");
        }

        Assert.assertEquals("Size does not increase as expected",17, this.names.size());
        Assert.assertNotEquals("Capacity does not change",16, this.names.capacity());

    }

    @Test
    public void testAddingAllFromCollectionIncreasesSize() {
        List<String> collection = new ArrayList<>();
        collection.add("Pesho");
        collection.add("Gosho");

        this.names.addAll(collection);

        Assert.assertEquals(2, this.names.size());

    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddingAllFromNullThrowsException() {
        this.names.addAll(null);
    }

    @Test
    public void testAddAllKeepsSorted() {
        List<String> collection = new ArrayList<>(Arrays.asList("Pesho", "Gosho", "Minka"));
        this.names.addAll(collection);

        Iterator<String> iterator = this.names.iterator();
        Assert.assertEquals("Gosho", iterator.next());
        Assert.assertEquals("Minka", iterator.next());
        Assert.assertEquals("Pesho", iterator.next());
    }

    @Test
    public void testRemoveValidElementDecreasesSize() {
        this.names.add("Pesho");
        this.names.remove("Pesho");

        Assert.assertEquals(0, this.names.size());
    }


    @Test
    public void testRemoveValidElementRemovesSelectedOne() {
        this.names.add("Ivan");
        this.names.add("Nasko");
        this.names.remove("Nasko");

        Assert.assertEquals(1, this.names.size());
        Assert.assertEquals("Ivan", this.names.iterator().next());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemovingNullThrowsException() {
        this.names.remove(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testJoinWithNull() {
        this.names.joinWith(null);
    }

    @Test
    public void testJoinWorksFine() {
        this.names.add("Nasko");
        this.names.add("Ivan");
        this.names.add("Pesho");

        Assert.assertEquals("Ivan, Nasko, Pesho", this.names.joinWith(", "));
    }

}
