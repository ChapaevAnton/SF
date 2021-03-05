import deshifrator.CreatingString;
import deshifrator.EncryptingString;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EncryptStringTest {

    static String strIn;
    static String strOut;
    EncryptingString atbashString;
    EncryptingString XoRString;
    EncryptingString enigmaString;

    @Test
    @BeforeAll
    static void variableInitialization() {
        strIn = " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~«»АБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдежзийклмнопрстуфхцчшщъыьэюя–";
    }

    @Test
    @DisplayName("Проверка создания шифрованной строки")
    @BeforeEach
    void verifyingTheCreationOfEncryptedStrings() {

        atbashString = CreatingString.atbashString.toCreate(strIn);
        XoRString = CreatingString.XoRString.toCreate(strIn);
        enigmaString = CreatingString.enigmaString.toCreate(strIn);
        assertNotNull(atbashString,"Error test notNull - atbashString");
        assertNotNull(XoRString,"Error test notNull - XoRStringString");
        assertNotNull(enigmaString,"Error test notNull - enigmaString");
    }


    @Test
    @DisplayName("Тест перевода шифрованной строки EncryptingString в String")
    @Order(1)
    void translateEncryptedStringToString() {

        assertEquals(strIn, atbashString.toString(), "Error test toString() - atbashString");
        assertEquals(strIn, XoRString.toString(), "Error test toString() - XoRStringString");
        assertEquals(strIn, enigmaString.toString(), "Error test toString() - enigmaString");
    }

    @Test
    @DisplayName("Тест шифрования/дешифрования алгоритм XoR")
    @Order(2)
    void encryptionAlgorithmCheckXorString() {
        XoRString.encrypt(strIn);
        XoRString.deEncrypt(strIn);
        strOut = XoRString.toString();
        assertEquals(strIn, strOut, "Error test encrypt() deEncrypt() - XoRString");
    }

}
