package emergency.models.emergencies;

import emergency.enums.EmergencyLevel;
import emergency.interfaces.Registration;
import emergency.utils.RegistrationTime;

public class PublicHealthEmergency extends BaseEmergency {

    private  int numberOfCasualties;

    public PublicHealthEmergency(String description, EmergencyLevel emergencyLevel,
                                 Registration registrationTime, int numberOfCasualties) {
        super(description, emergencyLevel, registrationTime);
        this.numberOfCasualties = numberOfCasualties;
    }

    @Override
    public int getAdditionalField() {
        return this.numberOfCasualties;
    }
}
