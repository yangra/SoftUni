package rpg.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import rpg.interfaces.Target;
import rpg.interfaces.Weapon;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DummyTest {
    private static final int WEAPON_INITIAL_ATTACK = 1;
    private static final int WEAPON_INITIAL_DURABILITY = 10;
    private static final int TARGET_INITIAL_HEALTH = 2;
    private static final int TARGET_INITIAL_EXPERIENCE = 2;
    private static final int TARGET_EXPECTED_HEALTH = 1;
    private static final int TARGET_EXPECTED_EXPERIENCE = 2;

    private Target target = null;
    private Weapon weaponMock = null;

    @Before
    public void constructObjects() {
        this.target = new Dummy(TARGET_INITIAL_HEALTH, TARGET_INITIAL_EXPERIENCE, new ArrayList<>());
        this.weaponMock = Mockito.mock(Weapon.class);
        Mockito.when(weaponMock.getAttackPoints()).thenReturn(WEAPON_INITIAL_ATTACK);
        Mockito.when(weaponMock.getDurabilityPoints()).thenReturn(WEAPON_INITIAL_DURABILITY);
    }

    @Test
    public void dummyLosesHealthProperly() {
        this.target.takeAttack(this.weaponMock.getAttackPoints());

        Assert.assertEquals(
                "Dummy does not lose health properly", TARGET_EXPECTED_HEALTH, this.target.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void deadDummyThrowsExceptionIfAttacked() {
        this.target.takeAttack(this.weaponMock.getAttackPoints());
        this.target.takeAttack(this.weaponMock.getAttackPoints());
        this.target.takeAttack(this.weaponMock.getAttackPoints());
    }

    @Test
    public void deadDummyCanGiveXP() {
        this.target.takeAttack(this.weaponMock.getAttackPoints());
        this.target.takeAttack(this.weaponMock.getAttackPoints());

        Assert.assertEquals(
                "Dummy does not give XP when dead", TARGET_EXPECTED_EXPERIENCE, this.target.giveExperience());
    }

    @Test(expected = IllegalStateException.class)
    public void aliveDummyCannotGiveXP() {
        this.target.takeAttack(this.weaponMock.getAttackPoints());
        this.target.giveExperience();
    }
}