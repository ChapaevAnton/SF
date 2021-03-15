package deshifrator;

/**
 * Класс шифрования алгоритм XOR from AndreDew
 *
 * @author https://github.com/Quertte
 */

final class AndrewString extends EncryptString {

    //типы шифрования
    private final static String ANDREW_ENCRYPT = "ANDREW_ENCRYPT";

    AndrewString(String str) {
        super(str, ANDREW_ENCRYPT, false);
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


