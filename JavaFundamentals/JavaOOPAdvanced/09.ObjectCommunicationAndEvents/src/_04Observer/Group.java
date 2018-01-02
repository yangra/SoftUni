package _04Observer;

import _04Observer.interfaces.AttackGroup;
import _04Observer.interfaces.Attacker;
import _04Observer.interfaces.Target;

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
