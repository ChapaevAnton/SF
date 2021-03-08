package deshifrator;

public class XoRStringII extends EncryptString {

    //типы шифрования
    private final static String XOR_ENCRYPTII = "XOR_ENCRYPTII";

    XoRStringII(String str) {
        super(str, XOR_ENCRYPTII, false);
    }

    @Override
    String encryptionAlgorithm(String text, String encryptKey) {
        char[] texts = text.toCharArray();//new char[text.length()];
        char[] key = encryptKey.toCharArray();
//        char[] resultChar = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {

//            texts[i] = (char) (text.charAt(i)^encryptKey.charAt(i));

            if (i >= key.length) {
                texts[i] = (char) (texts[i] ^ key[i % key.length]);
            } else {
                texts[i] = (char) (texts[i] ^ key[i]);
            }



        }
        return String.valueOf(texts);
    }


        @Override
        String decryptionAlgorithm (String text, String encryptKey){
            return encryptionAlgorithm(text, encryptKey);
        }
    }
