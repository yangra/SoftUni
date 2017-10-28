package _09Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Car car;
    private Company company;
    private List<Pokemon> pokemons;
    private List<Human> children;
    private List<Human> parents;

    public Person(String name) {
        this.name = name;
        this.pokemons = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public List<Human> getChildren() {
        return children;
    }

    public List<Human> getParents() {
        return parents;
    }



    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.name).append("\n");
        builder.append("Company:\n").append(this.company!=null?this.company:"");
        builder.append("Car:\n").append(this.car!=null?this.car:"");
        builder.append("Pokemon:\n");
        for (Pokemon pokemon : pokemons) {
            builder.append(pokemon.toString()).append("\n");
        }

        builder.append("Parents:\n");
        for (Human parent : parents) {
            builder.append(parent.toString()).append("\n");
        }

        builder.append("Children:\n");
        for (Human child : children) {
            builder.append(child.toString()).append("\n");
        }

        return builder.toString();
    }

    class Human{
        private String name;
        private String birthday;

        public Human(String name, String birthday) {
            this.name = name;
            this.birthday = birthday;
        }

        @Override
        public String toString() {
            return String.format("%s %s", this.name, this.birthday);
        }
    }

    class Pokemon{
        private String name;
        private String type;

        public Pokemon(String name, String type) {
            this.name = name;
            this.type = type;
        }

        @Override
        public String toString() {
            return String.format("%s %s", this.name, this.type);
        }
    }
    class Company{
        private String name;
        private String department;
        private double salary;

        public Company(String name, String department, double salary) {
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return String.format("%s %s %.2f\n", this.name, this.department, this.salary);
        }
    }
    class Car{
        private String model;
        private int speed;

        public Car(String model, int speed) {
            this.model = model;
            this.speed = speed;
        }

        @Override
        public String toString() {
            return String.format("%s %d\n", this.model, this.speed);
        }
    }
}
