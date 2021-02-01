package tasksBySf.dateAndCalendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        String date = "";

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(-1000);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
        date = dateFormat.format(calendar.getTime());
        System.out.println(date);

    }
}
