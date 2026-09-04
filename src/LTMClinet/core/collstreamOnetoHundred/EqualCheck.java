package LTMClinet.core.collstreamOnetoHundred;

public class EqualCheck {
    public static void main(String[] args) {
        String s1 = new String(" Java ");
        String s2 = new String(" jAVA A ");
        int sum = 0;
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s2));
        for (int i = 0; i < 5; i++) {
            sum += i;
        }
        String concat = s1.concat("8");
        System.out.println(sum);
        System.out.println(s1);
        System.out.println(concat);
        String trim = s1.trim();
        String strip = s2.strip();
        System.out.println(trim);
        System.out.println(strip);
        String s = "abc";
        System.out.println(s.substring(1, 2));

    }
}
