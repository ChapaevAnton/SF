package deshifrator;

public class Enigma implements MessageEncryptable {
    private static final String alpha = " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~АБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдежзийклмнопрстуфхцчшщъыьэюя";//Шифруемый алфавит
    private static final String rotors[] = //3 ротора Энигмы №№
            {//      Роторы - зарэндомленный алфавит (строка alpha)
                    "ЬIЫce}вyoяытdM3r@jрчбa/с$ИН%Фщ6Т('bшvЙу\\hоCXLРuеJR)УДаKКл8UWд!&+n0{ й<ГЭ]mАwюSzq=fЦЩNtk2кХBЧVСx,ЕQYOpи`пгEМFsDЗ-м;1зжПО|Ю5~.В*н9Я#[ЛH^БTШ7\"iZьlЪ?хAЖъэg4>_:PцGф",//ротор I (LEFT)
                    "=Ul|зхе3ЦKh&~L[Мч@У$ФтZаВ()9Б5B#>КRЪNG8Тe2СмiЧOw y-Оц%EЮс/4ИdЭю+D}иs*T]пр6vЩЙgЬ:J^\\nПaшoэъQРjДkr`<pSt\"MbЖ0ХАWжFЫЯущбЗ!он?_V,z'йьqфвГfдc;кHы1uгYxPНЕЛXAIял{7CmШ.",//ротор II (MIDDLE)
                    "Eб+3JеW*yRФq\\DjxBIQuЧm_2ч,ХСж}tg/Ыза`ЕКVlИvebLaЯ{д~М4p9РщмdY6ьZi-П7ШЭMX|\"г#ДвюkFЙЮйP!(GЛ)>[0Н1пфUушъЖ&оNиТC%rыЬя?АЪhн]^;БхzcУОK@T$сЗfГлoт=к'ЩHw8nцA. рSэ<В:Os5Ц"//ротор III (RIGHT)
            };
    private static final String reflector = "яюэьыъщшчцхфутсрпонмлкйизжедгвбаЯЮЭЬЫЪЩШЧЦХФУТСРПОНМЛКЙИЗЖЕДГВБА~}|{zyxwvutsrqponmlkjihgfedcba`_^]\\[ZYXWVUTSRQPONMLKJIHGFEDCBA@?>=<;:9876543210/.-,+*)('&%$#\"! ";//reflector -зазеркаленный алфавит (строка alpha)
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

        return (int) ((a % 159 + 159) % 159);
    }

    static int li(char l) {//метод допилен с учетом разрывов в алфавите Enigma M3 (expanded)
                           //убираем эти разрывы
        if (l < 1000) return l - 32;
        else return l - 945;
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
            if (R == 55 && M == 38) L = mod159(++L);//крутим левый ротор, если средний дошел до 'F' (было: (R == 22 && M == 5))


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
