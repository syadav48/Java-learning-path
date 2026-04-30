package LTMClinet.exceptions;

public class InsuffecientBalanceException extends Exception{
    private final String errorCode;
    public InsuffecientBalanceException(String message, String errorCode){
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
