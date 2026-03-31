package leetcode.leet75.arrstr;

import java.util.Arrays;

public class Compress {
    public int compress(char[] chars) {
        if(chars.length == 1){
            return 1;
        }

        return 2;
    }
    public static void main(String[] args) {
        Compress compress = new Compress();
        char[] chars = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b'}; //a2b2c3
        System.out.println(compress.compress(chars));
    }
}
