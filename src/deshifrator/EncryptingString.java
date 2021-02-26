package deshifrator;

public interface EncryptingString {
    //шифровка текста с ключом
    EncryptString encrypt(String encryptKey);

    //дешифровка текста с ключом
    EncryptString deEncrypt(String encryptKey);

    //EncryptString getEncryptString(String str);

    //информация
    void getStrInfo();

    String toString();

}
