package exceptions;

// Compile time exception:
public class InvalidAgeException extends Exception{
        public InvalidAgeException(){
            super();
        }
        public InvalidAgeException(String message){
            super(message);
        }
        public InvalidAgeException(String message, Throwable cause){
            super(message, cause);
        }
}
