package deshifrator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class EncryptedString implements Encrypt{

    final static int NOT_ENCRYPT = 0;
    final static int XOR_ENCRYPT = 1;
    final static int ATBASH_ENCRYPT = 2;

    private String str;
    private int typeCryptMethod;
    private boolean encrypted;
    private LocalDateTime encryptedDate;

    EncryptedString(String str, int typeCryptMethod, boolean encrypted) {
        this.str = str;
        this.typeCryptMethod = typeCryptMethod;
        this.encrypted = encrypted;
        this.encryptedDate = LocalDateTime.now();
    }

    abstract String encryptionAlgorithm(String text, String encryptKey);

    abstract String decryptionAlgorithm(String text, String encryptKey);

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
