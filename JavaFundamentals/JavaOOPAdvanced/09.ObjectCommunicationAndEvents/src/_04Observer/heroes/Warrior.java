package _04Observer.heroes;

import _04Observer.enums.LogType;
import _04Observer.interfaces.Handler;
import _04Observer.interfaces.Target;

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

    @Override
    public void update(int reward) {
        super.getHandler().handle(LogType.EVENT, super.getId() + " earned " + reward);
    }
}
