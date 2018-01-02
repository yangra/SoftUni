package _01Logger.engine;

import _01Logger.controllers.AppenderController;
import _01Logger.models.MessageLogger;
import _01Logger.models.interfaces.Appender;
import _01Logger.models.interfaces.Logger;
import _01Logger.repositories.AppenderRepository;
import _01Logger.repositories.AppenderRepositoryImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Engine implements Runnable {

    private BufferedReader reader;
    private AppenderController controller;
    private Logger logger;
    private AppenderRepository appenderRepository;

    public Engine(BufferedReader reader,
                  AppenderController controller,
                  AppenderRepository repository) {
        this.reader = reader;
        this.controller = controller;
        this.appenderRepository = repository;
    }

    @Override
    public void run() {
        try {
            int numberOfAppenders = Integer.parseInt(reader.readLine());
            for (int i = 0; i < numberOfAppenders; i++) {
                Appender appender = controller.readAppender();
                this.appenderRepository.add(appender);
            }

            initLogger();

            while (true) {
                String[] data = controller.readMessageData();
                if ("END".equals(data[0])) {
                    break;
                }
                logMessage(data);
            }

            getReport();

        } catch (IOException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private void getReport() {
        System.out.println(logger.toString().trim());
    }

    private void initLogger() {
        this.logger = new MessageLogger(this.appenderRepository.findAll());
    }

    private void logMessage(String[] data) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
            String type = data[0].toUpperCase().charAt(0) + data[0].substring(1).toLowerCase();
            Method methodLog = this.logger.getClass().getDeclaredMethod("log" + type, String.class, String.class);
            methodLog.invoke(this.logger, data[1], data[2]);
        }
    }

