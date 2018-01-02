package emergency.interfaces;


import emergency.enums.EmergencyLevel;

public interface Emergency {

    String getDescription();

    EmergencyLevel getEmergencyLevel();

    Registration getRegistrationTime();

    int getAdditionalField();
}
