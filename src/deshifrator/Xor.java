package deshifrator;

public class Xor implements MessageEncryptable{


    public Xor() {
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

    @Override

    public String encryptMessage(String message, String secretKey) {
//        this.setKey(secretKey);
        return xorEncrypting(message, secretKey);//crypt(message);
    }

    @Override
    public String decryptMessage(String message, String secretKey) {
//        this.setKey(secretKey);
        return null;//crypt(message);
    }
}
