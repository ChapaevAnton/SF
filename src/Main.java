import deshifrator.EncryptedString;

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
        String str1 = encrypt(andrew, key, ATBASH_ENCRYPT).toString();

        System.out.println("XOR: " + str);
        System.out.println("ATBASH: " + str1);

        System.out.println(deEncrypt(str, key));
        System.out.println(deEncrypt(str1, key, ATBASH_ENCRYPT));

        EncryptedString strEncrypt = encrypt(andrew, key, ATBASH_ENCRYPT);

        System.out.println(strEncrypt);
        strEncrypt.getStrInfo();

        EncryptedString strEncrypt1 = EncryptedString.getEncryptString(andrew);
        System.out.println(strEncrypt1);
        strEncrypt1.getStrInfo();

        String str2 = strEncrypt1.toString();
        System.out.println(str2);


    }
}
