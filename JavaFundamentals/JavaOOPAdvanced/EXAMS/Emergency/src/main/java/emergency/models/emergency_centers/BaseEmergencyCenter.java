package emergency.models.emergency_centers;

import emergency.interfaces.EmergencyCenter;

public abstract class BaseEmergencyCenter implements EmergencyCenter {
    private String name;

    private int amountOfMaximumEmergencies;


    protected BaseEmergencyCenter(String name, int amountOfMaximumEmergencies) {
        this.setName(name);
        this.setAmountOfMaximumEmergencies(amountOfMaximumEmergencies);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getAmountOfMaximumEmergencies() {
        return amountOfMaximumEmergencies;
    }

    private void setAmountOfMaximumEmergencies(Integer amountOfMaximumEmergencies) {
        this.amountOfMaximumEmergencies = amountOfMaximumEmergencies;
    }

    public abstract boolean isForRetirement();
}
