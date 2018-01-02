package _03Mediator.heroes;

import _03Mediator.enums.LogType;
import _03Mediator.interfaces.Handler;
import _03Mediator.interfaces.Target;

public class Warrior extends AbstractHero {

    private static final String ATTACK_MESSAGE = "%s damages %s for %s";

    public Warrior(String id, int dmg, Handler handler) {
        super(id, dmg, handler);
    }

    @Override
    protected void executeClassSpecificAttack(Target target, int dmg) {
        super.getHandler().handle(LogType.ATTACK, String.format(ATTACK_MESSAGE, this, target, dmg));
        target.receiveDamage(dmg);
    }
}
