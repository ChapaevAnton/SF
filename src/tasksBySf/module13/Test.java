package tasksBySf.module13;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class Test {

    private static AtomicInteger sheepCount1 = new AtomicInteger(0);
    private static int sheepCount2 = 0;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            new Thread() {
                public void run() {
                    sheepCount1.getAndIncrement();
                    sheepCount2++;
                }
            }.start();
        }
        Thread.sleep(1000); // достаточное время для завершения всех задач
        System.out.println(sheepCount1 + " " + sheepCount2);
    }
}
