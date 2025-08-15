import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class IO {
    public static void main(String[] args) throws IOException { // not recommended, only for demonstration purpose

        System.out.println("Enter a Number");
        // int num1 = System.in.read();

        // System.out.println(num1 - 48);

        // another way
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader bf = new BufferedReader(in);

        int num2 = Integer.parseInt(bf.readLine());
        System.out.println(num2);
        bf.close();
        // modern way after 1.5
        Scanner sc = new Scanner(System.in);
        int num3 = sc.nextInt();
        System.out.println(num3);

        //try and finally
        // try with resources
          try {
            // InputStreamReader in = new InputStreamReader(System.in);
            // BufferedReader bf = new BufferedReader(in);

            // int num2 = Integer.parseInt(bf.readLine());
            // System.out.println(num2);
        } finally {
            bf.close();
        }

        // try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))){
            
        // }   // try with resources

    }
}
