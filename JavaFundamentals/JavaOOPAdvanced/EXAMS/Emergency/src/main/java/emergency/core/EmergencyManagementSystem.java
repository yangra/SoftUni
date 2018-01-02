package emergency.core;

import emergency.collection.EmergencyRegister;
import emergency.factories.EmergencyCenterFactory;
import emergency.factories.EmergencyFactory;
import emergency.interfaces.Emergency;
import emergency.interfaces.EmergencyCenter;
import emergency.interfaces.Register;

import java.util.*;

public class EmergencyManagementSystem {

    private Map<String, Register> emergencyRegisters;
    private Deque<EmergencyCenter> emergencyHealthCenters;
    private Deque<EmergencyCenter> emergencyFireCenters;
    private Deque<EmergencyCenter> emergencyPoliceCenters;

    public EmergencyManagementSystem() {
        initRegisters();
        this.emergencyHealthCenters = new ArrayDeque<>();
        this.emergencyFireCenters = new ArrayDeque<>();
        this.emergencyPoliceCenters = new ArrayDeque<>();
    }

    private void initRegisters() {
        this.emergencyRegisters = new LinkedHashMap<>();
        this.emergencyRegisters.put("Order", new EmergencyRegister());
        this.emergencyRegisters.put("Health", new EmergencyRegister());
        this.emergencyRegisters.put("Property", new EmergencyRegister());
    }


    public String registerPropertyEmergency(List<String> params) {
        Emergency emergency = EmergencyFactory.createPropertyEmergency(params.get(0), params.get(1), params.get(2), params.get(3));
        this.emergencyRegisters.get("Property").enqueueEmergency(emergency);
        return String.format("Registered Public Property Emergency of level %s at %s.", params.get(1), params.get(2));
    }

    public String registerHealthEmergency(List<String> params) {
        Emergency emergency = EmergencyFactory.createHealthEmergency(params.get(0), params.get(1), params.get(2), params.get(3));
        this.emergencyRegisters.get("Health").enqueueEmergency(emergency);
        return String.format("Registered Public Health Emergency of level %s at %s.", params.get(1), params.get(2));
    }

    public String registerOrderEmergency(List<String> params) {
        Emergency emergency = EmergencyFactory.createOrderEmergency(params.get(0), params.get(1), params.get(2), params.get(3));
        this.emergencyRegisters.get("Order").enqueueEmergency(emergency);
        return String.format("Registered Public Order Emergency of level %s at %s.", params.get(1), params.get(2));
    }

    //RegisterFireServiceCenter|{name}|{amountOfEmergencies}
    public String registerFireServiceCenter(List<String> params) {
        EmergencyCenter emergencyCenter = EmergencyCenterFactory.createFiremanServiceCenter(params.get(0), params.get(1));
        this.emergencyFireCenters.offer(emergencyCenter);
        return String.format("Registered Fire Service Emergency Center - %s.", params.get(0));
    }

    public String registerMedicalServiceCenter(List<String> params) {
        EmergencyCenter emergencyCenter = EmergencyCenterFactory.createMedicalEmergencyCenter(params.get(0), params.get(1));
        this.emergencyHealthCenters.offer(emergencyCenter);
        return String.format("Registered Medical Service Emergency Center - %s.", params.get(0));
    }

    public String registerPoliceServiceCenter(List<String> params) {
        EmergencyCenter emergencyCenter = EmergencyCenterFactory.createPoliceServiceCenter(params.get(0), params.get(1));
        this.emergencyPoliceCenters.offer(emergencyCenter);
        return String.format("Registered Police Service Emergency Center - %s.", params.get(0));
    }

