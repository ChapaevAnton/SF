package deshifrator;

public interface Encrypt {

    EncryptedString encrypt(String encryptKey);

    EncryptedString deEncrypt(String encryptKey);

}
