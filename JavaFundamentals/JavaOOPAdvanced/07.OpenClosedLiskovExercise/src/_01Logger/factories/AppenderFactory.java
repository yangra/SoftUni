package _01Logger.factories;

import _01Logger.models.ConsoleAppender;
import _01Logger.models.FileAppender;
import _01Logger.models.LogFile;
import _01Logger.models.interfaces.Appender;
import _01Logger.models.interfaces.File;
import _01Logger.models.interfaces.Layout;

public final class AppenderFactory {
    public AppenderFactory() {
    }

    public static Appender createFileAppender(Layout layout){
        FileAppender appender = new FileAppender(layout);
        File file = new LogFile();
        appender.setFile(file);
        return appender;
    }

    public static Appender createConsoleAppender(Layout layout){
        return new ConsoleAppender(layout);
    }
}
