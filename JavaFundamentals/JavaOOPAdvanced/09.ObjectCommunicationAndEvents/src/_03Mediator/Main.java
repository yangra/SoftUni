package _03Mediator;

import _03Mediator.commands.AttackCommand;
import _03Mediator.commands.GroupAttackCommand;
import _03Mediator.commands.GroupTargetCommand;
import _03Mediator.commands.TargetCommand;
import _03Mediator.heroes.Warrior;
import _03Mediator.interfaces.*;
import _03Mediator.loggers.CombatLogger;
import _03Mediator.loggers.EventLogger;
import _03Mediator.targets.Dragon;

public class Main {
    public static void main(String[] args) {
        Handler combatHandler = new CombatLogger();
        Handler eventHandler = new EventLogger();
        combatHandler.setSuccessor(eventHandler);


        Attacker attacker1 = new Warrior("Pesho", 10, combatHandler);
        Attacker attacker2 = new Warrior("Gosho", 12, combatHandler);
        Attacker attacker3 = new Warrior("Stamat", 15, combatHandler);
        Attacker attacker4 = new Warrior("Jivko", 9, combatHandler);
        Attacker attacker5 = new Warrior("Ivan", 10, combatHandler);
        Target target = new Dragon("Gosho", 44, 5, combatHandler);
        AttackGroup group = new Group();
        group.addMember(attacker1);
        group.addMember(attacker2);
        group.addMember(attacker3);
        group.addMember(attacker4);
        group.addMember(attacker5);

        group.groupTarget(target);

        CommandExecutor commandExecutor = new CommandExecutor();

        Command setTarget = new GroupTargetCommand(group,target);
        Command attackCommand = new GroupAttackCommand(group);

        commandExecutor.executeCommand(setTarget);
        commandExecutor.executeCommand(attackCommand);
    }
}
