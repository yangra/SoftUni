package _04Observer;

import _04Observer.interfaces.Command;
import _04Observer.interfaces.Executor;

public class CommandExecutor implements Executor {
    @Override
    public void executeCommand(Command command) {
        command.execute();
    }
}
