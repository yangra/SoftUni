package emergency.factories;

import emergency.interfaces.EmergencyCenter;
import emergency.models.emergency_centers.FiremanServiceCenter;
import emergency.models.emergency_centers.MedicalServiceCenter;
import emergency.models.emergency_centers.PoliceServiceCenter;

public final class EmergencyCenterFactory {
    private EmergencyCenterFactory() {
    }

    public static EmergencyCenter createMedicalEmergencyCenter(String name, String amountOfMaximumEmergencies){
        return  new MedicalServiceCenter(name, Integer.parseInt(amountOfMaximumEmergencies));
    }

    public static EmergencyCenter createPoliceServiceCenter(String name, String amountOfMaximumEmergencies){
        return  new PoliceServiceCenter(name, Integer.parseInt(amountOfMaximumEmergencies));
    }

    public static EmergencyCenter createFiremanServiceCenter(String name, String amountOfMaximumEmergencies){
        return  new FiremanServiceCenter(name, Integer.parseInt(amountOfMaximumEmergencies));
    }

}
