package _02DatabaseExtended;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseImplTest {

    public static final int INITIAL_DB_CAPACITY = 16;

    @Test(expected = OperationNotSupportedException.class)
    public void createNewDatabaseWithCapacityDifferentFrom16() throws Exception {
        Database<Person> database = new DatabaseImpl(12);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addANullPersonToDatabase() throws Exception {
        Database<Person> database = new DatabaseImpl(16);
        Person person = null;
        database.add(person);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addAPersonWithExistingUsernameToDB() throws Exception {
        Database<Person> database = new DatabaseImpl(INITIAL_DB_CAPACITY);
        Person personMock1 = Mockito.mock(Person.class);
        Mockito.when(personMock1.getUsername()).thenReturn("fofi");
        Mockito.when(personMock1.getId()).thenReturn(124L);
        Person personMock2 = Mockito.mock(Person.class);
        Mockito.when(personMock2.getUsername()).thenReturn("fofi");
        Mockito.when(personMock2.getId()).thenReturn(12L);
        database.add(personMock1);
        database.add(personMock2);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addAPersonWithExistingIdToDB() throws Exception {
        Database<Person> database = new DatabaseImpl(16);
        Person person = Mockito.mock(Person.class);
        Mockito.when(person.getId()).thenReturn(123L);
        database.add(person);
        database.add(person);
    }

    @Test
    public void remove() throws Exception {
    }

    @Test
    public void findByUsername() throws Exception {
    }

    @Test
    public void findById() throws Exception {
    }

    @Test
    public void fetchAll() throws Exception {
    }

}