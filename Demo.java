public class Demo {
    public static void main(String[] args) {
        int n = 4;
        int result = 0;
        // if(n % 2 == 0)
        // System.out.println("Even");
        // else
        // System.out.println("Odd");
        result = n % 2 == 0 ? 10 : 20;
        System.out.println(result);
        switch (n) {
            case 1:
                System.out.println("Sunday");
                break;
            case 2:
                System.out.println("Monday");
                break;
            case 3:
                System.out.println("Tuesday");
                break;
            case 4:
                System.out.println("Wednesday");
                break;
            case 5:
                System.out.println("Thursday");
                break;
            case 6:
                System.out.println("Friday");
                break;
            case 7:
                System.out.println("Saturday");
                break;
            default:
                System.out.println("Enter the valid no.");
                break;
        }
        int i = 1;
        while (i <= 4) {
            System.out.println("Hello-Hi");
            i++;
        }
        do {
            System.out.println("Hi");
            i++;
        } while (i < 10);
        for (int j = 0; j < 10; j++) {
            System.out.println("For in Hello");
        }
    }

}
