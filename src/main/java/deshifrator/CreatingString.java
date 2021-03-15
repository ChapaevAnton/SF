package deshifrator;

public interface CreatingString {

    EncryptString toCreate(String str);

    //метод создание новой строки atbash
    CreatingString atbashString = AtbashString::new;

    //метод создание новой строки andrew
    CreatingString andrewString = AndrewString::new;

    //метод создания новой строки Enigma
    CreatingString enigmaString = EnigmaString::new;

    //метод создание новой строки XoR
    CreatingString XoRString = XoRString::new;


}




