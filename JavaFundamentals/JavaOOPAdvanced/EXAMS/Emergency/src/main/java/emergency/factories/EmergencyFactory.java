package emergency.factories;

import emergency.enums.EmergencyLevel;
import emergency.interfaces.Emergency;
import emergency.interfaces.Registration;
import emergency.models.emergencies.PublicHealthEmergency;
import emergency.models.emergencies.PublicOrderEmergency;
import emergency.models.emergencies.PublicPropertyEmergency;
import emergency.utils.RegistrationTime;

public final class EmergencyFactory {
    private EmergencyFactory() {
    }

    public static Emergency createHealthEmergency(String description, String emergencyLevelString,
                                                  String registrationTimeString, String numberOfCasualties) {
        EmergencyLevel emergencyLevel = EmergencyLevel.valueOf(emergencyLevelString);
        Registration registration = new RegistrationTime(registrationTimeString);
        return new PublicHealthEmergency(description, emergencyLevel, registration, Integer.parseInt(numberOfCasualties));
    }

    public static Emergency createOrderEmergency(String description, String emergencyLevelString,
                                                 String registrationTimeString, String isSpecialCase) {
        EmergencyLevel emergencyLevel = EmergencyLevel.valueOf(emergencyLevelString);
        Registration registration = new RegistrationTime(registrationTimeString);
        return new PublicOrderEmergency(description, emergencyLevel, registration, isSpecialCase);
    }

    public static Emergency createPropertyEmergency(String description, String emergencyLevelString,
                                                    String registrationTimeString, String propertyDamage) {
        EmergencyLevel emergencyLevel = EmergencyLevel.valueOf(emergencyLevelString);
        Registration registration = new RegistrationTime(registrationTimeString);
        return new PublicPropertyEmergency(description, emergencyLevel, registration, Integer.parseInt(propertyDamage));
    }
}
