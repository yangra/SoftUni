package _01Logger.models.interfaces;

public interface Logger {

    void logError(String date, String error);

    void logWarning(String date, String warning);

    void logInfo(String date, String info);

    void logCritical(String date, String critical);

    void logFatal(String date, String fatal);
}
