package _04BarracksWarsCommandsStrikeBack.core;

import _04BarracksWarsCommandsStrikeBack.contracts.*;
import _04BarracksWarsCommandsStrikeBack.contracts.Runnable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Engine implements Runnable {

    private Repository repository;
    private UnitFactory unitFactory;

    public Engine(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Interpreter commandInterpreter = new CommandInterpreter(this.repository, this.unitFactory);
        while (true) {
            try {
                String input = reader.readLine();
                String[] data = input.split("\\s+");
                String result = commandInterpreter.interpretCommand(data);
                if (result.equals("fight")) {
                    break;
                }
                if (result != null) {
                    System.out.println(result);
                }
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
