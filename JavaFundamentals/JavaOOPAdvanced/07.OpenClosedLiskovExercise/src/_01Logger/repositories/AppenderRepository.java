package _01Logger.repositories;

import _01Logger.models.interfaces.Appender;

import java.util.Collection;

public interface AppenderRepository {

    void add(Appender appender);

    Collection<Appender> findAll();
}
