package emergency.models.emergencies;

import emergency.enums.EmergencyLevel;
import emergency.interfaces.Registration;
import emergency.utils.RegistrationTime;

public class PublicPropertyEmergency extends BaseEmergency {

    private int propertyDamage;

    public PublicPropertyEmergency(String description, EmergencyLevel emergencyLevel,
                                   Registration registrationTime, int propertyDamage) {
        super(description, emergencyLevel, registrationTime);
        this.propertyDamage = propertyDamage;
    }

    @Override
    public int getAdditionalField() {
        return this.propertyDamage;
    }
}
