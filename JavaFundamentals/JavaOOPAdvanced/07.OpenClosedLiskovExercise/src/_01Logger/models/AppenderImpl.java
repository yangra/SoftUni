package _01Logger.models;

import _01Logger.models.enums.ReportLevel;
import _01Logger.models.interfaces.Appender;
import _01Logger.models.interfaces.Layout;

import java.math.BigInteger;

public abstract class AppenderImpl implements Appender {

    private Layout layout;
    private ReportLevel reportLevel;
    private BigInteger appendedMessages;

    protected AppenderImpl(Layout layout) {
        this.layout = layout;
        this.reportLevel = ReportLevel.INFO;
        this.appendedMessages = BigInteger.ZERO;
    }

    protected Layout getLayout() {
        return this.layout;
    }

    @Override
    public void setReportLevel(ReportLevel reportLevel) {
        this.reportLevel = reportLevel;
    }

    protected ReportLevel getReportLevel(){
        return this.reportLevel;
    }

    protected BigInteger getAppendedMessages() {
        return this.appendedMessages;
    }

    protected void setAppendedMessages(BigInteger appendedMessages) {
        this.appendedMessages = appendedMessages;
    }

    @Override
    public String toString() {
        return String.format("Appender type: %s, Layout type: %s, Report level: %s, Messages appended: %d",
                this.getClass().getSimpleName(), this.layout.getClass().getSimpleName(),
                this.reportLevel.name(), this.appendedMessages);
    }
}
