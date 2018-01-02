package app;

import app.waste_disposal.DefaultGarbageProcessor;
import app.waste_disposal.DefaultStrategyHolder;
import app.waste_disposal.annotations.Burnable;
import app.waste_disposal.annotations.Recyclable;
import app.waste_disposal.annotations.Storable;
import app.waste_disposal.contracts.*;
import app.waste_disposal.core.Engine;
import app.waste_disposal.core.WasteController;
import app.waste_disposal.io.ConsoleInputReader;
import app.waste_disposal.io.ConsoleOutputWriter;
import app.waste_disposal.models.strategies.Burning;
import app.waste_disposal.models.strategies.Recycling;
import app.waste_disposal.models.strategies.Storing;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        InputReader inputReader = new ConsoleInputReader(reader);
        OutputWriter outputWriter = new ConsoleOutputWriter();

        StrategyHolder strategyHolder = new DefaultStrategyHolder();
        GarbageDisposalStrategy recyclingStrategy = new Recycling();
        GarbageDisposalStrategy burningStrategy = new Burning();
        GarbageDisposalStrategy storingStrategy = new Storing();
        strategyHolder.addStrategy(Recyclable.class,recyclingStrategy);
        strategyHolder.addStrategy(Burnable.class,burningStrategy);
        strategyHolder.addStrategy(Storable.class,storingStrategy);
        GarbageProcessor garbageProcessor = new DefaultGarbageProcessor(strategyHolder);
        WasteController wasteController = new WasteController(garbageProcessor);

        Engine engine = new Engine(inputReader, outputWriter, wasteController);
        engine.run();
    }
}
