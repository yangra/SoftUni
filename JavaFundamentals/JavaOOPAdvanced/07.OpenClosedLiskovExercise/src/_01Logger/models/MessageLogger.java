package _01Logger.models;

import _01Logger.models.interfaces.Appender;
import _01Logger.models.interfaces.Logger;

import java.util.Collection;
import java.util.Collections;

public class MessageLogger implements Logger {


    private Collection<Appender> appenders;

    public MessageLogger(Collection<Appender> appenders) {
        this.appenders = appenders;

    }

    @Override
    public void logError(String date, String error) {
        for (Appender appender : this.appenders) {
            appender.append(date, error, "ERROR");
        }
    }

    @Override
    public void logWarning(String date, String warning) {
        for (Appender appender : this.appenders) {
            appender.append(date, warning, "WARNING");
        }
    }

    @Override
    public void logInfo(String date, String info) {
        for (Appender appender : this.appenders) {
            appender.append(date, info, "INFO");
        }
    }

    @Override
    public void logCritical(String date, String critical) {
        for (Appender appender : this.appenders) {
            appender.append(date, critical, "CRITICAL");
        }
    }

    @Override
    public void logFatal(String date, String fatal) {
        for (Appender appender : this.appenders) {
            appender.append(date, fatal, "FATAL");
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Logger info").append(System.lineSeparator());
        for (Appender appender : this.appenders) {
            builder.append(appender).append(System.lineSeparator());
        }
        return builder.toString();
    }
}
