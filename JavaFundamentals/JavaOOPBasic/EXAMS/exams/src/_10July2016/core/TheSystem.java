package _10July2016.core;

import _10July2016.factories.HardwareFactory;
import _10July2016.factories.SoftwareFactory;
import _10July2016.models.hardware.HardwareComponent;
import _10July2016.models.software.SoftwareComponent;

import java.util.*;
import java.util.stream.Collectors;

public class TheSystem {
    private Map<String, HardwareComponent> hardware;
    private Map<String, SoftwareComponent> software;
    private Map<String, HardwareComponent> dump;

    public TheSystem() {
        this.hardware = new LinkedHashMap<>();
        this.software = new LinkedHashMap<>();
        this.dump = new HashMap<>();
    }

    /*
    void registerPowerHardware(String name, int capacity, int memory)
void registerHeavyHardware(String name, int capacity, int memory)
void registerExpressSoftware(String hardwareComponentName, String name, int capacity, int memory)
void registerLightSoftware(String hardwareComponentName, String name, int capacity, int memory)
void releaseSoftwareComponent(String hardwareComponentName, String softwareComponentName)
String analyze()
String split()

     */

    public void registerPowerHardware(String name, int capacity, int memory) {
        HardwareComponent hardwareComponent = HardwareFactory.makePowerHardware(name,capacity, memory);
        this.hardware.put(name,hardwareComponent);
    }

    public void registerHeavyHardware(String name, int capacity, int memory) {
        HardwareComponent hardwareComponent = HardwareFactory.makeHeavyHardware(name,capacity, memory);
        this.hardware.put(name,hardwareComponent);
    }

    public void registerExpressSoftware(String hardware, String name, int capacity, int memory) {
        SoftwareComponent softwareComponent = SoftwareFactory.makeExpressSoftware(name, capacity, memory);

        if (!this.hardware.containsKey(hardware)) {
            return;
        }

        if (this.hardware.get(hardware).getFreeCapacity() < softwareComponent.getCapacityConsumption() ||
                this.hardware.get(hardware).getFreeMemory() < softwareComponent.getMemoryConsumption()) {
            return;
        }

        this.software.put(name, softwareComponent);
        this.hardware.get(hardware).registerSoftwareComponent(softwareComponent);
    }

    public void registerLightSoftware(String hardware, String name, int capacity, int memory) {
        SoftwareComponent softwareComponent = SoftwareFactory.makeLightSoftware(name, capacity, memory);

        if (!this.hardware.containsKey(hardware)) {
            return;
        }

        if (this.hardware.get(hardware).getFreeCapacity() < softwareComponent.getCapacityConsumption() ||
                this.hardware.get(hardware).getFreeMemory() < softwareComponent.getMemoryConsumption()) {
            return;
        }

        this.software.put(name, softwareComponent);
        this.hardware.get(hardware).registerSoftwareComponent(softwareComponent);
    }

    public void releaseSoftwareComponent(String hardwareName, String softwareName) {

        if (!this.hardware.containsKey(hardwareName)) {
            return;
        }

        if (!this.hardware.get(hardwareName).isPresent(softwareName)) {
            return;
        }

        this.hardware.get(hardwareName).releaseSoftware(softwareName);
        this.software.remove(softwareName);

    }

    public void dump(String hardwareName) {
        if (!this.hardware.containsKey(hardwareName)) {
            return;
        }

        this.dump.put(hardwareName, this.hardware.remove(hardwareName));
        for (SoftwareComponent sw : dump.get(hardwareName).getSoftware().values()) {
            this.software.remove(sw.getName());
        }
    }


    public void restore(String hardwareName) {
        if (!this.dump.containsKey(hardwareName)) {
            return;
        }

        this.hardware.put(hardwareName, this.dump.remove(hardwareName));
        for (SoftwareComponent sw : hardware.get(hardwareName).getSoftware().values()) {
            this.software.put(sw.getName(), sw);
        }

    }

    public void destroy(String hardwareName) {
        if (!this.dump.containsKey(hardwareName)) {
            return;
        }

        this.dump.remove(hardwareName);
    }

    public String analyze() {
        StringBuilder sb = new StringBuilder();
        sb.append("System Analysis\n");
        sb.append(String.format("Hardware Components: %d\n", this.hardware.size()));
        sb.append(String.format("Software Components: %d\n", this.software.size()));
        sb.append(String.format("Total Operational Memory: %d / %d\n", getMemoryInUse(), getMaxMemory()));
        sb.append(String.format("Total Capacity Taken: %d / %d", getTotalTakenCapacity(), getMaxCapacity()));
        return sb.toString();
    }

    public String dumpAnalyze() {
        StringBuilder sb = new StringBuilder();
        sb.append("Dump Analysis\n");
        sb.append(String.format("Power Hardware Components: %d\n",
                this.dump.values().stream().filter(h -> h.getType().equalsIgnoreCase("power")).count()));
        sb.append(String.format("Heavy Hardware Components: %d\n",
                this.dump.values().stream().filter(h -> h.getType().equalsIgnoreCase("heavy")).count()));
        sb.append(String.format("Express Software Components: %d\n",
                this.dump.values().stream().mapToLong(h -> h.getExpressSoftwareCount()).sum()));
        sb.append(String.format("Light Software Components: %d\n",
                this.dump.values().stream().mapToLong(h -> h.getLightSoftwareCount()).sum()));
        sb.append(String.format("Total Dumped Memory: %d\n",
                this.dump.values().stream().mapToLong(h -> h.getMemory() - h.getFreeMemory()).sum()));
        sb.append(String.format("Total Dumped Capacity: %d",
                this.dump.values().stream().mapToLong(h -> h.getCapacity() - h.getFreeCapacity()).sum()));
        return sb.toString();
    }

    public String split() {
        StringBuilder sb = new StringBuilder();
        List<HardwareComponent> result = this.hardware.values().stream()
                .sorted(Comparator.comparing(c->c.getClass().getSimpleName()).reversed())
                .collect(Collectors.toList());
        for (HardwareComponent hardwareComponent : result) {
            sb.append(hardwareComponent.toString());
        }

        return sb.toString();
    }


    private long getMemoryInUse() {
        return this.software.values().stream().mapToLong(SoftwareComponent::getMemoryConsumption).sum();
    }

    private long getMaxMemory() {
        return this.hardware.values().stream().mapToLong(HardwareComponent::getMemory).sum();
    }

    private long getTotalTakenCapacity() {
        return this.software.values().stream().mapToLong(SoftwareComponent::getCapacityConsumption).sum();
    }

    private long getMaxCapacity() {
        return this.hardware.values().stream().mapToLong(HardwareComponent::getCapacity).sum();
    }



}
