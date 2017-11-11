package Kermen.models.homes;

import Kermen.models.items.Device;
import Kermen.models.people.Person;

public class AloneYoungHome extends AloneHome {

    private static final int NUMBER_OF_ROOMS = 1;
    private static final double ROOM_CONSUMPTION = 10;

    public AloneYoungHome(Person person, Device laptop) {
        super(person);
        super.addDevice(laptop);
    }

    public double getRoomConsumption(){
        return NUMBER_OF_ROOMS*ROOM_CONSUMPTION;
    }
}
