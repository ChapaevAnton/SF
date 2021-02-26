package deshifrator;

public final class CreatorString {

    //метод создание новой строки atbash
    public static CreatingString atbashString = str -> new AtbashString(str);

    //метод создание новой строки XoR
    public static CreatingString XoRString = str -> new XoRString(str);

}
