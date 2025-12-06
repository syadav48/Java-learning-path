package Interview.javaCore;

public class Equals {

    public static void main(String[] args) {
        String a = new String("CodingLyf");
        String b = new String("CodingLyf");
        int[] arr1 = {1,2,3};
        int[] arr2 = {1,2,3};

        System.out.println(a == b); // double equals check the references
        System.out.println(a.equals(b));// equals method check the content/value

        System.out.println(arr1 == arr2);
        System.out.println(arr1.equals(arr2));
    }
}
