//TODO Задумка в том что бы шифруемая строка балы объектом,
// и можно было понять зашифрована данная строка или нет, и каким алгоритмом
package deshifrator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class EncryptedString {

    private String str;
    private int typeCryptMethod;
    private boolean encrypted;
    private LocalDateTime encryptedDate;

    private EncryptedString(String str) {
        this.str = str;
        typeCryptMethod = 0;
        encrypted = false;
        encryptedDate = LocalDateTime.now();
    }

    public static EncryptedString getEncryptString(String str) {
        return new EncryptedString(str);
    }

    public String toString() {
        return str;
    }

    public void getStrInfo() {
        System.out.println(typeCryptMethod);
        System.out.println(encrypted);
        System.out.println(DateTimeFormatter.ofPattern("dd.MM.yyyy HH-mm-ss").format(encryptedDate));
    }

    public void setStr(String str) {
        this.str = str;
    }

    public void setTypeCryptMethod(int typeCryptMethod) {
        this.typeCryptMethod = typeCryptMethod;
    }

    public void setEncrypted(boolean encrypted) {
        this.encrypted = encrypted;
    }

    public boolean isEncrypted() {
        return encrypted;
    }


}
