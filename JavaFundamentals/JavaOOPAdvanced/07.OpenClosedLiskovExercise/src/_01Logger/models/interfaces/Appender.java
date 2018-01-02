package _01Logger.models.interfaces;

import _01Logger.models.enums.ReportLevel;

public interface Appender {

    void append(String dateTime, String error, String type);

    void setReportLevel(ReportLevel reportLevel);
}
