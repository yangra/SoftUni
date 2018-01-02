package _01Logger.repositories;

import _01Logger.models.interfaces.Appender;

import java.util.ArrayList;
import java.util.List;


public class AppenderRepositoryImpl implements AppenderRepository {
    private List<Appender> appenders;

    public AppenderRepositoryImpl() {
        this.appenders = new ArrayList<>();
    }

    @Override
    public void add(Appender appender) {
        this.appenders.add(appender);
    }

    @Override
    public List<Appender> findAll() {
        return this.appenders;
    }
}
