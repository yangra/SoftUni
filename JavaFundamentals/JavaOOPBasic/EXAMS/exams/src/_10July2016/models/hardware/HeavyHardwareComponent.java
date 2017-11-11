package _10July2016.models.hardware;

public class HeavyHardwareComponent extends HardwareComponent {

    public HeavyHardwareComponent(String name, int capacity, int memory) {
        super(name, capacity, memory);
        modifyParams();
    }

    private void modifyParams() {
        super.setCapacity(this.getCapacity() * 2);
        super.setMemory(super.getMemory() - (super.getMemory() / 4));
    }

    @Override
    public String getType() {
        return "Heavy";
    }
}
