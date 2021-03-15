package deshifrator;

public class XoRStringII extends EncryptString {

    //типы шифрования
    private final static String XOR_ENCRYPTII = "XOR_ENCRYPTII";

    XoRStringII(String str) {
        super(str, XOR_ENCRYPTII, false);
    }

    @Override
    String encryptionAlgorithm(String text, String encryptKey) {
        //переводим строки шифруемого сообщения и ключа в массивы char
        char[] texts = text.toCharArray();
        char[] key = encryptKey.toCharArray();

        for (int i = 0; i < text.length(); i++) {

            if (i >= key.length) {//если шифруемая строка длиннее ключа
                texts[i] = (char) (texts[i] ^ key[i % key.length]);//... то для побитового xor сложения
                //используем char символы ключа "по кругу" пока не закончится шифруемая строка
            } else {//иначе xor сложение идет каждого char символа исходной строки с каждым char символом ключа
                texts[i] = (char) (texts[i] ^ key[i]);
            }
        }
        return String.valueOf(texts);
    }

    @Override
    String decryptionAlgorithm(String text, String encryptKey) {
        return encryptionAlgorithm(text, encryptKey);
    }
}
