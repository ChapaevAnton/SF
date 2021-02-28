package deshifrator;

public interface MessageEncryptable {
    String encryptMessage(String message, String secretKey);
    String decryptMessage(String message, String secretKey);
}
