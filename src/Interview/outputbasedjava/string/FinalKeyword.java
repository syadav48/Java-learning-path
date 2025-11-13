package Interview.outputbasedjava.string;

import java.util.Arrays;

public class FinalKeyword {
    public static void main(String[] args) {
        final int a = 10;
        //a = 20; compilation error
        final int [] arr = {1,2,3,4};
        arr[0] = 99;
        // can't be reassigned but can be modified the content
        System.out.println(Arrays.toString(arr));
    }

}
