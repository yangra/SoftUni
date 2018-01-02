package _01Logger;

import _01Logger.heroes.Warrior;
import _01Logger.interfaces.Attacker;
import _01Logger.interfaces.Handler;
import _01Logger.interfaces.Target;
import _01Logger.loggers.CombatLogger;
import _01Logger.loggers.EventLogger;
import _01Logger.targets.Dragon;

public class Main {
    public static void main(String[] args) {
        Handler combatHandler = new CombatLogger();
        Handler eventHandler = new EventLogger();
        combatHandler.setSuccessor(eventHandler);

        Attacker attacker = new Warrior("Pesho", 10, combatHandler);
        Target target = new Dragon("Gosho", 10, 5, combatHandler);
        attacker.setTarget(target);
        attacker.attack();
    }
}
