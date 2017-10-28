package _10FamilyTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Person implements Comparable<Person> {
    private String name;
    private String birthDate;
    private List<Person> parents;
    private List<Person> children;

    public Person() {
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    void setName(String name) {
        this.name = name;
    }

    void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    String getName() {
        return name;
    }

    String getBirthDate() {
        return birthDate;
    }

    public List<Person> getParents() {
        return Collections.unmodifiableList(parents);
    }

    public List<Person> getChildren() {
        return Collections.unmodifiableList(children);
    }

    void addChild(Person child) {
        this.children.add(child);
    }

    void addParent(Person parent) {
        this.parents.add(parent);
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.getName(), this.getBirthDate());
    }

    @Override
    public int compareTo(Person other) {
        if (this.getName().compareTo(other.getName()) == 0 && this.getBirthDate().compareTo(other.getBirthDate()) == 0)
            return 0;

        return -1;
    }
}
