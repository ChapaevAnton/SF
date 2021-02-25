package deshifrator;

public interface EncryptKey {
    //шифровка текста с ключом
    EncryptedString encrypt(String encryptKey);
    //дешифрока текста с ключом
    EncryptedString deEncrypt(String encryptKey);

}
