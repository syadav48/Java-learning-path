package Interview.outputbasedjava.string;

public class InstanceExecution {
    int x = Test();
    {
        System.out.println("block execution checking");
    }
    InstanceExecution(){
        System.out.println("constructor execution");
    }
    private int Test(){
        System.out.println("Test method called");
        return 1;
    }
    public static void main(String[] args) {
        System.out.println("main execution");
        new InstanceExecution();
    }
}
