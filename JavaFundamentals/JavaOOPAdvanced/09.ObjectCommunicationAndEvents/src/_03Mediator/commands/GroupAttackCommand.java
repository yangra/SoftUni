package _03Mediator.commands;


import _03Mediator.interfaces.AttackGroup;
import _03Mediator.interfaces.Command;
import _03Mediator.interfaces.Target;

public class GroupAttackCommand implements Command {

    private AttackGroup group;

    public GroupAttackCommand(AttackGroup group) {
        this.group = group;
    }

    @Override
    public void execute() {
        this.group.groupAttack();
    }
}
