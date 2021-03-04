package deshifrator;

public class Atbash implements MessageEncryptable {
    private final static String ENCRYPT_ALPHABET =

            "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯABCDEFGHIKLMNOPQRSTVXYZ /*-+абвгдеёжзийклмнопрстуфхцчшщъыьэюяabcdefghiklmnopqrsttvxyz0123456789";
    //Сложность алфавита шифрования
    private final static int COMPLEXITY = ENCRYPT_ALPHABET.length() - 1;

    @Override
    public String encryptMessage(String message, String secretKey) {
        return atbashEncrypting(message, secretKey);
    }

    @Override
    public String decryptMessage(String message, String secretKey) {
        return null;
    }

    private static String atbashEncrypting(String text, String encryptKey) {

        char[] encodedArray = text.toCharArray();


        for (int i = 0; i < encodedArray.length; i++) {
            int index = ENCRYPT_ALPHABET.indexOf(encodedArray[i]);
            //отсутсвует шифрующий символ в алфавите
            if (index != -1) {
                index = COMPLEXITY - index;
                encodedArray[i] = ENCRYPT_ALPHABET.charAt(index);
            } else {
                //кодируем XOR если нет в алфавите
                Xor xorCopy = new Xor();
                encodedArray[i] = xorCopy.encryptMessage(Character.toString(encodedArray[i]), encryptKey).charAt(0);
            }
        }
        text = String.valueOf(encodedArray);

        return text;

    }
}
