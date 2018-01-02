package app.waste_disposal;


import app.waste_disposal.contracts.GarbageDisposalStrategy;
import app.waste_disposal.contracts.StrategyHolder;
import app.waste_disposal.fake_classes.FakeDisposable;
import app.waste_disposal.fake_classes.FakeNonDisposable;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Map;


public class DefaultStrategyHolderTest {

    private StrategyHolder strategyHolder;
    private GarbageDisposalStrategy strategy;
    private Class disposable;
    private Class nonDisposable;


    @Before
    public void init() {
        this.strategyHolder = new DefaultStrategyHolder();
        this.strategy = Mockito.mock(GarbageDisposalStrategy.class);
        this.disposable = FakeDisposable.class;
        this.nonDisposable = FakeNonDisposable.class;
    }

//    @Test
//    public void returnEmptyCollectionAfterInitialization() {
//        Map<Class, GarbageDisposalStrategy> strategies = this.strategyHolder.getDisposalStrategies();
//        Assert.assertEquals(0, strategies.size());
//    }

    @Test(expected = IllegalArgumentException.class)
    public void throwIfPassedNonDisposableAnnotation() {
        this.strategyHolder.addStrategy(this.nonDisposable, this.strategy);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwIfPassedNullClassValue() {
        this.strategyHolder.addStrategy(null, this.strategy);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwIfPassedNullStrategy() {
        this.strategyHolder.addStrategy(this.disposable, null);
    }

    @Test
    public void returnFalseWhenPassedExistingStrategy() {
        this.strategyHolder.addStrategy(this.disposable, this.strategy);
        boolean result = this.strategyHolder.addStrategy(this.disposable, this.strategy);

        Assert.assertEquals(false, result);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void returnAReadOnlyCollection() {
        Map<Class, GarbageDisposalStrategy> strategies = this.strategyHolder.getDisposalStrategies();
        strategies.put(this.disposable, this.strategy);
    }

    @Test
    public void addStrategy() {
        this.strategyHolder.addStrategy(this.disposable, this.strategy);
        Map<Class, GarbageDisposalStrategy> strategies = this.strategyHolder.getDisposalStrategies();
        Assert.assertEquals(1,strategies.size());
    }

//    @Test
//    public void getDisposalStrategies() {
//        this.strategyHolder.addStrategy(this.disposable, this.strategy);
//        Assert.assertEquals(1, this.strategyHolder.getDisposalStrategies().size());
//    }

//    @Test
//    public void addStrategy() {
//        this.strategyHolder.addStrategy(this.disposable, this.strategy);
//        Assert.assertEquals(1, this.strategyHolder.getDisposalStrategies().size());
//    }
//
//    @Test
//    public void removeStrategy() {
//        this.strategyHolder.addStrategy(this.disposable, this.strategy);
//        Assert.assertEquals(1, this.strategyHolder.getDisposalStrategies().size());
//        this.strategyHolder.removeStrategy(this.disposable);
//        Assert.assertEquals(0, this.strategyHolder.getDisposalStrategies().size());
//    }

    @Test
    public void addStrategyShouldAddCorrectStrategy() {
        Map<Class, GarbageDisposalStrategy> strategies = this.strategyHolder.getDisposalStrategies();
        this.strategyHolder.addStrategy(this.disposable, this.strategy);
        GarbageDisposalStrategy result = strategies.get(this.disposable);
        Assert.assertEquals(this.strategy, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeNullStrategyReturnsException() throws Exception {
        this.strategyHolder.addStrategy(this.disposable, this.strategy);
        Assert.assertEquals(1, this.strategyHolder.getDisposalStrategies().size());
        this.strategyHolder.removeStrategy(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwWhenRemovingNonDisposable() {
        this.strategyHolder.removeStrategy(this.nonDisposable);
    }

    @Test
    public void shouldReturnFalseWhenRemovingFromEmptyHolder() {
        boolean result = this.strategyHolder.removeStrategy(this.disposable);
        Assert.assertEquals(false, result);
    }

}