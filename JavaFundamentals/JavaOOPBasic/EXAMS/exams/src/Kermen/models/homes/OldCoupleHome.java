package Kermen.models.homes;

import Kermen.models.items.Device;
import Kermen.models.people.Person;

public class OldCoupleHome extends CoupleHome {

    private static final int NUMBER_OF_ROOMS = 3;
    private static final double ROOM_CONSUMPTION = 15;

    public OldCoupleHome(Person male, Person female, Device TV, Device fridge, Device stove) {
        super();
        super.addPerson(male);
        super.addPerson(female);
        super.addDevice(TV);
        super.addDevice(fridge);
        super.addDevice(stove);
    }

    public double getRoomConsumption(){
        return NUMBER_OF_ROOMS*ROOM_CONSUMPTION;
    }
}
