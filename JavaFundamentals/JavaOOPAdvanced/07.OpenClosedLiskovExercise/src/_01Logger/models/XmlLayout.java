package _01Logger.models;

import _01Logger.models.interfaces.Layout;

public class XmlLayout implements Layout {

    @Override
    public String format(String dateTime, String message, String type) {
        return String.format("<log>\n   <date>%s</date>\n   <level>%s</level>\n" +
                "   <message>%s</message>\n</log>", dateTime, type, message);
    }
}
