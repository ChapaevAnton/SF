package deshifrator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Абстрактный класс шифрования, строка - содержит параметры шифрования.
 * @author https://github.com/ChapaevAnton
 */

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


    //TODO Имплементируется в базовом класса, но возможно придется переопределять в производных классах...
    //шифрование
    @Override
    public EncryptedString encrypt(String encryptKey) {
        //TODO Возможно это не совсем универсальное решение чтобы его наследовать в другие классы
        // может быть актуально только для atbash и XOR, но как бы кто мешает переопределить
        if (!encrypted) {
            str = encryptionAlgorithm(str, encryptKey);
            encrypted = true;
            encryptedDate = LocalDateTime.now();
        } else {
            System.out.println("Attention. This string is already encrypted.");
            getStrInfo();
        }
        return this;
    }

    //дешифровка
    @Override
    public EncryptedString deEncrypt(String encryptKey) {
        //TODO Возможно это не совсем универсальное решение чтобы его наследовать в другие классы
        // может быть актуально только для atbash и XOR, но как бы кто мешает переопределить
        if (encrypted) {
            str = decryptionAlgorithm(str, encryptKey);
            encrypted = false;
            encryptedDate = LocalDateTime.now();
        } else {
            System.out.println("Attention. This string has already been decrypted.");
            getStrInfo();
        }
        return this;
    }

    //в строку
    @Override
    public String toString() {
        return str;
    }

    //информация о строке
    public void getStrInfo() {
        System.out.println(typeCryptMethod);
        System.out.println(encrypted);
        System.out.println(DateTimeFormatter.ofPattern("dd.MM.yyyy HH-mm-ss").format(encryptedDate));
    }

    //TODO Служебные методы, может пригодятся, хотя можно напрямую обращаться к полям.
    // Пока не используются PRIVATE

    //установить значение строки
    private void setStr(String str) {
        this.str = str;
    }

    //установить значение статуса шифрования
    private void setEncrypted(boolean encrypted) {
        this.encrypted = encrypted;
    }

    //установить значение время последнего изменения
    private void setEncryptedDate() {
        encryptedDate = LocalDateTime.now();
    }

    //запрос статус шифрования
    private boolean isEncrypted() {
        return encrypted;
    }


}
