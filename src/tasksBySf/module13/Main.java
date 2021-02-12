package tasksBySf.module13;

public class Main implements Runnable {

    public void run() {
        System.out.print("A");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print("B");
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Main()).start();
        new Thread(new Main()).start();
    }
}


