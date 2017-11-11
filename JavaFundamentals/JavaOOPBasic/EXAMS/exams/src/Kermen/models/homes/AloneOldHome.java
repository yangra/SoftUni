package Kermen.models.homes;

import Kermen.models.people.Person;

public class AloneOldHome extends AloneHome {
    private static final int NUMBER_OF_ROOMS = 1;
    private static final double ROOM_CONSUMPTION = 15;

    public AloneOldHome(Person person) {
        super(person);
    }


    public double getRoomConsumption(){
        return NUMBER_OF_ROOMS*ROOM_CONSUMPTION;
    }


}
