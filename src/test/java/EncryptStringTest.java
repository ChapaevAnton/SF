import deshifrator.CreatingString;
import deshifrator.EncryptingString;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EncryptStringTest {

    static String strIn;
    String strOut;
    EncryptingString atbashString;
    EncryptingString andrewString;
    EncryptingString xorString;
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
        andrewString = CreatingString.andrewString.toCreate(strIn);
        xorString = CreatingString.XoRString.toCreate(strIn);
        enigmaString = CreatingString.enigmaString.toCreate(strIn);
        assertNotNull(atbashString, "Error test notNull - atbashString");
        assertNotNull(andrewString, "Error test notNull - XoRStringString");
        assertNotNull(enigmaString, "Error test notNull - enigmaString");
    }


    @Test
    @DisplayName("Тест перевода шифрованной строки EncryptingString в String")
    @Order(1)
    void translateEncryptedStringToString() {

        assertEquals(strIn, atbashString.toString(), "Error test toString() - atbashString");
        assertEquals(strIn, andrewString.toString(), "Error test toString() - andrewStringString");
        assertEquals(strIn, xorString.toString(), "Error test toString() - XoRStringString");
        assertEquals(strIn, enigmaString.toString(), "Error test toString() - enigmaString");
    }

    @Test
    @DisplayName("Тест шифрования/дешифрования алгоритм andrew")
    @Order(2)
    void encryptionAlgorithmCheckXorString() {
        andrewString.encrypt(strIn);
        andrewString.deEncrypt(strIn);
        strOut = andrewString.toString();
        assertEquals(strIn, strOut, "Error test encrypt() deEncrypt() - XoRString");
    }

}
