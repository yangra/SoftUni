package _01Logger.models;

import _01Logger.models.enums.ReportLevel;
import _01Logger.models.interfaces.Appender;
import _01Logger.models.interfaces.Layout;

import java.math.BigInteger;

public class ConsoleAppender extends AppenderImpl implements Appender {


    public ConsoleAppender(Layout layout) {
        super(layout);
    }

    @Override
    public void append(String dateTime, String error, String type) {
        if (this.getReportLevel().ordinal() <= ReportLevel.valueOf(type).ordinal()) {
            String log = super.getLayout().format(dateTime, error, type);
            System.out.println(log);
            super.setAppendedMessages(super.getAppendedMessages().add(BigInteger.ONE));
        }
    }


}
