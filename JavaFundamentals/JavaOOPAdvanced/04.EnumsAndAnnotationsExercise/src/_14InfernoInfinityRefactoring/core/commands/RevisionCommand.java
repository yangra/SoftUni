package _14InfernoInfinityRefactoring.core.commands;

public class RevisionCommand extends Command {
    @Override
    public String execute() {
        return String.format("Revision: %d", super.getAnnotation().revision());
    }
}
