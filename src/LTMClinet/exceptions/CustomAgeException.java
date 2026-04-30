package LTMClinet.exceptions;

public class CustomAgeException {
    public double balance = 10000;
    public static void ageInvalidException(int age) throws InvalidRuntimeException{
        if(age < 18){
            throw new InvalidRuntimeException("Age must be grater than 18!!");
        }
    }
    public static void checkAgeException(int age) throws InvalidAgeException{
        if(age < 18){
            throw new InvalidAgeException("Age must be grater than 18!!");
        }
    }


    public static void main(String[] args) {
        int age = 15;
        try{
            CustomAgeException.checkAgeException(19);
            CustomAgeException.ageInvalidException(age);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
