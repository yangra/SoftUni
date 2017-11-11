package _10July2016.models.hardware;

import _10July2016.models.Component;
import _10July2016.models.software.SoftwareComponent;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class HardwareComponent extends Component {
    private Map<String,SoftwareComponent> software;


    protected HardwareComponent(String name, int capacity, int memory) {
        super(name, "HardwareComponent");

        this.setCapacity(capacity);
        this.setMemory(memory);
        this.software = new LinkedHashMap<>();
    }

    public Map<String, SoftwareComponent> getSoftware() {
        return Collections.unmodifiableMap(this.software);
    }

    @Override
    public int getCapacity() {
        return super.getCapacity();
    }

    @Override
    public int getMemory() {
        return super.getMemory();
    }

    public long getFreeCapacity() {
        return (super.getCapacity() - this.software.values().stream().mapToLong(SoftwareComponent::getCapacityConsumption).sum());
    }

    public long getFreeMemory() {
        return (super.getMemory() - this.software.values().stream().mapToLong(SoftwareComponent::getMemoryConsumption).sum());
    }

    public void registerSoftwareComponent(SoftwareComponent softwareComponent) {
        this.software.put(softwareComponent.getName(), softwareComponent);
    }

    public boolean isPresent(String softwareName){
        if(this.software.containsKey(softwareName)){
            return true;
        }
        return false;
    }

    public void releaseSoftware(String softwareName){
        this.software.remove(softwareName);
    }

    public long getExpressSoftwareCount(){
        return this.software.values().stream().filter(s->s.getType().equalsIgnoreCase("express")).count();
    }

    public long getLightSoftwareCount(){
        return this.software.values().stream().filter(s->s.getType().equalsIgnoreCase("light")).count();
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Hardware Component - %s\n", super.getName()));
        sb.append(String.format("Express Software Components - %d\n", this.getExpressSoftwareCount()));
        sb.append(String.format("Light Software Components - %d\n", this.getLightSoftwareCount()));
        sb.append(String.format("Memory Usage: %d / %d\n",
                this.getMemory() - this.getFreeMemory(), this.getMemory()));
        sb.append(String.format("Capacity Usage: %d / %d\n",
                this.getCapacity() - this.getFreeCapacity(), this.getCapacity()));
        sb.append(String.format("Type: %s\n", this.getType()));
        sb.append(String.format("Software Components: %s\n",
                this.software.size()>0?
                this.software.values().stream().map(SoftwareComponent::getName).collect(Collectors.joining(", ")):
                        "None"));

        return sb.toString();

    }
}
