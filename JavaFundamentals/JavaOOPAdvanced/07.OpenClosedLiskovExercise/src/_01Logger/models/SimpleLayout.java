package _01Logger.models;

import _01Logger.models.interfaces.Layout;

public class SimpleLayout implements Layout {

    @Override
    public String format(String dateTime, String error, String type) {
        return dateTime + " - " + type + " - " + error;
    }
}
