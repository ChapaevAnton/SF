package deshifrator;

/**
 * Класс шифрования алгоритм Atbash
 *
 * @author https://github.com/ChapaevAnton
 */

final class AtbashString extends EncryptString {

    //типы шифрования
    private final static String ATBASH_ENCRYPT = "ATBASH_ENCRYPT";

    //конструктор
    AtbashString(String str) {
        super(str, ATBASH_ENCRYPT, false);
    }

    //FIXME encryptKey - пока не учитывается в atbashEncrypting, только передается в xorEncrypting
    //сложность алфавита шифрования
    private final static int COMPLEXITY = ENCRYPT_ALPHABET.length() - 1;

    //алгоритм шифрования
    @Override
    String encryptionAlgorithm(String text, String encryptKey) {

        char[] encodedArray = text.toCharArray();

        for (int i = 0; i < encodedArray.length; i++) {
            int index = ENCRYPT_ALPHABET.indexOf(encodedArray[i]);
            //отсутсвует шифрующий символ в алфавите
            if (index != -1) {
                index = COMPLEXITY - index;
                encodedArray[i] = ENCRYPT_ALPHABET.charAt(index);
            } else {
                //кодируем XOR если нет в алфавите
                encodedArray[i] = new AndrewString(Character.toString(encodedArray[i])).encrypt(encryptKey).toString().charAt(0);
            }
        }
        text = String.valueOf(encodedArray);

        return text;
    }

    //алгоритм дешифровки
    @Override
    String decryptionAlgorithm(String text, String encryptKey) {
        return encryptionAlgorithm(text, encryptKey);
    }

}
