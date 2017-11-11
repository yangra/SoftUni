package _08May2017.core;

import _08May2017.models.Nation;
import _08May2017.factories.BenderFactory;
import _08May2017.factories.MonumentFactory;
import _08May2017.models.benders.Bender;
import _08May2017.models.monuments.Monument;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NationManager {

    private Nation waterNation = new Nation();
    private Nation fireNation = new Nation();
    private Nation airNation = new Nation();
    private Nation earthNation = new Nation();
    public static List<String> wars = new ArrayList<>();

    void makeBender(String type, String name, int power, double secParam) {
        switch (type) {
            case "Earth":
                Bender bender = BenderFactory.createEarthBender(name, power, secParam);
                this.earthNation.addBender(bender);
                break;
            case "Air":
                bender = BenderFactory.createAirBender(name, power, secParam);
                this.airNation.addBender(bender);
                break;
            case "Water":
                bender = BenderFactory.createWaterBender(name, power, secParam);
                this.waterNation.addBender(bender);
                break;
            case "Fire":
                bender = BenderFactory.createFireBender(name, power, secParam);
                this.fireNation.addBender(bender);
                break;
            default:
                break;
        }
    }

    void makeMonument(String type, String name, int affinity) {
        switch (type) {
            case "Earth":
                Monument monument = MonumentFactory.createEarthMonument(name, affinity);
                this.earthNation.addMonument(monument);
                break;
            case "Air":
                monument = MonumentFactory.createAirMonument(name, affinity);
                this.airNation.addMonument(monument);
                break;
            case "Water":
                monument = MonumentFactory.createWaterMonument(name, affinity);
                this.waterNation.addMonument(monument);
                break;
            case "Fire":
                monument = MonumentFactory.createFireMonument(name, affinity);
                this.fireNation.addMonument(monument);
                break;
            default:
                break;
        }
    }

    String getStatus(String nation) {
        StringBuilder builder = new StringBuilder();
        builder.append(nation).append(" Nation\n");
        switch (nation) {
            case "Earth":
                List<Bender> benders = this.earthNation.getBenders();
                listBenders(builder, benders);
                List<Monument> monuments = this.earthNation.getMonuments();
                listMonuments(builder,monuments);
                return builder.toString();

            case "Air":
                benders = this.airNation.getBenders();
                listBenders(builder, benders);
                monuments = this.airNation.getMonuments();
                listMonuments(builder, monuments);
                return builder.toString();
            case "Water":
                benders = this.waterNation.getBenders();
                listBenders(builder, benders);
                monuments = this.waterNation.getMonuments();
                listMonuments(builder, monuments);
                return builder.toString();
            case "Fire":
                benders = this.fireNation.getBenders();
                listBenders(builder, benders);
                monuments = this.fireNation.getMonuments();
                listMonuments(builder, monuments);
                return builder.toString();
            default:
                return null;
        }

    }

    void beginWar(String nation, int warCounter) {
        wars.add(String.format("War %d issued by %s", warCounter, nation));
        double waterPower = this.waterNation.getTotalPower();
        double firePower = this.fireNation.getTotalPower();
        double earthPower = this.earthNation.getTotalPower();
        double airPower = this.airNation.getTotalPower();
        if (waterPower > firePower && waterPower > airPower && waterPower > earthPower) {
            clearLosers(airNation,fireNation,earthNation);
        }else if(airPower > firePower && airPower > waterPower && airPower > earthPower){
            clearLosers(waterNation,fireNation,earthNation);
        }else if(firePower > airPower && firePower > waterPower && firePower > earthPower){
            clearLosers(airNation,waterNation,earthNation);
        }else{
            clearLosers(airNation,fireNation,waterNation);
        }
    }

    private void clearLosers(Nation n1, Nation n2, Nation n3) {
        n1.clearBenders();
        n1.clearMonumnets();
        n2.clearBenders();
        n2.clearMonumnets();
        n3.clearBenders();
        n3.clearMonumnets();
    }

    private void listMonuments(StringBuilder builder, List<Monument> monuments) {
        if (monuments.size() > 0) {
            builder.append("Monuments:\n")
                    .append(monuments.stream().map(Object::toString).collect(Collectors.joining("\n")));

        } else {
            builder.append("Monuments: None");
        }
    }

    private void listBenders(StringBuilder builder, List<Bender> benders) {
        if (benders.size() > 0) {
            builder.append("Benders:\n")
                    .append(benders.stream().map(Object::toString).collect(Collectors.joining("\n")))
                    .append("\n");
        } else {
            builder.append("Benders: None\n");
        }
    }
}
