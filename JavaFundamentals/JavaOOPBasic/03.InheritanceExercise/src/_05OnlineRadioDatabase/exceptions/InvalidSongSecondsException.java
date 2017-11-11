package _05OnlineRadioDatabase.exceptions;

public class InvalidSongSecondsException extends InvalidSongLengthException {
    public InvalidSongSecondsException(String message) {
        super(message);
    }
}
