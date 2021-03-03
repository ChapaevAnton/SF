package deshifrator;


public final class Encryption {

    public final static int XOR_ENCRYPT = 1;
    public final static int ATBASH_ENCRYPT = 2;
    public final static int ENIGMA_ENCRYPT = 3;


    //обработать null, и неправильный ввод ключа лялялля
    public static String encrypt(String text, String encryptKey, int typeCryptMethod) {

        return switch (typeCryptMethod) {
            case XOR_ENCRYPT -> xorEncrypting(text, encryptKey);
            case ATBASH_ENCRYPT -> atbashEncrypting(text, encryptKey);
            case ENIGMA_ENCRYPT -> enigmaEncrypting(text, encryptKey);
            default -> text;
        };

    }


    public static String deEncrypt(String text, String encryptKey, int typeCryptMethod) {
        return switch (typeCryptMethod) {
            case XOR_ENCRYPT -> xorEncrypting(text, encryptKey);
            case ATBASH_ENCRYPT -> atbashEncrypting(text, encryptKey);
            case ENIGMA_ENCRYPT -> enigmaEncrypting(text, encryptKey);
            default -> text;
        };

    }


    private static String xorEncrypting(String text, String encryptKey) {
       Xor xor = new Xor();
        return xor.encryptMessage(text, encryptKey);
    }


    //TODO Разработать
    //FIXME encryptKey - пока не учитывается в atbashEncrypting, только передается в xorEncrypting
    //Алфавит шифрования


    private static String atbashEncrypting(String text, String encryptKey) {
        Atbash atbash = new Atbash();
        return atbash.encryptMessage(text, encryptKey);

    }

    private static String enigmaEncrypting(String text, String encryptKey) {

        Enigma enigma = new Enigma();
        return enigma.encryptMessage(text, encryptKey);
    }

}


