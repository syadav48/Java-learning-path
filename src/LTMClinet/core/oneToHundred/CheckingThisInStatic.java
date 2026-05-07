package LTMClinet.core.oneToHundred;

public class CheckingThisInStatic {
    int num;

    CheckingThisInStatic(int num){
        this.num = num;
    }
    public String checking(){
        return "Sham";
    }
}
class CheckInstance extends CheckingThisInStatic{

    CheckInstance(int num) {
        super(num);
        this.checking();
    }
    @Override
    public String checking(){
        return "Ram";
    }

    public static void main(String[] args) {
        CheckInstance checkInstance = new CheckInstance(10);
        System.out.println(checkInstance.checking());
    }


}
