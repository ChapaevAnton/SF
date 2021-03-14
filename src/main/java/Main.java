import deshifrator.CreatingString;
import deshifrator.EncryptingString;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Шифровать текст");
        System.out.print("Введите текст: ");
        String andrew = scanner.nextLine();
        System.out.print("Введите ключ: ");
        String key = scanner.nextLine();

        EncryptingString strCrypt = CreatingString.atbashString.toCreate(andrew);
        strCrypt.getStrInfo();
        System.out.println("ЗАШИФРОВАНННОЕ СООБЩЕНИЕ atbash:");
        System.out.println(strCrypt.encrypt(key));
        System.out.println("ИСХОДНОЕ СООБЩЕНИЕ atbash:");
        System.out.println(strCrypt.deEncrypt(key));
        String str = strCrypt.toString();
        System.out.println("atbash -> СТРОКА:");
        System.out.println(str);

        strCrypt = CreatingString.XoRString.toCreate(andrew);
        strCrypt.getStrInfo();
        System.out.println("ЗАШИФРОВАННОЕ СООБЩЕНИЕ andrew:");
        System.out.println(strCrypt.encrypt(key));
        System.out.println("ИСХОДНОЕ СООБЩЕНИЕ andrew:");
        System.out.println(strCrypt.deEncrypt(key));
        str = strCrypt.toString();
        System.out.println("XoR -> СТРОКА:");
        System.out.println(str);

        strCrypt = CreatingString.enigmaString.toCreate(andrew);
        strCrypt.getStrInfo();
        System.out.println("ЗАШИФРОВАННОЕ СООБЩЕНИЕ enigma:");
        System.out.println(strCrypt.encrypt(key));
        System.out.println("ИСХОДНОЕ СООБЩЕНИЕ enigma:");
        System.out.println(strCrypt.deEncrypt(key));
        str=strCrypt.toString();
        System.out.println("enigma -> СТРОКА:");
        System.out.println(str);
    }
}
