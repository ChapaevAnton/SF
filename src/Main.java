import deshifrator.Enigma;

import java.util.Scanner;

import static deshifrator.Encryption.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Шифрователь текста.");
        System.out.print("Введите текст: ");
        String andrew = scanner.nextLine();
        System.out.print("Введите ключ: ");
        String key = scanner.nextLine();

        String str = encrypt(andrew, key);
        String str1 = encrypt(andrew, key, ATBASH_ENCRYPT);
        String str2 = encrypt(andrew, key, ENIGMA_ENCRYPT);

        System.out.println("=========================");

        System.out.println("ЗАШИФРОВАННОЕ СООБЩЕНИЕ:");
        System.out.println();
        System.out.println("XOR: " + str);
        System.out.println("ATBASH: " + str1);
        System.out.println("ENIGMA M3: " + str2);

        System.out.println("=========================");

        System.out.println("ИСХОДНОЕ СООБЩЕНИЕ:");
        System.out.println();
        System.out.println("XOR: " + deEncrypt(str, key));
        System.out.println("ATBASH: " + deEncrypt(str1, key, ATBASH_ENCRYPT));
        System.out.println("ENIGMA M3: " + deEncrypt(str2, key, ENIGMA_ENCRYPT));



    }


}