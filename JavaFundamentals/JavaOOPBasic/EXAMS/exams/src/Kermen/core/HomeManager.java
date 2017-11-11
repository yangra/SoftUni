package Kermen.core;

import Kermen.factories.HomeFactory;
import Kermen.models.City;
import Kermen.models.homes.Home;
import Kermen.models.items.Device;
import Kermen.models.items.Toy;
import Kermen.models.people.Child;
import Kermen.models.people.Person;

import java.util.ArrayList;
import java.util.List;

public class HomeManager {

    private City city;

    public HomeManager() {
        this.city = new City();
    }

    public void registerYoungCoupleWithChildren(List<String> homeArgs, List<List<String>> inputChildren) {
        Person male = new Person(Double.parseDouble(homeArgs.get(0)));
        Person female = new Person(Double.parseDouble(homeArgs.get(1)));
        Device tv = new Device(Double.parseDouble(homeArgs.get(2)));
        Device fridge = new Device(Double.parseDouble(homeArgs.get(3)));
        Device laptop = new Device(Double.parseDouble(homeArgs.get(4)));

        List<Child> children = new ArrayList<>();
        for (List<String> kid : inputChildren) {
            double foodCost = Double.parseDouble(kid.get(0));
            List<Toy> toys = new ArrayList<>();
            for (int i = 1; i < kid.size(); i++) {
                Toy toy = new Toy(Double.parseDouble(kid.get(i)));
                toys.add(toy);
            }
            Child child = new Child(foodCost,toys);
            children.add(child);
        }

        Home home = HomeFactory.createYoungCoupleWithChildrenHome(male,female,tv,fridge,laptop,children);
        this.city.addHome(home);
    }

    public void registerYoungCouple(List<String> homeArgs) {
        Person male = new Person(Double.parseDouble(homeArgs.get(0)));
        Person female = new Person(Double.parseDouble(homeArgs.get(1)));
        Device tv = new Device(Double.parseDouble(homeArgs.get(2)));
        Device fridge = new Device(Double.parseDouble(homeArgs.get(3)));
        Device laptop = new Device(Double.parseDouble(homeArgs.get(4)));
        Home home = HomeFactory.createYoungCoupleHome(male, female, tv,fridge,laptop);
        this.city.addHome(home);
    }


    public void registerAloneYoung(List<String> homeArgs) {
        Person person = new Person(Double.parseDouble(homeArgs.get(0)));
        Device laptop = new Device(Double.parseDouble(homeArgs.get(1)));
        Home home = HomeFactory.createAloneYoungHome(person,laptop);
        this.city.addHome(home);
    }

    public void registerAloneOld(List<String> homeArgs) {
        Person person = new Person(Double.parseDouble(homeArgs.get(0)));
        Home home = HomeFactory.createAloneOldHome(person);
        this.city.addHome(home);
    }

    public void registerOldCouple(List<String> homeArgs) {
        Person male = new Person(Double.parseDouble(homeArgs.get(0)));
        Person female = new Person(Double.parseDouble(homeArgs.get(1)));
        Device tv = new Device(Double.parseDouble(homeArgs.get(2)));
        Device fridge = new Device(Double.parseDouble(homeArgs.get(3)));
        Device stove = new Device(Double.parseDouble(homeArgs.get(4)));

        Home home = HomeFactory.createOldCoupleHome(male, female, tv,fridge,stove);
        this.city.addHome(home);
    }

    public void paySalaries() {
        this.city.paySalaries();
    }

    public double calculateConsumption() {
       return this.city.calculateConsumption();
    }

    public void payAllBills() {
        this.city.payAllBills();
    }

    public int getPopulation(){
       return this.city.getPopulation();
    }
}
