package Interview.javaCore;

public class Q11_Finalize {
  
    public static void main(String[] args) {
        try{
            int x = 10/0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("finally");
        }
    }
}
