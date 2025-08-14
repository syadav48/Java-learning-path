class SuryaException extends Exception {
    public SuryaException(String s){
        super(s); // usage of super to manipulate the parent class
    }
}

public class Exceptiona {
    public static void main(String[] args) {
        int i = 18;
        int j = 0;
        int nums[] = new int[5];
        try {
            // executes only in critical statement
            j = 18 / i;
            if(j == 0)
                throw new ArithmeticException("dont want to print 0"); // throw is used to throw the error message and catch will catch it and show it for you, you can't call catch block in every situation, hence use throw to handle it.
            if(j == 1)
                throw new SuryaException("dont want 1 as well");
            System.out.println(nums[6]);
        } 
        catch(SuryaException e){
            System.out.println("cant be divide by 0" + e);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("stay in your limit" + e);
        }
        catch(ArithmeticException e){
            System.out.println("cant devide by zero" + e);
        }
        
        catch (Exception e) {
            // excecute only in exception
            System.out.println("Something went wrong" + e);
        }
        System.out.println(j);
        System.out.println("Bye");
    }
}
