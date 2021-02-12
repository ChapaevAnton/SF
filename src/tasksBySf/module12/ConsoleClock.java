package tasksBySf.module12;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ConsoleClock extends Thread {
//    private final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
//
//    @Override
//    public void run() {
//
//        while (true){
//            System.out.println(dateFormat.format(Calendar.getInstance().getTime()));
//            try {
//                Thread.sleep(1000);
//            }catch (InterruptedException e){
//                System.out.println("The clock was stopped");
//                break;
//            }
//        }
//    }

    @Override
    public void run() {
        while (!isInterrupted()){
            DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
            Calendar cali = Calendar.getInstance();
            cali.getTime();
            String time = timeFormat.format(cali.getTimeInMillis());
            System.out.println(time);
            try {
                Thread.sleep(1000);
            }
            catch(InterruptedException e){
                break;
            }
        }
        System.out.println("The clock was stopped");
    }

    public static void main(String[] args) throws InterruptedException {
        ConsoleClock consoleClock = new ConsoleClock();
        consoleClock.start();
        Thread.sleep(3000);
        consoleClock.interrupt();

    }

}
