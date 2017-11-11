package _10July2016.models.software;

public class ExpressSoftwareComponent extends SoftwareComponent {


    public ExpressSoftwareComponent(String name, int capacityConsumption, int memoryConsumption) {
        super(name, capacityConsumption, memoryConsumption);
        modifyParams();
    }

    private void modifyParams(){
        super.setMemoryConsumption(super.getMemoryConsumption()*2);
    }

    @Override
    public String getType() {
        return "Express";
    }
}
