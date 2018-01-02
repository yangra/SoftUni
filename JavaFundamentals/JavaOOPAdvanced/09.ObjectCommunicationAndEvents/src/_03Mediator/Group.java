package _03Mediator;

import _03Mediator.interfaces.AttackGroup;
import _03Mediator.interfaces.Attacker;
import _03Mediator.interfaces.Target;

import java.util.ArrayList;
import java.util.List;

public class Group implements AttackGroup {

    private List<Attacker> attackers;

    public Group() {
        this.attackers = new ArrayList<>();
    }

    @Override
    public void addMember(Attacker attacker) {
        this.attackers.add(attacker);
    }

    @Override
    public void groupTarget(Target target) {
        for (Attacker attacker : this.attackers) {
            attacker.setTarget(target);
        }
    }

    @Override
    public void groupAttack() {
        for (Attacker attacker : this.attackers) {
            attacker.attack();
        }
    }
}
