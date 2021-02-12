package tasksBySf.module12;

public class CheckResults {
    private static int counter;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            for (int i = 0; i < 500; i++) {
                CheckResults.counter++;
            }
        }).start();
        while (CheckResults.counter < 500) {
            System.out.println("Not reached yet");
            Thread.sleep(1000);
        }
        System.out.println("Reached");
    }
}
