//TODO Задумка в том что бы шифруемая строка балы объектом,
// и можно было понять зашифрована данная строка или нет, и каким алгоритмом, а когда была зашифрована
package deshifrator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class EncryptedString {

    private String str;
    private int typeCryptMethod;
    private boolean encrypted;
    private LocalDateTime encryptedDate;

    private EncryptedString(String str, int typeCryptMethod) {
        this.str = str;
        this.typeCryptMethod = typeCryptMethod;
        this.encrypted = false;
    }

    static EncryptedString getEncryptString(String str, int typeCryptMethod) {
        return new EncryptedString(str, typeCryptMethod);
    }

    public static EncryptedString getEncryptString(String str) {
        return new EncryptedString(str, 0);
    }

    @Override
    public String toString() {
        return str;
    }

    public void getStrInfo() {
        System.out.println(typeCryptMethod);
        System.out.println(encrypted);
        if (encryptedDate != null)
            System.out.println(DateTimeFormatter.ofPattern("dd.MM.yyyy HH-mm-ss").format(encryptedDate));
    }

    void setStr(String str) {
        this.str = str;
    }

    void setEncrypted(boolean encrypted) {
        this.encrypted = encrypted;
    }

    void setEncryptedDate() {
        encryptedDate = LocalDateTime.now();
    }

    boolean isEncrypted() {
        return encrypted;
    }


}
