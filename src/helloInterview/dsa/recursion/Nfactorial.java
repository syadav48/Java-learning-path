package helloInterview.dsa.recursion;

public class Nfactorial {
    public int factorial(int num){
        if(num <= 1){
            return 1;
        }
        return num * factorial(num - 1);

    }
    public static void main(String[] args) {
        Nfactorial nfactorial = new Nfactorial();
        int n = 5;
        System.out.println(nfactorial.factorial(n));
        // 5*fac(4) -> 5*4*fac(3) -> 5*4*3*fac(2) -> 5*4*3*2*fac(1) -> 5*4*3*2*1;
    }
}
