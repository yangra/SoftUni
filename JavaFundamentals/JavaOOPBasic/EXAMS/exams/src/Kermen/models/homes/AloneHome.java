package Kermen.models.homes;

import Kermen.models.items.Device;
import Kermen.models.people.Person;

import java.util.ArrayList;
import java.util.List;

public abstract class AloneHome extends Home{

    private Person person;
    private List<Device> devices;

    public AloneHome(Person person) {
        this.person = person;
        this.devices = new ArrayList<>();
    }

    public void addDevice(Device device) {
        this.devices.add(device);
    }

    @Override
    public void payIncome() {
        super.setBudget(super.getBudget() + this.person.getPayment());
    }



    @Override
    public double getConsumption() {
        double consumption = 0;
        consumption += this.getRoomConsumption();
        consumption += this.devices.stream().mapToDouble(Device::getElectricityCost).sum();
        return consumption;
    }

    @Override
    public int getNumberOfPeople() {
        return 1;
    }
}
