import deshifrator.CreatorString;
import deshifrator.EncryptingString;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Шифрователь текса.");
        System.out.print("Введите текст: ");
        String andrew = scanner.nextLine();
        System.out.print("Введите ключ: ");
        String key = scanner.nextLine();

        EncryptingString strCrypt = CreatorString.atbashString.toCreate(andrew);
        strCrypt.getStrInfo();
        System.out.println(strCrypt.encrypt(key));
        System.out.println(strCrypt.deEncrypt(key));
        String str = strCrypt.toString();
        System.out.println(str);

        strCrypt = CreatorString.XoRString.toCreate(andrew);
        strCrypt.getStrInfo();
        System.out.println(strCrypt.encrypt(key));
        System.out.println(strCrypt.deEncrypt(key));
        str = strCrypt.toString();
        System.out.println(str);

    }
}
