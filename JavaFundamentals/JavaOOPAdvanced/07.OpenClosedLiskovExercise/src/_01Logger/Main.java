package _01Logger;

import _01Logger.controllers.AppenderController;
import _01Logger.engine.Engine;
import _01Logger.models.MessageLogger;
import _01Logger.repositories.AppenderRepository;
import _01Logger.repositories.AppenderRepositoryImpl;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        AppenderController controller = new AppenderController(reader);
        AppenderRepository repository = new AppenderRepositoryImpl();

        Engine engine = new Engine(reader, controller, repository);
        engine.run();
    }
}
