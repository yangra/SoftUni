package _04Observer.interfaces;


public interface AttackGroup {

    void addMember(Attacker attacker);

    void groupTarget(Target target);

    void groupAttack();
}
