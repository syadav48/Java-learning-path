package exceptions;

public class InvalidRuntimeException extends RuntimeException{
    public InvalidRuntimeException(String message){
        super(message);
    }
}
