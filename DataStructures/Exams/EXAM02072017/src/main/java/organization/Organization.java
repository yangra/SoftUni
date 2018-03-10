package organization;

import java.util.*;

public class Organization implements IOrganization {


    private List<Person> byInsert;
    private Map<String, LinkedList<Person>> byName;
    private Set<Integer> byNameLength;
    private AVL<Person> people;


    public Organization() {
        this.byInsert = new ArrayList<>();
        this.byName = new HashMap<>();
        this.byNameLength = new HashSet<>();
        this.people = new AVL<>();
    }

    @Override
    public int getCount() {
        return this.byInsert.size();
    }

    @Override
    public boolean contains(Person person) {
        return this.people.contains(person);
    }

    @Override
    public boolean containsByName(String name) {
        return this.byName.containsKey(name);
    }

    @Override
    public void add(Person person) {
        this.byInsert.add(person);
        if (!this.byName.containsKey(person.getName())) {
            this.byName.put(person.getName(), new LinkedList<>());
        }
        this.byName.get(person.getName()).add(person);
        this.byNameLength.add(person.getName().length());
        this.people.insert(person);
    }

    @Override
    public Person getAtIndex(int index) {
        if(index<0||index>=this.byInsert.size()){
            throw new IllegalArgumentException();
        }
        return this.byInsert.get(index);
    }

    @Override
    public Iterable<Person> getByName(String name) {
        if(!this.byName.containsKey(name)){
            return new ArrayList<>();
        }
        return this.byName.get(name);
    }

    @Override
    public Iterable<Person> firstByInsertOrder() {
        return this.byInsert.subList(0, 1);
    }

    @Override
    public Iterable<Person> firstByInsertOrder(int count) {
        if (this.byInsert.size() < count) {
            return this.byInsert;
        }
        return this.byInsert.subList(0, count);
    }

    @Override
    public Iterable<Person> searchWithNameSize(int minLength, int maxLength) {
        List<Person> result = new ArrayList<>();
        for (String name : this.byName.keySet()) {
            if (name.length() >= minLength && name.length() <= maxLength) {
                result.addAll(this.byName.get(name));
            }
        }
        return result;
    }

    @Override
    public Iterable<Person> getWithNameSize(int length) {
        if(!this.byNameLength.contains(length)){
            throw new IllegalArgumentException();
        }
        List<Person> result = new ArrayList<>();
        for (String name : this.byName.keySet()) {
            if (name.length() == length) {
                result.addAll(this.byName.get(name));
            }
        }
        return result;
    }

    @Override
    public Iterable<Person> peopleByInsertOrder() {
        return this.byInsert;
    }

    @Override
    public Iterator<Person> iterator() {
        return this.byInsert.iterator();
    }
}
