package _14InfernoInfinityRefactoring.core.commands;

public class ReviewersCommand extends Command {
    @Override
    public String execute() {
        return String.format("Reviewers: %s", String.join(", ", super.getAnnotation().reviewers()));
    }
}
