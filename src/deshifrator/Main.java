package deshifrator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Шифрователь текса.");
        System.out.print("Введите текст: ");
        String andrew = scanner.nextLine();
        System.out.print("Введите ключ: ");
        int key = scanner.nextInt();
        System.out.println(encrypt(andrew, key));
        andrew = encrypt(andrew, key);
        System.out.println(deEncrypt(andrew, key));

    }

    public static String encrypt(String text, int key) {
        return workIt(text, key);
    }

    public static String deEncrypt(String text, int key) {
        return workIt(text, key);
    }

    private static String workIt(String text, int key) {
        char[] texts = text.toCharArray();
        for (int i = 0; i < text.length(); i++) {
            int encrypt = texts[i];
            text = text.replace(texts[i], (char) (encrypt ^ key));
        }
        return text;
    }
}
