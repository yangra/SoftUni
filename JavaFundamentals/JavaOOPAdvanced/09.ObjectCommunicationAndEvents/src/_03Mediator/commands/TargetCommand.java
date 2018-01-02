package _03Mediator.commands;


import _03Mediator.interfaces.Attacker;
import _03Mediator.interfaces.Command;
import _03Mediator.interfaces.Target;

public class TargetCommand implements Command {

    private Attacker attacker;
    private Target target;

    public TargetCommand(Attacker attacker, Target target) {
        this.attacker = attacker;
        this.target = target;
    }

    @Override
    public void execute() {
        this.attacker.setTarget(target);
    }
}
