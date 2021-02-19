package deshifrator;

public final class Encryption {

    public final static int XOR_ENCRYPT = 1;
    public final static int ATBASH_ENCRYPT = 2;

    public static String encrypt(String text, int key) {
        return xorEncrypting(text, key);
    }

    public static String deEncrypt(String text, int key) {
        return xorEncrypting(text, key);
    }


    public static String encrypt(String text, int key, int typeCryptMethod) {

        return text;
    }

    private static String xorEncrypting(String text, int key) {
        char[] texts = text.toCharArray();
        for (int i = 0; i < text.length(); i++) {
            int encrypt = texts[i];
            text = text.replace(texts[i], (char) (encrypt ^ key));
        }
        return text;
    }

}
