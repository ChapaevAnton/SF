package deshifrator;

public final class AtbashString extends EncryptedString {

    private AtbashString(String str) {
        super(str, ATBASH_ENCRYPT, false);
    }

    public static EncryptedString getEncryptString(String str) {
        return new AtbashString(str);
    }

    //FIXME encryptKey - пока не учитывается в atbashEncrypting, только передается в xorEncrypting
    //FIXME не шифрует символы которые отсуствуют в алфавите, просто заменяет их *
    //Алфавит шифрования
    private final static String ENCRYPT_ALPHABET =
            "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯABCDEFGHIKLMNOPQRSTVXYZ /*-+абвгдеёжзийклмнопрстуфхцчшщъыьэюяabcdefghiklmnopqrsttvxyz0123456789";
    //Сложность алфавита шифрования
    private final static int COMPLEXITY = ENCRYPT_ALPHABET.length() - 1;

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
                encodedArray[i] = '*';
            }
        }
        text = String.valueOf(encodedArray);

        return text;
    }

    @Override
    String decryptionAlgorithm(String text, String encryptKey) {
        return encryptionAlgorithm(text, encryptKey);
    }

    @Override
    public EncryptedString encrypt(String encryptKey) {

        if (!isEncrypted()) {
            setStr(encryptionAlgorithm(toString(), encryptKey));
            setEncrypted(true);
            setEncryptedDate();
            getStrInfo();
        } else System.out.println("Attention. This string is already encrypted.");
        return this;
    }

    @Override
    public EncryptedString deEncrypt(String encryptKey) {

        if (isEncrypted()) {
            setStr(decryptionAlgorithm(toString(), encryptKey));
            setEncrypted(false);
            setEncryptedDate();
            getStrInfo();
        } else System.out.println("Attention. This string has already been decrypted.");
        return this;
    }
}
