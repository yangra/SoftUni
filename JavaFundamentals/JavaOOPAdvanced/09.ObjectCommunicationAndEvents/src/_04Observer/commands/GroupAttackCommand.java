package _04Observer.commands;


import _04Observer.interfaces.AttackGroup;
import _04Observer.interfaces.Command;

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
