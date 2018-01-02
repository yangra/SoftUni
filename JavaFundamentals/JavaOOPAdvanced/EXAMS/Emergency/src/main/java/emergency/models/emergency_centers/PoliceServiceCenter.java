package emergency.models.emergency_centers;

import emergency.interfaces.Emergency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PoliceServiceCenter extends BaseEmergencyCenter {

    private List<Emergency> emergencies;

    public PoliceServiceCenter(String name, int amountOfMaximumEmergencies) {
        super(name, amountOfMaximumEmergencies);
        this.emergencies = new ArrayList<>();
    }

    @Override
    public boolean isForRetirement() {
        return this.emergencies.size() >= super.getAmountOfMaximumEmergencies();
    }

    @Override
    public void processEmergency(Emergency emergency){
        this.emergencies.add(emergency);
    }

    @Override
    public int processedEmergenciesSize(){
        return this.emergencies.size();
    }

    @Override
    public List<Emergency> processedEmergencies() {
        return Collections.unmodifiableList(this.emergencies);
    }
}
