package _10July2016.models.hardware;

public class PowerHardwareComponent extends HardwareComponent {


    public PowerHardwareComponent(String name, int capacity, int memory) {
        super(name, capacity, memory);
        modifyParams();
    }

    @Override
    public String getType() {
        return "Power";
    }

    private void modifyParams() {
        super.setCapacity(super.getCapacity() - ((super.getCapacity() * 3) / 4));
        super.setMemory(super.getMemory() + ((super.getMemory() * 3) / 4));
    }
}
