package rpg.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import rpg.interfaces.Target;
import rpg.interfaces.Weapon;

import static org.junit.Assert.*;

public class AxeTest {
    private static final int AXE_INITIAL_ATTACK = 5;
    private static final int AXE_INITIAL_DURABILITY = 1;
    private static final int TARGET_INITIAL_HEALTH = 10;
    private static final int TARGET_INITIAL_EXPERIENCE = 0;
    private static final int AXE_EXPECTED_DURABILITY = 0;

    private Weapon weapon = null;
    private Target targetMock = null;

    @Before
    public void constructObjects(){
        //Arrange
        this.weapon = new Axe(AXE_INITIAL_ATTACK, AXE_INITIAL_DURABILITY);
        targetMock = Mockito.mock(Target.class);
        Mockito.when(targetMock.getHealth()).thenReturn(TARGET_INITIAL_HEALTH);
        Mockito.when(targetMock.giveExperience()).thenReturn(TARGET_INITIAL_EXPERIENCE);
    }

    @Test
    public void axeLosesDurability() {
        //Act
        this.weapon.attack(this.targetMock);
        //Assert
        Assert.assertEquals("Wrong durability lose", AXE_EXPECTED_DURABILITY, this.weapon.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void attackWithBrokenAxe() {
        //Act
        this.weapon.attack(this.targetMock);
        this.weapon.attack(this.targetMock);
    }
}