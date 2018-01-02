package app.waste_disposal.core;


import app.waste_disposal.annotations.Disposable;
import app.waste_disposal.contracts.GarbageProcessor;
import app.waste_disposal.contracts.ProcessingData;
import app.waste_disposal.contracts.Waste;
import app.waste_disposal.factories.WasteFactory;

import java.util.List;

public class WasteController {

    private GarbageProcessor garbageProcessor;
    private double energy;
    private double capital;
    private double requiredEnergy;
    private double requiredCapital;
    private Class deniedTypeGarbage;

    public WasteController(GarbageProcessor garbageProcessor) {
        this.garbageProcessor = garbageProcessor;
        this.requiredCapital = Double.MIN_VALUE;
        this.requiredEnergy = Double.MIN_VALUE;
        this.deniedTypeGarbage = Disposable.class;
    }


    public String processGarbageCommand(List<String> command) {
        Waste waste = null;
        switch (command.get(3)) {
            case "Recyclable":
                waste = WasteFactory.createRecyclableGarbage(command.get(0), Double.parseDouble(command.get(1)), Double.parseDouble(command.get(2)));
                break;
            case "Burnable":
                waste = WasteFactory.createBurnableGarbge(command.get(0), Double.parseDouble(command.get(1)), Double.parseDouble(command.get(2)));
                break;
            case "Storable":
                waste = WasteFactory.createStorableGarbge(command.get(0), Double.parseDouble(command.get(1)), Double.parseDouble(command.get(2)));
                break;
            default:
                throw new IllegalArgumentException("Invalid type of waste!");
        }


        if (!meetsManagementRequirements(waste)) {
            return "Processing Denied!";
        }

        ProcessingData data = this.garbageProcessor.processWaste(waste);
        this.energy += data.getEnergyBalance();
        this.capital += data.getCapitalBalance();

        return String.format("%.2f kg of %s successfully processed!", Double.parseDouble(command.get(1)), command.get(0));
    }

    private boolean meetsManagementRequirements(Waste waste) {
        if ((this.energy < this.requiredEnergy || this.capital < this.requiredCapital) &&
                waste.getClass().isAnnotationPresent(this.deniedTypeGarbage)) {
            return false;
        }
        return true;
    }

    public String statusCommand() {
        return String.format("Energy: %.2f Capital: %.2f", this.energy, this.capital);
    }

    public String changeManagementRequirementCommand(List<String> params) {
        try {
            this.requiredEnergy = Double.parseDouble(params.get(0));
            this.requiredCapital = Double.parseDouble(params.get(1));
            this.deniedTypeGarbage = Class.forName("app.waste_disposal.annotations." + params.get(2));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return "Management requirement changed!";
    }
}
