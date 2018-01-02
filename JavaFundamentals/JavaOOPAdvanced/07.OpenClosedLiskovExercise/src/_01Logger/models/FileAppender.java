package _01Logger.models;

import _01Logger.models.enums.ReportLevel;
import _01Logger.models.interfaces.Appender;
import _01Logger.models.interfaces.File;
import _01Logger.models.interfaces.Layout;


import java.math.BigInteger;

public class FileAppender extends AppenderImpl implements Appender {

    private File logFile;

    public FileAppender(Layout layout) {
        super(layout);
    }

    public void setFile(File file) {
        this.logFile = file;
    }

    @Override
    public void append(String dateTime, String error, String type) {
        if (this.getReportLevel().ordinal() <= ReportLevel.valueOf(type).ordinal()) {
            //List<String> log = Arrays.asList(super.getLayout().format(dateTime, error, type).split("\\n"));
            String log = super.getLayout().format(dateTime, error, type);
            this.logFile.write(log);
            super.setAppendedMessages(super.getAppendedMessages().add(BigInteger.ONE));
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", File size: " + this.logFile.getSize();
    }

}
