package _01Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseImplTest {

    private static final int EXPECTED_ARRAY_SIZE = 4;
    private static final int EXPECTED_DB_SIZE_AFTER_REMOVE = 2;
    private static final int EXPECTED_SIZE_OF_FETCHED_DB = 3;


    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorWithLesserCapacity() throws OperationNotSupportedException {
        Database<Integer> database = new DatabaseImpl(12, 47, 15, 42);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addElementToAFullDatabase() throws Exception {
        Integer[] ints = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        Database<Integer> database = new DatabaseImpl(16, ints);
        database.add(12);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addANullElementToDatabase() throws Exception {
        Database<Integer> database = new DatabaseImpl(16, 1, 2, 3);
        Integer num = null;
        database.add(num);
    }

    @Test
    public void addElementToDatabase() throws Exception {
        Database<Integer> database = new DatabaseImpl(16, 1, 2, 3);
        database.add(12);
        Assert.assertEquals("Element not added in a proper way", EXPECTED_ARRAY_SIZE, database.fetchAll().length);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void removeElementFromAnEmptyDatabase() throws Exception {
        Database<Integer> database = new DatabaseImpl(16 );
        database.remove();
    }

    @Test
    public void removeElementFromDatabase() throws Exception {
        Database<Integer> database = new DatabaseImpl(16, 1,2,3 );
        database.remove();
        Assert.assertEquals("Does not remove element in a proper way",
                EXPECTED_DB_SIZE_AFTER_REMOVE, database.fetchAll().length);
    }


    @Test
    public void fetchAllTest() throws Exception {
        Database<Integer> database = new DatabaseImpl(16, 1,2,3 );
        Assert.assertEquals("Does not fetch the elements properly", EXPECTED_SIZE_OF_FETCHED_DB,
                database.fetchAll().length);
    }

}