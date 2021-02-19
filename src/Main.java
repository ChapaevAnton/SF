import java.util.Scanner;

import static deshifrator.Encryption.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Шифрователь текса.");
        System.out.print("Введите текст: ");
        String andrew = scanner.nextLine();
        System.out.print("Введите ключ: ");
        String key = scanner.nextLine();

        String str = encrypt(andrew, key);
        String str1 = encrypt(andrew, key, ATBASH_ENCRYPT);

        System.out.println(str);
        System.out.println(str1);

        System.out.println(deEncrypt(str, key));
        System.out.println(deEncrypt(str1, key, ATBASH_ENCRYPT));


    }
}
