package exceptions;

public class CustomException {
    public static void checkAge(int age) throws InvalidAgeException{
        if(age < 18){
            throw new InvalidAgeException("Age must be of 18 Years of Age");
        }
        System.out.println("Eligible to vote");
    }
    public static void checkAgeRuntime(int age) throws InvalidRuntimeException{
        if(age < 18){
            throw new InvalidRuntimeException("Age must be of 18 Years of Age");
        }
        System.out.println("Eligible to vote");
    }
    public static void main(String[] args) {
        try {
            CustomException.checkAge(18);

        } catch (InvalidAgeException e) {
            throw new RuntimeException(e);
        }
        CustomException.checkAgeRuntime(12);

    }
}
