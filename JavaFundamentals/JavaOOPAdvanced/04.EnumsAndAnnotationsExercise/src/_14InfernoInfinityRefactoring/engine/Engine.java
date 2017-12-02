package _14InfernoInfinityRefactoring.engine;

import _14InfernoInfinityRefactoring.annotations.Inject;
import _14InfernoInfinityRefactoring.core.commands.Executable;
import _14InfernoInfinityRefactoring.io.contracts.InputReader;
import _14InfernoInfinityRefactoring.io.contracts.OutputWriter;
import _14InfernoInfinityRefactoring.io.impl.ConsoleInputReader;
import _14InfernoInfinityRefactoring.io.impl.ConsoleOutputWriter;
import _14InfernoInfinityRefactoring.models.contracts.Weapon;
import _14InfernoInfinityRefactoring.repositories.Repository;
import _14InfernoInfinityRefactoring.repositories.WeaponRepository;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Engine implements Runnable {
    private static final String TERMINATE_COMMAND = "END";
    private static final String COMMAND_CLASS_PATH = "_14InfernoInfinityRefactoring.core.commands.";
    private static final String COMMAND_CLASS_NAME_SUFFIX = "Command";

    private String[] params;
    private InputReader reader;
    private OutputWriter writer;
    private Repository<Weapon> weaponRepository;

    public Engine() {
        this.weaponRepository = new WeaponRepository();
        this.reader = new ConsoleInputReader();
        this.writer = new ConsoleOutputWriter();
    }

    @Override
    public void run() {
        while (true) {
            try {
                this.params = this.reader.readLine().split(";");
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (TERMINATE_COMMAND.equalsIgnoreCase(this.params[0])) {
                break;
            }
            try {
                String result = this.dispatchCommand(this.params[0], Arrays.stream(params).skip(1).toArray(String[]::new));
                if (result != null) {
                    this.writer.writeLine(result);
                }
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException |
                    NoSuchMethodException | InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException iae) {
                writer.writeLine(iae.getMessage());
            }
        }
    }

    @SuppressWarnings("unchecked")
    private String dispatchCommand(String command, String[] tokens) throws
            ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, IllegalArgumentException {
        this.params = tokens;
        Class<Executable> commandClass =
                (Class<Executable>) Class.forName(COMMAND_CLASS_PATH + command + COMMAND_CLASS_NAME_SUFFIX);
        Constructor<Executable> constructor = commandClass.getDeclaredConstructor();
        Executable executable = constructor.newInstance();
        injectDependencies(executable);
        return executable.execute();
    }

    private void injectDependencies(Executable executable) throws IllegalAccessException {
        Field[] fields = executable.getClass().getSuperclass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(Inject.class)) {
                Field[] currentFields = this.getClass().getDeclaredFields();
                for (Field currentField : currentFields) {
                    if (field.getType().equals(currentField.getType())) {
                        field.setAccessible(true);
                        field.set(executable, currentField.get(this));
                    }
                }
            }
        }
    }

}
