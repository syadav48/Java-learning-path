package Interview.outputbasedjava.string;

public class PassByRef {
    public static int change(int a){
        a = 100;
        return a;
    }
    public static void changeStr(StringBuilder str){
        str.append("Lyf");
        str = new StringBuilder("new");
        System.out.println(str);

    }
    public static void main(String[] args) {
        int a = 50;
        StringBuilder stringBuilder = new StringBuilder("Coding");
        change(a);
        System.out.println(a);
        changeStr(stringBuilder);
        System.out.println(stringBuilder);
    }
}
