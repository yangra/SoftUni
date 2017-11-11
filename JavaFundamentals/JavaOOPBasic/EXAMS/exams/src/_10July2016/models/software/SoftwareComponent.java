package _10July2016.models.software;

import _10July2016.models.Component;

public abstract class SoftwareComponent extends Component {

    public SoftwareComponent(String name, int capacityConsumption, int memoryConsumption) {
        super(name, "SoftwareComponent");
        this.setCapacityConsumption(capacityConsumption);
        this.setMemoryConsumption(memoryConsumption);
    }

    public int getCapacityConsumption() {
        return super.getCapacity();
    }

    protected void setCapacityConsumption(int capacityConsumption) {
        super.setCapacity(capacityConsumption);
    }

    public int getMemoryConsumption() {
        return super.getMemory();
    }

    protected void setMemoryConsumption(int memoryConsumption) {
        super.setMemory(memoryConsumption);
    }
}
