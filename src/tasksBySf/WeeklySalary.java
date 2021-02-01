package tasksBySf;

public class WeeklySalary {
    public static int calculate(int[] hours){
        int result = 0;
        for (int i = 0; i < hours.length; i++) {
            if(i <= 4) {
                result += hours[i] <= 8 ? hours[i] * 10 : (hours[i] - 8) * 15 + 8 * 10;
            } else {
                result += hours[i] <= 8 ? hours[i] * 20 : (hours[i] - 8) * 30 + 8 * 20;
            }
        }
        return result;
    }
}
