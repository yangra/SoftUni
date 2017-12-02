package _02WarningLevels;

public class Message {
    private String message;
    private Importance importance;

    public Message(String importance, String message) {
        this.message = message;
        this.importance = Importance.valueOf(importance.toUpperCase());
    }

    public Importance getImportance() {
        return this.importance;
    }

    @Override
    public String toString() {
        return this.importance.name() + ": " + this.message;
    }
}
