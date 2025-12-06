package Interview.javaCore;

public class Q10_StringCreation {
    public static void main(String[] args) {
        String str1 = "String1"; // goes into the object poll
        String str2 = new String("String2"); //creates a new object heap
        String str3 = new StringBuilder("St").append("rin").append("g3").toString(); // dynamic string
        char[] arr = {'S', 't', 'r', 'i', 'n', 'g', '4'};
        String str4 = new String(arr);
        System.out.println(str1 + " " + str2 + " " + str3 + " " + str4);

        String s1 = new String("hello");// Creates a new string object in the heap
        String s2 = s1.intern(); // Adds "hello" to the pool and returns a reference to it
        String s3 = "hello"; // Directly references the "hello" in the string pool
        System.out.println(s1 == s2); // false (s1 is in heap, s2 is in pool)
        System.out.println(s2 == s3);

    }
}
