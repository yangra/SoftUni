package _14InfernoInfinityRefactoring.core.commands;


public class DescriptionCommand extends Command {
    @Override
    public String execute() {
        return String.format("Class description: %s", super.getAnnotation().description());
    }
}
