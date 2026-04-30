package LTMClinet.exceptions;

public class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
    public InvalidAgeException() {
        super();
    }
    public InvalidAgeException(String message, Throwable cause) {
        super(message, cause);
    }
}