    public String processEmergencies(List<String> params) {

        switch (params.get(0)) {
            case "Health":
                while (this.emergencyHealthCenters.stream().filter(ec -> !ec.isForRetirement()).count() > 0) {
                    EmergencyCenter emergencyCenter = this.emergencyHealthCenters.poll();
                    while (!emergencyCenter.isForRetirement()) {
                        if (this.emergencyRegisters.get(params.get(0)).isEmpty()) {

                            this.emergencyHealthCenters.offer(emergencyCenter);
                            return "Successfully responded to all Health emergencies.";
                        }

                        Emergency emergency = this.emergencyRegisters.get(params.get(0)).dequeueEmergency();
                        emergencyCenter.processEmergency(emergency);
                    }
                    this.emergencyHealthCenters.offer(emergencyCenter);
                }
                if (this.emergencyRegisters.get(params.get(0)).isEmpty()) {
                    return "Successfully responded to all Health emergencies.";
                }

                return String.format("Health Emergencies left to process: %d.", this.emergencyRegisters.get(params.get(0)).size());
            case "Property":
                while (this.emergencyFireCenters.stream().filter(ec -> !ec.isForRetirement()).count() > 0) {
                    EmergencyCenter emergencyCenter = this.emergencyFireCenters.poll();
                    while (!emergencyCenter.isForRetirement()) {
                        if (this.emergencyRegisters.get(params.get(0)).isEmpty()) {
                            this.emergencyFireCenters.offer(emergencyCenter);
                            return "Successfully responded to all Property emergencies.";
                        }

                        Emergency emergency = this.emergencyRegisters.get(params.get(0)).dequeueEmergency();
                        emergencyCenter.processEmergency(emergency);

                    }
                    this.emergencyFireCenters.offer(emergencyCenter);
                }
                if (this.emergencyRegisters.get(params.get(0)).isEmpty()) {
                    return "Successfully responded to all Property emergencies.";
                }

                return String.format("Property Emergencies left to process: %d.", this.emergencyRegisters.get(params.get(0)).size());
            case "Order":
                while (this.emergencyPoliceCenters.stream().filter(ec -> !ec.isForRetirement()).count() > 0) {
                    EmergencyCenter emergencyCenter = this.emergencyPoliceCenters.poll();

                    while (!emergencyCenter.isForRetirement()) {
                        if (this.emergencyRegisters.get(params.get(0)).isEmpty()) {
                            this.emergencyPoliceCenters.offer(emergencyCenter);
                            return "Successfully responded to all Order emergencies.";
                        }

                        Emergency emergency = this.emergencyRegisters.get(params.get(0)).dequeueEmergency();
                        emergencyCenter.processEmergency(emergency);
                    }

                    this.emergencyPoliceCenters.offer(emergencyCenter);
                }

                if (this.emergencyRegisters.get(params.get(0)).isEmpty()) {
                    return "Successfully responded to all Order emergencies.";
                }

                return String.format("Order Emergencies left to process: %d.", this.emergencyRegisters.get(params.get(0)).size());
            default:
                return null;
        }

    }


    public String emergencyReport() {
        return String.format("PRRM Services Live Statistics\n" +
                        "Fire Service Centers: %d\n" +
                        "Medical Service Centers: %d\n" +
                        "Police Service Centers: %d\n" +
                        "Total Processed Emergencies: %d\n" +
                        "Currently Registered Emergencies: %d\n" +
                        "Total Property Damage Fixed: %d\n" +
                        "Total Health Casualties Saved: %d\n" +
                        "Total Special Cases Processed: %d",
                this.emergencyFireCenters.stream().filter(ec->!ec.isForRetirement()).count(),
                this.emergencyHealthCenters.stream().filter(ec->!ec.isForRetirement()).count(),
                this.emergencyPoliceCenters.stream().filter(ec->!ec.isForRetirement()).count(),
                this.emergencyPoliceCenters.stream().mapToLong(EmergencyCenter::processedEmergenciesSize).sum() +
                        this.emergencyHealthCenters.stream().mapToLong(EmergencyCenter::processedEmergenciesSize).sum() +
                        this.emergencyFireCenters.stream().mapToLong(EmergencyCenter::processedEmergenciesSize).sum(),
                this.emergencyRegisters.get("Property").size() + this.emergencyRegisters.get("Order").size() +
                        this.emergencyRegisters.get("Health").size(),
                this.emergencyFireCenters.stream().mapToLong(ec -> ec.processedEmergencies().stream()
                        .mapToLong(Emergency::getAdditionalField).sum()).sum(),
                this.emergencyHealthCenters.stream().mapToLong(ec->ec.processedEmergencies().stream()
                .mapToLong(Emergency::getAdditionalField).sum()).sum(),
                this.emergencyPoliceCenters.stream().mapToLong(ec -> ec.processedEmergencies()
                        .stream().filter(e -> e.getAdditionalField() == 1).count()).sum()
        );
    }
}
