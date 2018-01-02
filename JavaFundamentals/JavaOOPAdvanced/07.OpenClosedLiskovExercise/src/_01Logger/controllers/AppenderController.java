package _01Logger.controllers;

import _01Logger.factories.AppenderFactory;
import _01Logger.factories.LayoutFactory;
import _01Logger.models.enums.ReportLevel;
import _01Logger.models.interfaces.Appender;
import _01Logger.models.interfaces.Layout;


import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AppenderController {
    private BufferedReader reader;

    public AppenderController(BufferedReader reader) {
        this.reader = reader;
    }

    public String[] readMessageData() throws IOException {
        String[] data = reader.readLine().split("\\|");
        return data;
    }

    public Appender readAppender() throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String[] appenderData = this.reader.readLine().split("\\s+");
        Method methodCreateLayout = LayoutFactory.class.getDeclaredMethod("create" + appenderData[1]);
        Layout layout = (Layout) methodCreateLayout.invoke(LayoutFactory.class);
        Method createAppender = AppenderFactory.class.getDeclaredMethod("create" + appenderData[0], Layout.class);
        Appender appender = (Appender) createAppender.invoke(AppenderFactory.class, layout);
        if (appenderData.length > 2) {
            appender.setReportLevel(ReportLevel.valueOf(appenderData[2]));
        }

        return appender;
    }
}
