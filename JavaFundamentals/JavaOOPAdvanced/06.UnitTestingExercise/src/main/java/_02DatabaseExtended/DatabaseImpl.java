package _02DatabaseExtended;

import javax.naming.OperationNotSupportedException;
import java.util.Arrays;

public class DatabaseImpl implements Database<Person> {
    private Person[] people;
    private int index;

    public DatabaseImpl(int capacity) throws OperationNotSupportedException {
        if (capacity != 16) {
            throw new OperationNotSupportedException("Database capacity must be 16.");
        }

        this.people = new Person[capacity];
    }


    @Override
    public void add(Person person) throws OperationNotSupportedException {
        if (person == null) {
            throw new OperationNotSupportedException("You cannot add a null.");
        }

        if (this.index >= 16) {
            throw new OperationNotSupportedException("Capacity already full.");
        }

        if (this.index>0&&Arrays.stream(this.people).filter(p ->person.getId() == p.getId()).count() != 0) {
            throw new OperationNotSupportedException("There can be only one person with this id");
        }

        if(this.index>0&&Arrays.stream(this.people).filter(p->person.getUsername().equals(p.getUsername())).count()!=0){
            throw new OperationNotSupportedException("Username already taken");
        }

        if(person.getId()<0){
            throw new OperationNotSupportedException("Id cannot be negative");
        }

        this.people[index++] = person;
    }

    @Override
    public Person remove() throws OperationNotSupportedException {

        if (this.index == 0) {
            throw new OperationNotSupportedException("Database is empty, there's nothing to remove");
        }

        Person person = this.people[--this.index];
        this.people[this.index] = null;
        return person;
    }

    @Override
    public Person findByUsername(String username) throws OperationNotSupportedException {
        if(username == null){
            throw new OperationNotSupportedException("Username cannot be null");
        }

        if(Arrays.stream(this.people).filter(p->p.getUsername().equals(username)).count()==0){
            throw new OperationNotSupportedException("No person with that username");
        }

        return Arrays.stream(this.people).filter(p->p.getUsername().equals(username)).findFirst().get();
    }

    @Override
    public Person findById(long id) throws OperationNotSupportedException {
        if(Arrays.stream(this.people).filter(p->p.getId()==id).count()==0){
            throw new OperationNotSupportedException("No person with that id");
        }

        return Arrays.stream(this.people).filter(p->p.getId()==id).findFirst().get();
    }

    @Override
    public Person[] fetchAll() {
        return Arrays.copyOf(this.people, index);
    }
}
