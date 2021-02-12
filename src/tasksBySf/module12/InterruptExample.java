package tasksBySf.module12;

import tasksBySf.level11.Car;

public class InterruptExample {
    public static void main(String[] args) throws InterruptedException {
        Thread threadToInterrupt = new Thread() {
            @Override
            public void run() {
                while (true){
                    System.out.println("Working hard");
                    try{
                        Thread.sleep(500);
                    } catch (InterruptedException e){
                        System.out.println("Interrupted");
                        break;
                    }
                }
            }
        };

        threadToInterrupt.start();
        Thread.sleep(2500);
        threadToInterrupt.interrupt();

    }
}
