package deshifrator;

public final class Encryption {

    public static String encrypt(String text, String encryptKey) {

        return xorEncrypting(text, encryptKey);
    }

    public static String deEncrypt(String text, String encryptKey) {
        return xorEncrypting(text, encryptKey);
    }

    private static String xorEncrypting(String text, String encryptKey) {
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


}


