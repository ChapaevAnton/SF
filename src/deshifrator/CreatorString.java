package deshifrator;

public final class CreatorString {

    public interface CreatingString {

        EncryptString toCreate(String str);

    }

    //метод создание новой строки atbash
    public static CreatingString atbashString = str -> new AtbashString(str);

    //метод создание новой строки XoR
    public static CreatingString XoRString = str -> new XoRString(str);

}
