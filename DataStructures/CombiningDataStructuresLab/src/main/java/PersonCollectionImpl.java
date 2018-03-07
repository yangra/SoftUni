import java.util.*;

public class PersonCollectionImpl implements PersonCollection {

    private Map<String, Person> byEmail;
    private Map<String, Map<String, Person>> byDomain;
    private Map<String, Map<String, Person>> byNameTown;
    private Map<Integer, Map<String, Person>> byAge;
    private Map<String, Map<Integer, Map<String, Person>>> byAgeTown;

    public PersonCollectionImpl() {
        this.byEmail = new HashMap<>();
        this.byDomain = new HashMap<>();
        this.byNameTown = new HashMap<>();
        this.byAge = new TreeMap<>();
        this.byAgeTown = new HashMap<>();
    }

    @Override
    public boolean addPerson(String email, String name, int age, String town) {
        if (this.byEmail.containsKey(email)) {
            return false;
        }

        Person person = new Person(email, name, age, town);
        this.byEmail.put(email, person);
        this.addByDomain(person);
        this.addByNameTown(person);
        this.addByAge(person);
        this.addByAgeTown(person);
        return true;
    }


    private void addByDomain(Person person) {
        String domain = person.getEmail().split("@")[1];
        if (!this.byDomain.containsKey(domain)) {
            this.byDomain.put(domain, new TreeMap<>());
        }

        this.byDomain.get(domain).put(person.getEmail(), person);
    }

    private void addByNameTown(Person person) {
        String nameTown = person.getName() + person.getTown();
        if (!this.byNameTown.containsKey(nameTown)) {
            this.byNameTown.put(nameTown, new TreeMap<>());
        }

        this.byNameTown.get(nameTown).put(person.getEmail(), person);
    }

    private void addByAge(Person person) {
        if (!this.byAge.containsKey(person.getAge())) {
            this.byAge.put(person.getAge(), new TreeMap<>());
        }

        this.byAge.get(person.getAge()).put(person.getEmail(), person);
    }

    private void addByAgeTown(Person person) {

        if (!this.byAgeTown.containsKey(person.getTown())) {
            this.byAgeTown.put(person.getTown(), new TreeMap<>());
        }

        if (!this.byAgeTown.get(person.getTown()).containsKey(person.getAge())) {
            this.byAgeTown.get(person.getTown()).put(person.getAge(), new TreeMap<>());
        }

        Map<String, Person> byEmail = this.byAgeTown.get(person.getTown()).get(person.getAge());
        byEmail.put(person.getEmail(),person);

        Map<Integer, Map<String, Person>> byAge = this.byAgeTown.get(person.getTown());
        byAge.put(person.getAge(),byEmail);

        this.byAgeTown.put(person.getTown(),byAge);


    }


    @Override
    public int getCount() {
        return this.byEmail.size();
    }

    @Override
    public Person findPerson(String email) {
        if (!this.byEmail.containsKey(email)) {
            return null;
        }

        return this.byEmail.get(email);
    }

    @Override
    public boolean deletePerson(String email) {
        if(!this.byEmail.containsKey(email)){
            return  false;
        }
        Person person = this.byEmail.get(email);

        this.removeFromByAgeTown(person);
        this.removeFromByAge(person);
        this.removeFromByNameTown(person);
        this.removeFromByDomain(person);

        this.byEmail.remove(email);

        return true;
    }

    private void removeFromByAgeTown(Person person) {
        this.byAgeTown.get(person.getTown()).get(person.getAge()).remove(person.getEmail());
    }


    private void removeFromByAge(Person person) {
        this.byAge.get(person.getAge()).remove(person.getEmail());
    }

    private void removeFromByNameTown(Person person) {
        this.byNameTown.get(person.getName()+person.getTown()).remove(person.getEmail());
    }

    private void removeFromByDomain(Person person) {
        String domain = person.getEmail().split("@")[1];
        this.byDomain.get(domain).remove(person.getEmail());
    }

    @Override
    public Iterable<Person> findPersons(String emailDomain) {
        if(!this.byDomain.containsKey(emailDomain)){
            return new ArrayList<>();
        }

        return this.byDomain.get(emailDomain).values();
    }

    @Override
    public Iterable<Person> findPersons(String name, String town) {
        if(!this.byNameTown.containsKey(name+town)){
            return new ArrayList<>();
        }

        return this.byNameTown.get(name + town).values();
    }

    @Override
    public Iterable<Person> findPersons(int startAge, int endAge) {
        List<Map<String, Person>> range = new ArrayList<>();
        for (Integer integer : this.byAge.keySet()) {
            if (integer >= startAge && integer <= endAge) {
                range.add(this.byAge.get(integer));
            }
        }

        List<Person> result = new ArrayList<>();
        for (Map<String, Person> map : range) {
            result.addAll(map.values());
        }

        return result;
    }

    @Override
    public Iterable<Person> findPersons(int startAge, int endAge, String town) {
        Map<Integer, Map<String, Person>> byTown = this.byAgeTown.get(town);
        if(byTown == null){
            return new ArrayList<>();
        }
        List<Map<String, Person>> range = new ArrayList<>();
        for (Integer integer : byTown.keySet()) {
            if (integer >= startAge && integer <= endAge) {
                range.add(byTown.get(integer));
            }
        }

        List<Person> result = new ArrayList<>();
        for (Map<String, Person> map : range) {
            result.addAll(map.values());
        }

        return result;
    }
}
