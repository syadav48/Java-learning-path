package LTMClinet.core.oneToHundred;

class A{
    final void showfinal(){
        System.out.println("showing");
    };
    void show(){
        System.out.println("parent");
    }
}
class B extends A{

     void show(){
        System.out.println("Child");
    }
    static void create() throws Exception{
        A a = new A();
        a.show();
        throw new Exception("create always throw");
    }
}



public class Test {
    private int x;
    Test(int x){
        this.x = x;
    }
    public static void main(String[] args) throws Exception {
        B b = new B();
        b.show();
        B.create();
        CheckAbstrat checkAbstrat = new CheckAbstrat() {
            @Override
            int checkInt() {
                return 0;
            }
        };
        System.out.println(checkAbstrat.showMessage());
    }
}


