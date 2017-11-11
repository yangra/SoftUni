package Kermen.models.homes;

import Kermen.models.items.Device;
import Kermen.models.people.Person;

import java.util.List;

public class YoungCoupleHome extends CoupleHome {
    private static final int NUMBER_OF_ROOMS = 2;
    private static final double ROOM_CONSUMPTION = 20;

    public YoungCoupleHome(Person male, Person female, Device TV, Device fridge, Device laptop) {
        super();
        super.addPerson(male);
        super.addPerson(female);
        super.addDevice(TV);
        super.addDevice(fridge);
        super.addDevice(laptop);
        super.addDevice(laptop);
    }
    public double getRoomConsumption(){
        return NUMBER_OF_ROOMS*ROOM_CONSUMPTION;
    }



}
