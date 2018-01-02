package rpg.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg.interfaces.Target;
import rpg.interfaces.Weapon;
import rpg.utilities.RandomProvider;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HeroTest {
    private static final int EXPECTED_TARGET_XP = 2;
    private static final String HERO_NAME = "Pesho";
    private static final String GAIN_EXPERIENCE_ERROR_MESSAGE = "Hero doesn't gain experience properly";
    private static final String COLLECT_LOOT_ERROR_MESSAGE = "Does not collect loot properly";

    private Target targetMock;
    private Weapon weaponMock;
    private RandomProvider randomMock;
    private Hero hero;

    @Before
    public void init(){
        this.targetMock = mock(Target.class);
        this.weaponMock = mock(Weapon.class);
        this.randomMock = mock(RandomProvider.class);
        this.hero = new Hero(HERO_NAME,this.weaponMock);
    }

    @Test
    public void heroGainsXPIfTargetIsDead(){

        when(this.targetMock.giveExperience()).thenReturn(2);
        when(this.targetMock.isDead()).thenReturn(true);

        this.hero.attack(this.targetMock,this.randomMock);

        Assert.assertEquals(GAIN_EXPERIENCE_ERROR_MESSAGE,EXPECTED_TARGET_XP,hero.getExperience());
    }

    @Test
    public void heroGetsLootWhenTargetIsDead(){
        when(this.targetMock.isDead()).thenReturn(true);
        when(this.targetMock.giveLoot(randomMock)).thenReturn(weaponMock);

        this.hero.attack(targetMock,randomMock);

        Assert.assertSame(COLLECT_LOOT_ERROR_MESSAGE,this.weaponMock,this.hero.getInventory().iterator().next());
    }
}
