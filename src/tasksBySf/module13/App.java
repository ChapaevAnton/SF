package tasksBySf.module13;

import java.util.concurrent.atomic.AtomicInteger;

public class App {
    private AtomicInteger count = new AtomicInteger(0);


    public static void main(String[] args) throws InterruptedException {
        App app = new App();
        app.doWork();
    }

    private void doWork() throws InterruptedException {
        Thread t1 = new Thread() {
            public void run() {
                for (int i = 0; i < 100000; i++) {
                    count.incrementAndGet();
                }
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                for (int i = 0; i < 100000; i++) {
                    count.incrementAndGet();
                }
            }
        };

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Count is: " + count); // Count is: 20000
    }
}
