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

    //TODO обработать null, и неправильный ввод ключа
    public static EncryptedString encrypt(String text, String encryptKey, int typeCryptMethod) {

        EncryptedString encryptedString = EncryptedString.getEncryptString(text, typeCryptMethod);

        if (!encryptedString.isEncrypted()) {
            encryptedString.setStr(selectTypeCrypt(encryptedString.toString(), encryptKey, typeCryptMethod));
            encryptedString.setEncrypted(true);
            encryptedString.setEncryptedDate();
        } else {
            encryptedString.getStrInfo();
        }

        return encryptedString;
    }

    //TODO Доработать, выдавать ошибку если метод дешифровки не совпадает, если текст не шифрован
    public static String deEncrypt(String text, String encryptKey, int typeCryptMethod) {
        return selectTypeCrypt(text, encryptKey, typeCryptMethod);
    }


    private static String selectTypeCrypt(String text, String encryptKey, int typeCryptMethod) {
        String newText = switch (typeCryptMethod) {
            case XOR_ENCRYPT -> xorEncrypting(text, encryptKey);
            case ATBASH_ENCRYPT -> atbashEncrypting(text, encryptKey);
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
    //FIXME encryptKey - пока не учитывается в atbashEncrypting, только передается в xorEncrypting
    //Алфавит шифрования
    private final static String ENCRYPT_ALPHABET =
            "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯABCDEFGHIKLMNOPQRSTVXYZ /*-+абвгдеёжзийклмнопрстуфхцчшщъыьэюяabcdefghiklmnopqrsttvxyz0123456789";
    //Сложность алфавита шифрования
    private final static int COMPLEXITY = ENCRYPT_ALPHABET.length() - 1;

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
                encodedArray[i] = xorEncrypting(Character.toString(encodedArray[i]), encryptKey).charAt(0);
            }
        }
        text = String.valueOf(encodedArray);

        return text;

    }

}


