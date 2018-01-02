package BoatSimulator.models;

import BoatSimulator.contracts.Race;
import BoatSimulator.models.boats.Boat;
import BoatSimulator.utility.Constants;
import BoatSimulator.utility.Validator;
import BoatSimulator.exceptions.DuplicateModelException;

import java.util.*;

public class RaceImpl implements Race {
    private int distance;
    private int windSpeed;
    private int oceanCurrentSpeed;
    private boolean allowsMotorBoats;
    private HashMap<String, Boat> registeredBoats;

    public RaceImpl(int distance, int windSpeed, int oceanCurrentSpeed, boolean allowsMotorBoats) {
        this.setDistance(distance);
        this.windSpeed = windSpeed;
        this.oceanCurrentSpeed = oceanCurrentSpeed;
        this.allowsMotorBoats = allowsMotorBoats;
        this.registeredBoats = new LinkedHashMap<>();
    }

    @Override
    public int getDistance() {
        return this.distance;
    }

    private void setDistance(int distance) {
        Validator.ValidatePropertyValue(distance, "Distance");
        this.distance = distance;
    }

    @Override
    public int getWindSpeed() {
        return this.windSpeed;
    }

    @Override
    public int getOceanCurrentSpeed() {
        return oceanCurrentSpeed;
    }

    @Override
    public boolean allowsMotorBoats() {
        return allowsMotorBoats;
    }


    @Override
    public void addParticipant(Boat boat) throws DuplicateModelException {
        if (this.registeredBoats.containsKey(boat.getModel())) {
            throw new DuplicateModelException(Constants.DUPLICATE_MODEL_MESSAGE);
        }

        this.registeredBoats.put(boat.getModel(), boat);
    }

    public List<Boat> getParticipants() {
        return Collections.unmodifiableList(new ArrayList<Boat>(this.registeredBoats.values()));
    }
}