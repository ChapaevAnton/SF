package tasksBySf;

import java.util.Scanner;

public class NumberOfPhone {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isCorrectNumber = false;
        while (!isCorrectNumber) {
            String number = scanner.nextLine();
            isCorrectNumber = checkNumber(number);
            if (!isCorrectNumber) {
                System.out.println("Введите номер корректно");
            } else {
                System.out.println(formatNumber(number));
            }
        }
    }

    private static boolean checkNumber(String number) {
        String clean = number.replaceAll("[^0-9]", "");
        return clean.length() == 11;
    }

    private static String formatNumber(String number) {
        String clean = number.replaceAll("[^0-9]", "");
        return "+7" + " " + clean.substring(1, 4) + " " + clean.substring(4, 7) + " " +
                clean.substring(7,9) + " " + clean.substring(9);
    }
}
