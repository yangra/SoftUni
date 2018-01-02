package _03Mediator;

import _03Mediator.interfaces.Command;
import _03Mediator.interfaces.Executor;

public class CommandExecutor implements Executor {
    @Override
    public void executeCommand(Command command) {
        command.execute();
    }
}
