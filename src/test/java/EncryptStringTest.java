import deshifrator.CreatingString;
import deshifrator.EncryptingString;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EncryptStringTest {

    @Test
    void toStringTest() {
        String strIn = "test";
        EncryptingString atbashString = CreatingString.atbashString.toCreate(strIn);
        EncryptingString XoRString = CreatingString.XoRString.toCreate(strIn);
        EncryptingString enigmaString = CreatingString.enigmaString.toCreate(strIn);

        assertEquals(strIn, atbashString.toString(), "Error test toStringTest() - atbashString");
        assertEquals(strIn, XoRString.toString(), "Error test toStringTest() - XoRStringString");
        assertEquals(strIn, enigmaString.toString(), "Error test toStringTest() - enigmaString");
    }

}
