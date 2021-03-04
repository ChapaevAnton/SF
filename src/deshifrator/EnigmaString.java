package deshifrator;

final class EnigmaString extends EncryptString {

    final static String ENIGMA_ENCRYPT = "ENIGMA_ENCRYPT";

    EnigmaString(String str) {
        super(str, ENIGMA_ENCRYPT, false);
    }

    //Шифруемый алфавит
    private static final String ALPHA = " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~«»АБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдежзийклмнопрстуфхцчшщъыьэюя–";
    private static final String ROTORS[] = //3 ротора Энигмы №№
            {//      Роторы - зарэндомленный алфавит (строка alpha)
                    ",шУGШPVHKбI$ЧВ|6`a@?RA1тЛРБ>_bz7!й&ЮlZ}Ф9tЭ^{kиЖ=w*BТя8XЦ%НыэзyСщГnПоК3\\Nж5-А–]вO+iEлxMS2 ДОWs/vЕJМ0;хqfQсм.ЙгDд4gm[Uаь»~ю(фрц#чFуИе)ЯЗueпЫ'<:ЪjYTкнХЩr\"LhdCo«Ьpъc",//ротор I (LEFT)
                    "OqСлжv;Yoе-N=ЫUЖЦЬ}В SgBRи#?@д4HУнiтщ<pхЛ:x!Йn7Т5QrйLV/КdцPЯcyElБМь–,абъГ02u{$шfZА\"ф(Пг.Е~Ф+WKОJ«*чmaыsкШI)ЮХпF1ДЭ9Ъ[T8b»Dя6XGу\\оЧMtН3`зjACЗ^ЩрИwс>Р|'ehэвмkz]%&ю_",//ротор II (MIDDLE)
                    "J(мИ2Ц)[I.ГQис]Э/Ь!З5:Вo8NъPY^7j|#+t3s?eLкцНWЛЮ'Ч=чdGМhaБнMд}ДюЩ`бвqKт4py»Хф*УЖз@AiЫ%S-рщыА\"$6шь«TШREO\\fТКп1гFVBэ<_ЪrФzbауля,x>ЙZcхОе СжmkЯРXHПlv;&wй90UnЕ~gDо{u–C"//ротор III (RIGHT)
            };
    private static final String REFLECTOR = "–яюэьыъщшчцхфутсрпонмлкйизжедгвбаЯЮЭЬЫЪЩШЧЦХФУТСРПОНМЛКЙИЗЖЕДГВБА»«~}|{zyxwvutsrqponmlkjihgfedcba`_^]\\[ZYXWVUTSRQPONMLKJIHGFEDCBA@?>=<;:9876543210/.-,+*)('&%$#\"! ";//reflector -зазеркаленный алфавит (строка alpha)


//OPTIMIZE 04.03.2021 Теперь этот блок ненужен
// (конструктор по умолчанию если только, что бы задвать дефолтные настройки роторов - только смысл какой)
// public String encryptMessage и public String decryptMessage заменены интерфейсом EncryptingString - который имплементирован
// в базовом абстрактном классе EncryptString. interface MessageEncryptable - больше ненужен - по ка не удалял его...

//    private String key;//Строка хранит ключ, фактически для шифрования используются 3 знака из алфавита Энигмы.

//    public EnigmaString() {//Конструктор по умолчанию - задается изначальная настройка роторов:
//                                                                     /* ротор I   :'A'
//                                                                        ротор II  :'B'
//                                                                        ротор III :'C'*/
//        this("ABC");//ABC
//    }

//    public EnigmaString(String key) {
//        this.key = key;
//    }
//
//
//    public void setKey(String key) {
//        this.key = key;
//    }


//    @Override
//
//    public String encryptMessage(String message, String secretKey) {
//        this.setKey(secretKey);
//        return crypt(message);
//    }
//
//    @Override
//    public String decryptMessage(String message, String secretKey) {//Это Энигме не нужно
//        this.setKey(secretKey);
//        return crypt(message);
//    }

    private int mod159(long a) {

        return (int) ((a % 162 + 162) % 162);
    }

    // TODO метод допилен с учетом разрывов в алфавите Enigma M3 (expanded)
    private int li(char l) {
        //убираем эти разрывы
        if (l < 150) return l - 32;
        else if (l == 171) return l - 76;
        else if (l == 187) return l - 91;
        else if (l == 8211) return l - 8050;
        else return l - 943;
    }

    @Override
    String encryptionAlgorithm(String text, String encryptKey) {
        int L = li(encryptKey.charAt(0));
        int M = li(encryptKey.charAt(1));
        int R = li(encryptKey.charAt(2));

        StringBuilder outStringStringBuilder = new StringBuilder();//создаем стрингбилдер, чтобы в цикле for

        for (int i = 0; i < text.length(); i++) {// на каждой итерации добавлять символ в конец
            int ct_letter = li(text.charAt(i));

            //Вращение роторов осталось как у оригинальной Энигмы (когда правый доходит до 'W' и средний - до 'F')
            R = mod159(++R);//крутим правый ротор
            if (R == 55) M = mod159(++M);//крутим средний ротор, если правый дошел до 'W' (было: (R == 22))
            if (R == 55 && M == 38)
                L = mod159(++L);//крутим левый ротор, если средний дошел до 'F' (было: (R == 22 && M == 5))


            char a = ROTORS[2].charAt(mod159(R + ct_letter));
            char b = ROTORS[1].charAt(mod159(M + li(a) - R));
            char c = ROTORS[0].charAt(mod159(L + li(b) - M));

            char ref = REFLECTOR.charAt(mod159(li(c) - L));

            int d = mod159(ROTORS[0].indexOf(ALPHA.charAt(mod159(li(ref) + L))) - L);
            int e = mod159(ROTORS[1].indexOf(ALPHA.charAt(mod159(d + M))) - M);
            char f = ALPHA.charAt(mod159(ROTORS[2].indexOf(ALPHA.charAt(mod159(e + R))) - R));

            outStringStringBuilder.append(f);

        }
        return outStringStringBuilder.toString();
    }

    @Override
    String decryptionAlgorithm(String text, String encryptKey) {
        return encryptionAlgorithm(text, encryptKey);
    }

}
