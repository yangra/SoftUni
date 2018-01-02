package app.waste_disposal;

import app.waste_disposal.contracts.GarbageDisposalStrategy;
import app.waste_disposal.contracts.StrategyHolder;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class DefaultStrategyHolder implements StrategyHolder {

    private Map<Class, GarbageDisposalStrategy> disposalStrategies;

    public DefaultStrategyHolder() {
        this.disposalStrategies = new LinkedHashMap<>();
    }

    @Override
    public Map<Class, GarbageDisposalStrategy> getDisposalStrategies() {
        return Collections.unmodifiableMap(this.disposalStrategies);
    }

    @Override
    public boolean addStrategy(Class annotationClass, GarbageDisposalStrategy strategy) {
        if(annotationClass==null|| strategy==null){
            throw new IllegalArgumentException();
        }

        this.disposalStrategies.put(annotationClass, strategy);
        return true;
    }

    @Override
    public boolean removeStrategy(Class annotationClass) {
        if(annotationClass==null){
            throw new IllegalArgumentException();
        }
        this.disposalStrategies.remove(annotationClass);
        return true;
    }
}
