package _14InfernoInfinityRefactoring.core.commands;

public class AuthorCommand extends Command {
    @Override
    public String execute() {
        return String.format("Author: %s", super.getAnnotation().author());
    }
}
