package _08May2017.factories;

import _08May2017.models.monuments.*;

public final class MonumentFactory {
    private MonumentFactory() { }

    public static Monument createAirMonument(String name, int airAffinity){
        return new AirMonument(name,airAffinity);
    }

    public static Monument createWaterMonument(String name, int waterAffinity){
        return new WaterMonument(name,waterAffinity);
    }

    public static Monument createFireMonument(String name, int fireAffinity){
        return new FireMonument(name,fireAffinity);
    }

    public static Monument createEarthMonument(String name, int earthAffinity){
        return new EarthMonument(name,earthAffinity);
    }
}
