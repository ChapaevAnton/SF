package deshifrator;

public final class Encryption {

    public final static int XOR_ENCRYPT = 1;
    public final static int ATBASH_ENCRYPT = 2;

    public static String encrypt(String text, String encryptKey) {
        return xorEncrypting(text, encryptKey);
    }

    public static String deEncrypt(String text, String encryptKey) {
        return xorEncrypting(text, encryptKey);
    }


    public static String encrypt(String text, String encryptKey, int typeCryptMethod) {

        return text;
    }

    private static String xorEncrypting(String text, String encryptKey) {
        char[] texts = text.toCharArray();
        byte[] keys = encryptKey.getBytes();
        int key = 0;

        for (byte item : keys) {
            key += Byte.toUnsignedInt(item);
        }
        System.out.println(key);
        for (char item : texts) {
            text = text.replace(item, (char) (item ^ key));
        }

        return text;
    }

}
