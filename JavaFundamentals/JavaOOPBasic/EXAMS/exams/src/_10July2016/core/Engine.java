package _10July2016.core;

import _10July2016.factories.HardwareFactory;
import _10July2016.factories.SoftwareFactory;
import _10July2016.io.ConsoleInputReader;
import _10July2016.io.ConsoleOutputWriter;
import _10July2016.models.hardware.HardwareComponent;
import _10July2016.models.software.SoftwareComponent;
import _10July2016.utilities.InputParser;

import java.io.IOException;

public class Engine {
    private InputParser inputParser;
    private ConsoleInputReader inputReader;
    private ConsoleOutputWriter outputWriter;
    private TheSystem theSystem;

    public Engine() {
        this.inputParser = new InputParser();
        this.inputReader = new ConsoleInputReader();
        this.outputWriter = new ConsoleOutputWriter();
        this.theSystem = new TheSystem();
    }

    public void run() throws IOException {

        while (true) {
            String input = this.inputReader.readLine();
            String[] split = this.inputParser.splitByBracket(input);
            if ("System Split".equalsIgnoreCase(split[0])) {
                break;
            }

            dispatchCommand(split);
        }

        this.outputWriter.writeLine(this.theSystem.split());
    }

    private void dispatchCommand(String[] split) {

        switch (split[0].toLowerCase()) {
            case "registerpowerhardware":
                String[] args = this.inputParser.splitByComa(split[1]);
                this.theSystem.registerPowerHardware(args[0], Integer.parseInt(args[1]),Integer.parseInt(args[2]));
                break;
            case "registerheavyhardware":
                args = this.inputParser.splitByComa(split[1]);
                this.theSystem.registerHeavyHardware(args[0], Integer.parseInt(args[1]),Integer.parseInt(args[2]));
                break;
            case "registerexpresssoftware":
                args = this.inputParser.splitByComa(split[1]);
                this.theSystem.registerExpressSoftware(args[0], args[1], Integer.parseInt(args[2]),Integer.parseInt(args[3]));
                break;
            case "registerlightsoftware":
                args = this.inputParser.splitByComa(split[1]);
                this.theSystem.registerLightSoftware(args[0], args[1], Integer.parseInt(args[2]),Integer.parseInt(args[3]));
                break;
            case "releasesoftwarecomponent":
                args = this.inputParser.splitByComa(split[1]);
                this.theSystem.releaseSoftwareComponent(args[0],args[1]);
                break;
            case "analyze":
                this.outputWriter.writeLine(this.theSystem.analyze());
                break;
            case "dump":
               this.theSystem.dump(split[1]);
               break;
            case "restore":
                this.theSystem.restore(split[1]);
                break;
            case "destroy":
                this.theSystem.destroy(split[1]);
                break;
            case "dumpanalyze":
                this.outputWriter.writeLine(this.theSystem.dumpAnalyze());
                break;
            default:
                break;
        }
    }
}
