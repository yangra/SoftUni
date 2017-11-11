package _09Nov2017.factories;

import _09Nov2017.models.centers.AdoptionCenter;
import _09Nov2017.models.centers.CastrationCenter;
import _09Nov2017.models.centers.Center;
import _09Nov2017.models.centers.CleansingCenter;

public final class CenterFactory {
    private CenterFactory() {
    }

    public static Center createCleansingCenter(String name){
        return new CleansingCenter(name);
    }

    public static Center createAdoptionCenter(String name){
        return new AdoptionCenter(name);
    }

    public static Center createCastrationCenter(String name){
        return new CastrationCenter(name);
    }
}
