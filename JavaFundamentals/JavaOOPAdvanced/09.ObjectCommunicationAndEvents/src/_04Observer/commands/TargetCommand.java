package _04Observer.commands;


import _04Observer.interfaces.Attacker;
import _04Observer.interfaces.Command;
import _04Observer.interfaces.Target;

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
