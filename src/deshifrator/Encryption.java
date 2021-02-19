package deshifrator;

public final class Encryption {

    public final static int XOR_ENCRYPT = 1;
    public final static int ATBASH_ENCRYPT = 2;

    private final static int CODING_ALGORITHM_MODE = 1;
    private final static int DECODING_ALGORITHM_MODE = 2;

    public static String encrypt(String text, String encryptKey) {

        return xorEncrypting(text, encryptKey);
    }

    public static String deEncrypt(String text, String encryptKey) {
        return xorEncrypting(text, encryptKey);
    }


    public static String encrypt(String text, String encryptKey, int typeCryptMethod) {

        String newText = switch (typeCryptMethod) {
            case XOR_ENCRYPT -> xorEncrypting(text, encryptKey);
            case ATBASH_ENCRYPT -> atbashEncrypting(text, encryptKey, CODING_ALGORITHM_MODE);
            default -> text;
        };

        return newText;
    }


    public static String deEncrypt(String text, String encryptKey, int typeCryptMethod) {
        String newText = switch (typeCryptMethod) {
            case XOR_ENCRYPT -> xorEncrypting(text, encryptKey);
            case ATBASH_ENCRYPT -> atbashEncrypting(text, encryptKey, DECODING_ALGORITHM_MODE);
            default -> text;
        };

        return newText;
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

    //TODO Разработать
    private static String atbashEncrypting(String text, String encryptKey, int algorithmMode) {

        return text;
    }

}
