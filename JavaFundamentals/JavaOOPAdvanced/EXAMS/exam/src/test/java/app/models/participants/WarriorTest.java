package app.models.participants;

import app.contracts.Hero;
import app.contracts.Targetable;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

public class WarriorTest {

    private Hero warrior;
    private Hero warrior1;

    @Before
    public void init() {
        this.warrior = new Warrior();
        this.warrior1 = Mockito.mock(Warrior.class);
        Mockito.when(warrior1.getStrength()).thenReturn(5);
        Mockito.when(warrior1.getDexterity()).thenReturn(4);
        Mockito.when(warrior1.getIntelligence()).thenReturn(1);
//        Mockito.when(warrior1.getGold()).thenReturn(200.0);

    }

    @Test
    public void takeDamage() {
        this.warrior.takeDamage(5.0);
        Assert.assertEquals(45.0, this.warrior.getHealth());
    }

    @Test
    public void isAlive() {
        this.warrior.takeDamage(60.0);

        Assert.assertEquals(false, this.warrior.isAlive());
    }

    @Test
    public void levelUp() throws NoSuchFieldException, IllegalAccessException {
        this.warrior.levelUp();
        Assert.assertEquals(10, this.warrior.getStrength());
        Assert.assertEquals(8, this.warrior.getDexterity());
        Assert.assertEquals(2, this.warrior.getIntelligence());

        Field levelField = Warrior.class.getField("level");
        levelField.setAccessible(true);
        int level = (int) levelField.get(this.warrior);

        Assert.assertEquals(2, level);

    }

//    @Test
//    public void giveReward(){
//        this.warrior.giveReward(this.warrior1);
//
//        Assert.assertEquals(400, this.warrior1.getGold());
//    }
//
//    @Test
//    public void receiveReward(){
//        this.warrior.receiveReward(200);
//
//        Assert.assertEquals(400, warrior.getGold());
//    }


}