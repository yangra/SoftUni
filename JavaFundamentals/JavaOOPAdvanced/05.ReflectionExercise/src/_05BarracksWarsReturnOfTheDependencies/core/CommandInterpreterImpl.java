package _05BarracksWarsReturnOfTheDependencies.core;

import _05BarracksWarsReturnOfTheDependencies.contracts.CommandInterpreter;
import _05BarracksWarsReturnOfTheDependencies.contracts.Executable;


import java.lang.reflect.InvocationTargetException;

public class CommandInterpreterImpl implements CommandInterpreter {

    private static final String PACKAGE_PATH_COMMANDS = "_05BarracksWarsReturnOfTheDependencies.core.commands.";
    private static final String COMMAND_SUFFIX = "Command";

    public CommandInterpreterImpl() {
    }

    @Override
    public Executable interpretCommand(String command) {
        String commandName = Character.toUpperCase(command.charAt(0)) + command.substring(1);
        try {
            return (Executable) Class.forName(PACKAGE_PATH_COMMANDS + commandName + COMMAND_SUFFIX)
                    .getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new RuntimeException("Invalid command!");
        }
    }
}
