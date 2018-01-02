package _02DatabaseExtended;

import javax.naming.OperationNotSupportedException;

public class Main {
    public static void main(String[] args) {
        try{
        Database<Person> database = new DatabaseImpl(16);
        Person person1 = new Person(124L, "fofi");
        Person person2 = new Person(12L, "fofi");
        database.add(person1);
        database.add(person2);
        }catch (OperationNotSupportedException onse){
            onse.printStackTrace();
        }
    }
}
