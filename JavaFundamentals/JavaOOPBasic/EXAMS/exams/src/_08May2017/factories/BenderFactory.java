package _08May2017.factories;

import _08May2017.models.benders.*;

public final class BenderFactory {
    private BenderFactory() { }

    public static Bender createAirBender(String name, int power, double aerialIntegrity){
        return new AirBender(name, power, aerialIntegrity);
    }

    public static Bender createFireBender(String name, int power, double heatAggression){
        return new FireBender(name, power, heatAggression);
    }

    public static Bender createWaterBender(String name, int power, double waterClarity){
        return new WaterBender(name, power, waterClarity);
    }

    public static Bender createEarthBender(String name, int power, double groundSaturation){
        return new EarthBender(name, power, groundSaturation);
    }
}
