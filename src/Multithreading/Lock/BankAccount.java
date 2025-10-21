package Multithreading.Lock;

public class BankAccount {
    private int balance = 100;

    public synchronized void withdraw(int amount) {
        if(balance >= amount){
            System.out.println(Thread.currentThread().getName() + "proceeding with withdrawls");
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + "complete withdrawl. Remaining Balance:" + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + "insuffecient balance");
        }
    }
}
