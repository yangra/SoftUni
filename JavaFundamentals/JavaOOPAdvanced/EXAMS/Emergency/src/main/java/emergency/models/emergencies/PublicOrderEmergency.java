package emergency.models.emergencies;

import emergency.enums.EmergencyLevel;
import emergency.interfaces.Registration;

public class PublicOrderEmergency extends BaseEmergency {

    private int isSpecialCase;

    public PublicOrderEmergency(String description, EmergencyLevel emergencyLevel,
                                Registration registrationTime, String isSpecialCase) {
        super(description, emergencyLevel, registrationTime);
        if(isSpecialCase.equals("Special")){
            this.isSpecialCase = 1;
        }else{
            this.isSpecialCase = 0;
        }
    }

    @Override
    public int getAdditionalField() {
        return this.isSpecialCase;
    }
}
