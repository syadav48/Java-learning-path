package LTMClinet.notes;

import java.util.List;

public class StaticBlock {
    private static int count = 0;
    static {
        System.out.println("Hey I am here as a static block");
    }
    private static void counter(){
        count++;
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) {
        System.out.println("I will be called first!!");
        List<Integer> list = List.of(1, 2, 2, 3);
        String str = "Ravi";
        str = "Ravi Kumar";
        String s = new String("Neha");
        s = new String("Neha Singh");
        ImmutableObject immutableObject = new ImmutableObject(10, list);
        ImmutableObject a = immutableObject;
        immutableObject = new ImmutableObject(45, list);
        System.out.println(immutableObject.getCount());
        System.out.println(a.getCount());
        //immutableObject.getList().add(34);
        System.out.println(immutableObject.getList());
        StaticBlock.counter();
        StaticBlock.counter();
        StaticBlock.counter();
        StaticBlock staticBlock = new StaticBlock();
        System.out.println(staticBlock.getCount());


    }
}
