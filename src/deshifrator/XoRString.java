package deshifrator;
/**
 * Класс шифрования алгоритм XOR
 * @author https://github.com/Quertte
 */
public final class XoRString extends EncryptedString {

    private XoRString(String str) {
        super(str, XOR_ENCRYPT, false);
    }

    //метод создание новой строки
    public static EncryptedString getEncryptString(String str) {
        return new XoRString(str);
    }

    @Override
    public EncryptedString encrypt(String encryptKey) {
        return encryptString(encryptKey);
    }

    @Override
    public EncryptedString deEncrypt(String encryptKey) {
        return deEncryptString(encryptKey);
    }

    @Override
    String encryptionAlgorithm(String text, String encryptKey) {
        char[] texts = text.toCharArray();
        byte[] keys = encryptKey.getBytes();
        int key = 0;

        for (byte item : keys) {
            key += Byte.toUnsignedInt(item);
        }

        for (char item : texts) {
            text = text.replace(item, (char) (item ^ key));
        }

        return text;
    }

    @Override
    String decryptionAlgorithm(String text, String encryptKey) {
        return encryptionAlgorithm(text, encryptKey);
    }
}


