package _04BarracksWarsCommandsStrikeBack.core;

import _04BarracksWarsCommandsStrikeBack.contracts.Executable;
import _04BarracksWarsCommandsStrikeBack.contracts.Interpreter;
import _04BarracksWarsCommandsStrikeBack.contracts.Repository;
import _04BarracksWarsCommandsStrikeBack.contracts.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class CommandInterpreter implements Interpreter {

    private static final String PACKAGE_PATH_COMMAND = "_04BarracksWarsCommandsStrikeBack.core.commands.";
    private static final String COMMAND_SUFFIX = "Command";

    private Repository repository;
    private UnitFactory unitFactory;

    public CommandInterpreter(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public String interpretCommand(String[] data) {

        Executable command = parseCommand(data);
        return command.execute();
    }

    private Executable parseCommand(String[] data) {
        String commandName = Character.toUpperCase(data[0].charAt(0)) + data[0].substring(1);
        try {
            Constructor constructor = Class.forName(PACKAGE_PATH_COMMAND + commandName + COMMAND_SUFFIX)
                    .getDeclaredConstructor(Repository.class, UnitFactory.class, String[].class);
            return (Executable) constructor.newInstance(this.repository, this.unitFactory, data);
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new RuntimeException("Invalid command!");
        }
    }
}
