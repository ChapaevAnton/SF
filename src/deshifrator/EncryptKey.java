package deshifrator;

public interface EncryptKey {
    //шифровка текста с ключом
    EncryptedString encrypt(String encryptKey);
    //дешифровка текста с ключом
    EncryptedString deEncrypt(String encryptKey);

}
