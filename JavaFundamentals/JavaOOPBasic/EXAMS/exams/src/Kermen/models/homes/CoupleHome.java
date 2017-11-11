package Kermen.models.homes;

import Kermen.models.items.Device;
import Kermen.models.people.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class CoupleHome extends Home {
    private List<Person> people;
    private List<Device> devices;

    protected CoupleHome() {
        this.people = new ArrayList<>();
        this.devices = new ArrayList<>();

    }

    protected List<Person> getPeople() {
        return Collections.unmodifiableList(this.people);
    }
    protected List<Device> getDevices() {return Collections.unmodifiableList(this.devices);}

    protected void addPerson(Person person){
        this.people.add(person);
    }

    protected void addDevice(Device device){
        this.devices.add(device);
    }

    @Override
    public void payIncome() {
        super.setBudget(super.getBudget() + this.people.stream().mapToDouble(Person::getPayment).sum());
    }

    @Override
    public double getConsumption() {
        double consumption = 0;
        consumption+= getRoomConsumption();
        consumption+= this.devices.stream().mapToDouble(Device::getElectricityCost).sum();
        return consumption;
    }

    @Override
    public int getNumberOfPeople() {
        return this.people.size();
    }
}
