package _02Command;

import _02Command.commands.AttackCommand;
import _02Command.commands.TargetCommand;
import _02Command.heroes.Warrior;
import _02Command.interfaces.Attacker;
import _02Command.interfaces.Command;
import _02Command.interfaces.Handler;
import _02Command.interfaces.Target;
import _02Command.loggers.CombatLogger;
import _02Command.loggers.EventLogger;
import _02Command.targets.Dragon;

public class Main {
    public static void main(String[] args) {
        Handler combatHandler = new CombatLogger();
        Handler eventHandler = new EventLogger();
        combatHandler.setSuccessor(eventHandler);

        CommandExecutor commandExecutor = new CommandExecutor();
        Attacker attacker = new Warrior("Pesho", 10, combatHandler);
        Target target = new Dragon("Gosho", 10, 5, combatHandler);
        Command setTarget = new TargetCommand(attacker,target);
        Command attackCommand = new AttackCommand(attacker);

        commandExecutor.executeCommand(setTarget);
        commandExecutor.executeCommand(attackCommand);
    }
}
