package LTMClinet.core.oneToHundred;

 abstract class CheckAbstrat {
    abstract int checkInt();
    String showMessage(){
        return "Showing";
    }
    CheckAbstrat(){

    }
}
class Checking extends CheckAbstrat {

    @Override
    int checkInt() {
        return 0;
    }
}
