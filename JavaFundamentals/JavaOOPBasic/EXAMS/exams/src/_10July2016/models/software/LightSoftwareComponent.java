package _10July2016.models.software;

public class LightSoftwareComponent extends SoftwareComponent {


    public LightSoftwareComponent(String name, int capacityConsumption, int memoryConsumption) {
        super(name, capacityConsumption, memoryConsumption);
        modifyParams();
    }

    private void modifyParams() {
        super.setCapacityConsumption(super.getCapacityConsumption() + (super.getCapacityConsumption() / 2));
        super.setMemoryConsumption(super.getMemoryConsumption() - (super.getMemoryConsumption() / 2));
    }

    @Override
    public String getType() {
        return "Light";
    }
}
