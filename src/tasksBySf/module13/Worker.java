package tasksBySf.module13;

import java.util.ArrayList;
import java.util.List;

public class Worker {
    private final List<String> list1 = new ArrayList<>();
    private final List<String> list2 = new ArrayList<>();

    synchronized void addToListOne() {
        synchronized (list1) {
            for (int i = 0; i < 100000; i++) {
                list1.add("One");  // добавляем в первый лист значение
            }
        }
    }

    synchronized void addToListTwo() {
        synchronized (list2) {
            for (int i = 0; i < 100000; i++)
                list2.add("Two"); // добавляем во второй лист значение
        }
    }

    class Process extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 300; i++) {
                addToListOne();
                addToListTwo();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Worker worker = new Worker();
        Thread t1 = worker.new Process();
        Thread t2 = worker.new Process();

        long start = System.currentTimeMillis();

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        long finish = System.currentTimeMillis();

        System.out.println("list 1 size is: " + worker.list1.size());
        System.out.println("list 2 size is: " + worker.list2.size());
        // замеряем время выполнения
        System.out.println("Time taken: " + (finish - start) + " ms");
    }
}

