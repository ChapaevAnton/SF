package deshifrator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class EncryptedString implements EncryptKey {
    //типы шифрования
    final static int NOT_ENCRYPT = 0;
    final static int XOR_ENCRYPT = 1;
    final static int ATBASH_ENCRYPT = 2;

    private String str; //текст
    private int typeCryptMethod; //методо шифрования
    private boolean encrypted; //статус шифрования
    private LocalDateTime encryptedDate; //время последнего изменения

    //конструктор
    EncryptedString(String str, int typeCryptMethod, boolean encrypted) {
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
