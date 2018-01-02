package emergency.models.emergencies;


import emergency.enums.EmergencyLevel;
import emergency.interfaces.Emergency;
import emergency.interfaces.Registration;


public abstract class BaseEmergency implements Emergency {
    private String description;

    private EmergencyLevel emergencyLevel;

    private Registration registrationTime;

    protected BaseEmergency(String description, EmergencyLevel emergencyLevel, Registration registrationTime) {
        this.setDescription(description);
        this.setEmergencyLevel(emergencyLevel);
        this.setRegistrationTime(registrationTime);
    }


    public String getDescription() {
        return this.description;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    public EmergencyLevel getEmergencyLevel() {
        return this.emergencyLevel;
    }

    private void setEmergencyLevel(EmergencyLevel emergencyLevel) {
        this.emergencyLevel = emergencyLevel;
    }

    public Registration getRegistrationTime() {
        return registrationTime;
    }

    private void setRegistrationTime(Registration registrationTime) {
        this.registrationTime = registrationTime;
    }
}
