package deshifrator;

public interface Encrypt {

    EncryptedString encrypt(EncryptedString text, String encryptKey);

    EncryptedString deEncrypt(EncryptedString text, String encryptKey);

}
