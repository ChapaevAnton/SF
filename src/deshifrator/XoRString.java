package deshifrator;

/**
 * Класс шифрования алгоритм XOR
 *
 * @author https://github.com/Quertte
 */

final class XoRString extends EncryptString {

    //типы шифрования
    final static String XOR_ENCRYPT = "XOR_ENCRYPT";

    XoRString(String str) {
        super(str, XOR_ENCRYPT, false);
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


