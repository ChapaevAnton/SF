package deshifrator;

public class Enigma implements MessageEncryptable {
    private static final String alpha = " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~«»АБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдежзийклмнопрстуфхцчшщъыьэюя";//Шифруемый алфавит
    private static final String rotors[] = //3 ротора Энигмы №№
            {//      Роторы - зарэндомленный алфавит (строка alpha)
                    "Ф,р~U?а[(Аю0ЧтY«дмRОNб9Й*2QPфж5<я!jCщ&}4xT{vf`HДAчн\"пZеИ6С=a7tГЭ: ЮЩmq#rцх)DpЕв_ВKуc8Ыk-Ъ$SGшгFКgзnсТко]z/ыЯ>'лWП\\e^MУЬ.EйJЦiъd3ь1ЖЗVsl;ByЛOXБwIР+%МШbХ»|эи@oНLhu",//ротор I (LEFT)
                    "С3ыт7йс5шs|~bиаiвАхE)оk8нrR6Ч&УL {*ю4^YяQЭ$?aфzhx@Дuд\"ITэlРVъ],п_pЗ'цГ#}КF:жnjJВЬg`ЛomОU+бг(ЪФNщt%yкМXBGЕDЯН-Шу;S>Пe0Т=wWрЫБЙvЖfЮзKdлO»</\\ЦPCHЩХ9«м!.cZИчMA[е12ьq",//ротор II (MIDDLE)
                    "auНGnOТ\\щС/в_Г0гY3биз5[4ш\"ЩmК1ЭьжЕХ}Шч^«уЬ'$J-gлэ6tyнxАИц,ЮQОLHЯЙvУ# (йъX»d)P=РVDре|9;iKтlЫхNБ7wj.Л>FпЗаEы2Rp~?UBATc<bсrм!кдД+Ъ8%:ЦюоIЧяПeM@Фoh`Cф]{qSfЖВ*skМzWZ&"//ротор III (RIGHT)
            };
    private static final String reflector = "яюэьыъщшчцхфутсрпонмлкйизжедгвбаЯЮЭЬЫЪЩШЧЦХФУТСРПОНМЛКЙИЗЖЕДГВБА»«~}|{zyxwvutsrqponmlkjihgfedcba`_^]\\[ZYXWVUTSRQPONMLKJIHGFEDCBA@?>=<;:9876543210/.-,+*)('&%$#\"! ";//reflector -зазеркаленный алфавит (строка alpha)
    private String key;

    public Enigma() {//Конструктор по умолчанию - задается изначальная настройка роторов:
                                                                     /* ротор I   :'A'
                                                                        ротор II  :'B'
                                                                        ротор III :'C'*/
        this("ABC");//ABC
    }

    public Enigma(String key) {
        this.key = key;
    }


    public void setKey(String key) {
        this.key = key;
    }


    @Override

    public String encryptMessage(String message, String secretKey) {
//        deshifrator.Enigma newEncryption = new deshifrator.Enigma(secretKey);
        this.setKey(secretKey);
        return crypt(message);
    }

    @Override
    public String decryptMessage(String message, String secretKey) {//Это Энигме не нужно
        this.setKey(secretKey);
        return crypt(message);
    }

    static int mod159(long a) {

        return (int) ((a % 161 + 161) % 161);
    }

    static int li(char l) {//метод допилен с учетом разрывов в алфавите Enigma M3 (expanded)
        //убираем эти разрывы
        if (l < 150) return l - 32;
        else if (l == 171) return l - 76;
        else if (l == 187) return l - 91;
        else return l - 943;
    }


    String crypt(String inString) {
        int L = li(key.charAt(0));
        int M = li(key.charAt(1));
        int R = li(key.charAt(2));

        StringBuilder outStringStringBuilder = new StringBuilder();//создаем стрингбилдер, чтобы в цикле for

        for (int i = 0; i < inString.length(); i++) {              // на каждой итерации добавлять символ в конец
            int ct_letter = li(inString.charAt(i));

//Вращение ротов осталось как у оригинальной Энигмы (когда правый доходит до 'W' и средний - до 'F')
            R = mod159(++R);//крутим правый ротор
            if (R == 55) M = mod159(++M);//крутим средний ротор, если правый дошел до 'W' (было: (R == 22))
            if (R == 55 && M == 38)
                L = mod159(++L);//крутим левый ротор, если средний дошел до 'F' (было: (R == 22 && M == 5))


            char a = rotors[2].charAt(mod159(R + ct_letter));
            char b = rotors[1].charAt(mod159(M + li(a) - R));
            char c = rotors[0].charAt(mod159(L + li(b) - M));

            char ref = reflector.charAt(mod159(li(c) - L));

            int d = mod159(rotors[0].indexOf(alpha.charAt(mod159(li(ref) + L))) - L);
            int e = mod159(rotors[1].indexOf(alpha.charAt(mod159(d + M))) - M);
            char f = alpha.charAt(mod159(rotors[2].indexOf(alpha.charAt(mod159(e + R))) - R));

            outStringStringBuilder.append(f);

        }
        return outStringStringBuilder.toString();
    }


}
