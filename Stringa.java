public class Stringa {
    public static void main(String[] args) {
        String name = new String("Suryoday");
        String othername = "Sangita";
        System.out.println(name + othername);
        System.out.println("Hello" + name.concat("Yadav"));

        StringBuffer sb = new StringBuffer("Sangita");
        System.out.println(sb.capacity());
        sb.append("Choudhary");
        sb.deleteCharAt(3);
        System.out.println(sb);
    }
}
