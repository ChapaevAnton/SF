package tasksBySf.module12;

public class JoinExample {
    private static int counter;

    public static void main(String[] args) throws InterruptedException {
      Thread t1 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 5000000; i++) {
                    JoinExample.counter++;
                }
            }
        };
        t1.start();
        t1.join();


        System.out.println("Counter value: " + counter);
    }
}
