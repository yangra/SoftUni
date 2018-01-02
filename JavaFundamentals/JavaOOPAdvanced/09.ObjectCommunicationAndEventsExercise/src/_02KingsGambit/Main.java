package _02KingsGambit;

import _02KingsGambit.interfaces.Observer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String kingName = reader.readLine();
        String[] royalGuardNames = reader.readLine().split("\\s+");
        String[] footmenNames = reader.readLine().split("\\s+");

        King king = new King(kingName);
        Map<String, Observer> observers = new HashMap<>();
        for (String royalGuardName : royalGuardNames) {
            Observer royalGuard = new RoyalGuard(royalGuardName);
            king.register(royalGuard);
            observers.put(royalGuardName,royalGuard);
        }

        for (String footmanName : footmenNames) {
            Observer footman = new Footman(footmanName);
            king.register(footman);
            observers.put(footmanName,footman);
        }

        while (true){
            String[] command = reader.readLine().split("\\s+");
            if("End".equals(command[0])){
                break;
            }

            switch (command[0]){
                case "Kill":
                    String name = command[1];
                    if(observers.containsKey(name)){
                        king.unregister(observers.get(name));
                        observers.remove(name);
                    }
                    break;
                case "Attack":
                    king.respondToAttack();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid command!");
            }
        }
    }
}
