package deshifrator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class EncryptedString implements EncryptKey {
    //типы шифрования
    final static String NOT_ENCRYPT = "NOT_ENCRYPT";
    final static String XOR_ENCRYPT = "XOR_ENCRYPT";
    final static String ATBASH_ENCRYPT = "ATBASH_ENCRYPT";

    private String str; //текст
    private String typeCryptMethod; //методо шифрования
    private boolean encrypted; //статус шифрования
    private LocalDateTime encryptedDate; //время последнего изменения

    //конструктор
    EncryptedString(String str, String typeCryptMethod, boolean encrypted) {
        this.str = str;
        this.typeCryptMethod = typeCryptMethod;
        this.encrypted = encrypted;
        this.encryptedDate = LocalDateTime.now();
    }

    //алгоритм шифровки
    abstract String encryptionAlgorithm(String text, String encryptKey);
    //алгоритм дешифровки
    abstract String decryptionAlgorithm(String text, String encryptKey);

    //TODO Служебные методы
    //в строку
    @Override
    public String toString() {
        return str;
    }

    //информация о строке
    public void getStrInfo() {
        System.out.println(typeCryptMethod);
        System.out.println(encrypted);
        if (encryptedDate != null)
            System.out.println(DateTimeFormatter.ofPattern("dd.MM.yyyy HH-mm-ss").format(encryptedDate));
    }

    //установить значение строки
    void setStr(String str) {
        this.str = str;
    }

    //установить значение статуса шифрования
    void setEncrypted(boolean encrypted) {
        this.encrypted = encrypted;
    }

    //установить значение время последнего изменения
    void setEncryptedDate() {
        encryptedDate = LocalDateTime.now();
    }

    //запрос статус шифрования
    boolean isEncrypted() {
        return encrypted;
    }


}
