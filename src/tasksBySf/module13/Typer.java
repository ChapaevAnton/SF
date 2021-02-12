package tasksBySf.module13;

public class Typer extends Thread {
    static Object lock = new Object();
    String message;
    Typer(String message){
        this.message = message;
    }
    public void run(){
        synchronized(lock){
            for(int i = 0; i < message.length(); i++){
                System.out.print(message.charAt(i));
                try{
                    Thread.sleep(500);
                } catch (InterruptedException e){
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        new Typer("Andrew").start();
        new Typer("Marina").start();
    }
}
