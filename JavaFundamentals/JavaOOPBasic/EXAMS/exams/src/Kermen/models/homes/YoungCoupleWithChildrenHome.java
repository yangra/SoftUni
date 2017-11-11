package Kermen.models.homes;

import Kermen.models.items.Device;
import Kermen.models.items.Toy;
import Kermen.models.people.Child;
import Kermen.models.people.Person;

import java.util.List;

public class YoungCoupleWithChildrenHome extends YoungCoupleHome {

    private static final int NUMBER_OF_ROOMS = 2;
    private static final double ROOM_CONSUMPTION = 30;

    private List<Child> children;
    public YoungCoupleWithChildrenHome(Person male, Person female, Device TV, Device fridge, Device laptop, List<Child> children) {
        super(male, female, TV, fridge, laptop);
        this.children = children;
    }

    public double getRoomConsumption(){
        return NUMBER_OF_ROOMS*ROOM_CONSUMPTION;
    }

    @Override
    public double getConsumption() {
        double consumption = 0;
        consumption+= getRoomConsumption();
        consumption+= super.getDevices().stream().mapToDouble(Device::getElectricityCost).sum();
        consumption+= this.children.stream()
                .mapToDouble(c->c.getFoodCost()+c.getToys().stream().mapToDouble(Toy::getCost).sum())
                .sum();
        return consumption;
    }

    @Override
    public int getNumberOfPeople() {
        return super.getPeople().size() + this.children.size();
    }
}
