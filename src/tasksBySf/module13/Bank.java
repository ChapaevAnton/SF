package tasksBySf.module13;

import java.util.concurrent.atomic.AtomicInteger;

public class Bank {
    private AtomicInteger money = new AtomicInteger();
    // переменная, по которой и будем синхронизироваться
    private Object lock = new Object();


    Bank() {
        money.set(10000);
        new Client().start();
        new Client().start();
        new Client().start();
    }

    void take(int money) {
        this.money.addAndGet(-money);
    }

    void repay(int money) {
            this.money.addAndGet(money);
    }

    public int getMoney() {
        return money.get();
    }

    class Client extends Thread {
        @Override
        public void run() {
            while (true) {
                take(1000);
                repay(1000);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();
        while (true) {
            System.out.println(bank.getMoney());
            Thread.sleep(1000);
        }
    }
}
