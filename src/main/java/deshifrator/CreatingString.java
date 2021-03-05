package deshifrator;

public interface CreatingString {

    EncryptString toCreate(String str);

    //метод создание новой строки atbash
    CreatingString atbashString = str -> new AtbashString(str);

    //метод создание новой строки XoR
    CreatingString XoRString = str -> new XoRString(str);

    //метод создания новой строки Enigma
    CreatingString enigmaString = str -> new EnigmaString(str);

    public static CreatingString atbashString() {
        return new CreatingString() {
            @Override
            public EncryptString toCreate(String str) {
                return new EnigmaString(str);
            }
        };
    }

}




