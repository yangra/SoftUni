package emergency.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Engine {
    private BufferedReader reader;
    private EmergencyManagementSystem managementSystem;

    public Engine(BufferedReader reader, EmergencyManagementSystem managementSystem) {
        this.reader = reader;
        this.managementSystem = managementSystem;
    }

    public void run() throws IOException {
        while (true) {
            String[] command = reader.readLine().split("\\|");
            if ("EmergencyBreak".equals(command[0])) {
                break;
            }

            System.out.println(dispatchCommand(command));

        }
    }

    private String dispatchCommand(String[] command) {
        List<String> params = Arrays.stream(command).skip(1).collect(Collectors.toList());
        switch (command[0]) {
            case "RegisterPropertyEmergency":
                return this.managementSystem.registerPropertyEmergency(params);
            case "RegisterHealthEmergency":
                return this.managementSystem.registerHealthEmergency(params);
            case "RegisterOrderEmergency":
                return this.managementSystem.registerOrderEmergency(params);
            case "RegisterFireServiceCenter":
                return this.managementSystem.registerFireServiceCenter(params);
            case "RegisterMedicalServiceCenter":
                return this.managementSystem.registerMedicalServiceCenter(params);
            case "RegisterPoliceServiceCenter":
                return this.managementSystem.registerPoliceServiceCenter(params);
            case "ProcessEmergencies":
                return this.managementSystem.processEmergencies(params);
            case "EmergencyReport":
                return this.managementSystem.emergencyReport();
            default:
                return null;
        }
    }
}
