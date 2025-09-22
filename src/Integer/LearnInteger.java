package Integer;

public class LearnInteger {
    public static void main(String[] args) {
        int a = Integer.MAX_VALUE;
        int b = Integer.MIN_VALUE;
        int c = 43;
        String d = Integer.toString(c);
        int e = Integer.parseInt(d);
        String f = Integer.toString(c, 2);
        int g = Integer.parseInt(f, 2);
        System.out.println(d + " " + e + " " + f + " " + g);

        // bit manipulation:
        Integer i1 = Integer.decode("0x1A");   // 26 (hex string to int)
        Integer i2 = Integer.decode("075");    // 61 (octal string to int)

        int h = 5; // 0101
        int i = 3; // 0011

        System.out.println(Integer.bitCount(h));       // 2 (number of 1s)
        System.out.println(Integer.highestOneBit(h));  // 4 (100)
        System.out.println(Integer.lowestOneBit(h));   // 1 (001)
        System.out.println(Integer.numberOfLeadingZeros(h)); // 29
        System.out.println(Integer.numberOfTrailingZeros(h)); // 0

        System.out.println(Integer.toBinaryString(10));   // "1010"
        System.out.println(Integer.toHexString(255));     // "ff"
        System.out.println(Integer.toOctalString(64));    // "100"


        System.out.println(Integer.compare(5, 10)); // -1
        System.out.println(Integer.compareUnsigned(5, 10)); // -1
        System.out.println(Integer.max(5, 10));     // 10
        System.out.println(Integer.min(5, 10));     // 5
        System.out.println(Integer.sum(5, 10));     // 15

        int u = -1;
        System.out.println(Integer.toUnsignedString(u)); // "4294967295"
        System.out.println(Integer.divideUnsigned(10, 3)); // 3
        System.out.println(Integer.remainderUnsigned(10, 3)); // 1



    }
};
