package deshifrator;

public class Enigma implements MessageEncryptable {
    private static final String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";//Шифруемый алфавит
    private static final String rotors[] = //3 ротора Энигмы №№
            {
                    "EKMFLGDQVZNTOWYHXUSPAIBRCJ",//ротор I (LEFT)
                    "AJDKSIRUXBLHWTMCQGZNPYFVOE",//ротор II (MIDDLE)
                    "BDFHJLCPRTXVZNYEIWGAKMUSQO"//ротор III (RIGHT)
            };
    private static final String reflector = "YRUHQSLDPXNGOKMIEBFZCWVJAT";//reflector B
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

    static int mod26(long a) {
        return (int) ((a % 26 + 26) % 26);
    }

    static int li(char l) {
        return l - 'A';
    }


    String crypt(String inString) {
        int L = li(key.charAt(0));
        int M = li(key.charAt(1));
        int R = li(key.charAt(2));

        StringBuilder outStringStringBuilder = new StringBuilder();//создаем стрингбилдер, чтобы в цикле for

        for (int i = 0; i < inString.length(); i++) {              // на каждой итерации добавлять символ в конец
            int ct_letter = li(inString.charAt(i));


            R = mod26(++R);//крутим правый ротор
            if (R == 22) M = mod26(++M);//крутим средний ротор, если правый дошел до 'W'
            if (R == 22 && M == 5) L = mod26(++L);//крутим левый ротор, если средний дошел до 'F'




            char a = rotors[2].charAt(mod26(R + ct_letter));
            char b = rotors[1].charAt(mod26(M + li(a) - R));
            char c = rotors[0].charAt(mod26(L + li(b) - M));

            char ref = reflector.charAt(mod26(li(c) - L));

            int d = mod26(rotors[0].indexOf(alpha.charAt(mod26(li(ref) + L))) - L);
            int e = mod26(rotors[1].indexOf(alpha.charAt(mod26(d + M))) - M);
            char f = alpha.charAt(mod26(rotors[2].indexOf(alpha.charAt(mod26(e + R))) - R));

            outStringStringBuilder.append(f);

        }
        return outStringStringBuilder.toString();
    }


}
