package emergency;

import emergency.core.EmergencyManagementSystem;
import emergency.core.Engine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        EmergencyManagementSystem managementSystem = new EmergencyManagementSystem();
        Engine engine = new Engine(reader,managementSystem);
        try {
            engine.run();
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
