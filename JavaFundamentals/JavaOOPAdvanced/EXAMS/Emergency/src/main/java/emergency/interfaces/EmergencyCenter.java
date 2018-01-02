package emergency.interfaces;

import java.util.List;

public interface EmergencyCenter {

    String getName();

    int getAmountOfMaximumEmergencies();

    boolean isForRetirement();

    void processEmergency(Emergency emergency);

    int processedEmergenciesSize();

    List<Emergency> processedEmergencies();
}
