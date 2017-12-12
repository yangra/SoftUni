package _05BarracksWarsReturnOfTheDependencies.core;

import _05BarracksWarsReturnOfTheDependencies.annotations.Inject;
import _05BarracksWarsReturnOfTheDependencies.contracts.*;
import _05BarracksWarsReturnOfTheDependencies.contracts.Runnable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;

public class Engine implements Runnable {

    private String[] data;
    private Repository repository;
    private UnitFactory unitFactory;
    private CommandInterpreter commandInterpreter;

    public Engine(Repository repository, UnitFactory unitFactory, CommandInterpreter commandInterpreter) {
        this.repository = repository;
        this.unitFactory = unitFactory;
        this.commandInterpreter = commandInterpreter;
    }

    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                this.data = reader.readLine().split("\\s+");
                Executable command = this.commandInterpreter.interpretCommand(data[0]);
                injectDependencies(command);
                String result = command.execute();
                if (result.equals("fight")) {
                    break;
                }

                System.out.println(result);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            } catch (IOException | ClassNotFoundException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    private void injectDependencies(Executable command) throws ClassNotFoundException, IllegalAccessException {
        Field[] currentFields = this.getClass().getDeclaredFields();
        Field[] commandFields = Class.forName(command.getClass().getName()).getSuperclass().getDeclaredFields();
        for (Field commandField : commandFields) {
            if (commandField.isAnnotationPresent(Inject.class)) {
                for (Field currentField : currentFields) {
                    if (currentField.getType().equals(commandField.getType())) {
                        commandField.setAccessible(true);
                        commandField.set(command, currentField.get(this));
                    }
                }
            }

        }
    }


}
