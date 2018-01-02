package app;

import app.contracts.*;
import app.core.BattlefieldImplementation;
import app.core.EngineImpl;
import app.factory.ActionFactoryImpl;
import app.factory.TargetableFactoryImpl;
import app.io.ConsoleReader;
import app.io.ConsoleWriter;


import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();
        ActionFactory actionFactory = new ActionFactoryImpl();
        TargetableFactory targetableFactory = new TargetableFactoryImpl();
        Battlefield battleField = new BattlefieldImplementation(writer, targetableFactory, actionFactory);

        Engine engine = new EngineImpl(writer,reader,battleField);
        engine.run();

    }
}
