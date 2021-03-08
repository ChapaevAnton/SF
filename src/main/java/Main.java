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
        System.out.println("ЗАШФРОВАНННОЕ СООБЩЕНЕ atbash:");
        System.out.println(strCrypt.encrypt(key));
        System.out.println("СХОДНОЕ СООБЩЕНЕ atbash:");
        System.out.println(strCrypt.deEncrypt(key));
        String str = strCrypt.toString();
        System.out.println("atbash -> СТРОКА:");
        System.out.println(str);

        strCrypt = CreatingString.XoRString.toCreate(andrew);
        strCrypt.getStrInfo();
        System.out.println("ЗАШФРОВАННОЕ СООБЩЕНЕ XoR:");
        System.out.println(strCrypt.encrypt(key));
        System.out.println("СХОДНОЕ СООБЩЕНЕ XoR:");
        System.out.println(strCrypt.deEncrypt(key));
        str = strCrypt.toString();
        System.out.println("XoR -> СТРОКА:");
        System.out.println(str);

        strCrypt = CreatingString.XoRStringII.toCreate(andrew);
        strCrypt.getStrInfo();
        System.out.println("ЗАШФРОВАННОЕ СООБЩЕНЕ XoRII:");
        System.out.println(strCrypt.encrypt(key));
        System.out.println("СХОДНОЕ СООБЩЕНЕ XoRII:");
        System.out.println(strCrypt.deEncrypt(key));
        str = strCrypt.toString();
        System.out.println("XoRII -> СТРОКА:");
        System.out.println(str);

        strCrypt = CreatingString.enigmaString.toCreate(andrew);
        strCrypt.getStrInfo();
        System.out.println("ЗАШФРОВАННОЕ СООБЩЕНЕ enigma:");
        System.out.println(strCrypt.encrypt(key));
        System.out.println("СХОДНОЕ СООБЩЕНЕ enigma:");
        System.out.println(strCrypt.deEncrypt(key));
        str=strCrypt.toString();
        System.out.println("enigma -> СТРОКА:");
        System.out.println(str);
    }
}
