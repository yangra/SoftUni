package app.models.actions;

import app.contracts.Hero;
import app.contracts.Targetable;
import app.models.participants.Warrior;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class OneVsOneTest {

   private Hero warrior1;
   private Hero warrior2;
   private OneVsOne oneVsOne;

    @Before
    public void  init(){
        warrior1 = Mockito.mock(Warrior.class);
        warrior2 = Mockito.mock(Warrior.class);
        Mockito.when(warrior1.getStrength()).thenReturn(5);
        Mockito.when(warrior1.getDexterity()).thenReturn(4);
        Mockito.when(warrior1.getIntelligence()).thenReturn(1);
        Mockito.when(warrior2.getStrength()).thenReturn(10);
        Mockito.when(warrior2.getDexterity()).thenReturn(8);
        Mockito.when(warrior2.getIntelligence()).thenReturn(2);
        oneVsOne = new OneVsOne();
    }
    @Test
    public void executeAction() throws Exception {
        List<Hero> warriors = new ArrayList<>();
        warriors.add(warrior1);
        warriors.add(warrior2);
        oneVsOne.executeAction(warriors);
    }

}