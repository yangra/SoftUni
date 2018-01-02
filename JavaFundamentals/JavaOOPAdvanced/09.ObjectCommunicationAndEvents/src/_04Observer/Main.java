package _04Observer;

import _04Observer.commands.GroupAttackCommand;
import _04Observer.commands.GroupTargetCommand;
import _04Observer.heroes.AbstractHero;
import _04Observer.heroes.Warrior;
import _04Observer.interfaces.*;
import _04Observer.loggers.CombatLogger;
import _04Observer.loggers.EventLogger;
import _04Observer.targets.Dragon;

public class Main {
    public static void main(String[] args) {
        Handler combatHandler = new CombatLogger();
        Handler eventHandler = new EventLogger();
        combatHandler.setSuccessor(eventHandler);

        ObservingAttacker attacker1 = new Warrior("Pesho", 10, combatHandler);
        ObservingAttacker attacker2 = new Warrior("Gosho", 12, combatHandler);
        ObservingAttacker attacker3 = new Warrior("Stamat", 15, combatHandler);
        ObservingAttacker attacker4 = new Warrior("Jivko", 9, combatHandler);
        ObservingAttacker attacker5 = new Warrior("Ivan", 10, combatHandler);
        ObservableTarget target = new Dragon("Gosho", 44, 5, combatHandler);
        AttackGroup group = new Group();
        group.addMember(attacker1);
        group.addMember(attacker2);
        group.addMember(attacker3);
        group.addMember(attacker4);
        group.addMember(attacker5);
        group.groupTarget(target);

        target.register(attacker1);
        target.register(attacker2);
        target.register(attacker3);
        target.register(attacker4);
        target.register(attacker5);

        CommandExecutor commandExecutor = new CommandExecutor();

        Command setTarget = new GroupTargetCommand(group,target);
        Command attackCommand = new GroupAttackCommand(group);

        commandExecutor.executeCommand(setTarget);
        commandExecutor.executeCommand(attackCommand);
    }
}
