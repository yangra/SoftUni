package Kermen.factories;

import Kermen.models.homes.*;
import Kermen.models.items.Device;
import Kermen.models.people.Child;
import Kermen.models.people.Person;

import java.util.List;

public final class HomeFactory {
    private HomeFactory() {
    }

    public static Home createAloneYoungHome(Person person, Device laptop) {
        return new AloneYoungHome(person, laptop);
    }

    public static Home createAloneOldHome(Person person) {
        return new AloneOldHome(person);
    }

    public static Home createOldCoupleHome(Person male, Person female, Device tv, Device fridge, Device stove) {
        return new OldCoupleHome(male, female, tv, fridge, stove);
    }

    public static Home createYoungCoupleHome(Person male, Person female, Device tv, Device fridge, Device laptop) {
        return new YoungCoupleHome(male, female, tv, fridge, laptop);
    }

    public static Home createYoungCoupleWithChildrenHome(Person male, Person female, Device tv, Device fridge, Device laptop, List<Child> children) {
        return new YoungCoupleWithChildrenHome(male, female, tv, fridge, laptop, children);
    }
}
