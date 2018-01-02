package _02Command;

import _02Command.interfaces.Command;
import _02Command.interfaces.Executor;

public class CommandExecutor implements Executor {
    @Override
    public void executeCommand(Command command) {
        command.execute();
    }
}
