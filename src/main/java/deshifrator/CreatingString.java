package deshifrator;

public interface CreatingString {

    EncryptString toCreate(String str);

    //метод создание новой строки atbash
    CreatingString atbashString = str -> new AtbashString(str);

    //метод создание новой строки andrew
    CreatingString andrewString = str -> new AndrewEncryptionString(str);

    //метод создания новой строки Enigma
    CreatingString enigmaString = str -> new EnigmaString(str);

    //метод создание новой строки XoR
    CreatingString XoRString = str -> new XoRString(str);


}




