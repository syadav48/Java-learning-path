package LTMClinet.exceptions;

import exceptions.CustomException;

public class CustomExceptions {
    private final static double balance = 10000;
    public static void withDrawException(double amount) throws InsuffecientBalanceException {
        if(amount < balance){
            throw new InsuffecientBalanceException("Low Balance", "BAL_101");
        }
    }
    public static void checkedNullException() throws CustomNullPointer {

            throw new CustomNullPointer("Throwing Null pointer");

    }
    public static void main(String[] args) throws InsuffecientBalanceException {

        CustomExceptions.checkedNullException();
    }
}
