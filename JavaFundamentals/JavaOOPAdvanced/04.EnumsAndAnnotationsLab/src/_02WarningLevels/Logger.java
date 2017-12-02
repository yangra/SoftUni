package _02WarningLevels;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Logger {
    private List<Message> messages;
    private Importance importance;

    public Logger(String importance) {
        this.importance = Importance.valueOf(importance.toUpperCase());
        this.messages = new ArrayList<>();
    }

    public void receiveMessage(Message message) {
        if (this.importance.ordinal() <= message.getImportance().ordinal()) {
            this.messages.add(message);
        }
    }

    public Iterable<Message> getMessages() {
        return Collections.unmodifiableList(this.messages);
    }

}
