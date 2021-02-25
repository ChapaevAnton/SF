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

    //TODO Возможно это не совсем универсальное решение чтобы его наследовать в другие классы
    // может быть актуально только для atbash и XOR
    //старт шифрования
    EncryptedString encryptStart(String encryptKey) {

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

    //TODO Возможно это не совсем универсальное решение чтобы его наследовать в другие классы
    // может быть актуально только для atbash и XOR
    //старт дешифровки
    EncryptedString deEncryptStart(String encryptKey) {

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
