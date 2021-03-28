package deshifrator;

import java.util.Arrays;

public class FairPlay extends EncryptString {

    // FIXME: 28.03.2021 для флага наличия икас в конце строки
    //if (uneven) textCode = new String(textCode.substring(0, textCode.length() - 1));

    //типы шифрования
    private final static String FAIR_ENCRYPT = "FAIR_ENCRYPT";

    FairPlay(String str) {
        super(str, FAIR_ENCRYPT, false);
    }

    @Override
    String encryptionAlgorithm(String text, String encryptKey) {

        StringBuilder cryptText = new StringBuilder();
        char[][] alphabet = getCryptAlphabet(encryptKey);
        char[][] bigramm = getBigramm(text);
        //массив для хранения координат пар биграмм
        int[][] point = new int[2][2];
        //счетчик ряда count_strings
        //0 - ряд для координат первой буквы в биграмме
        //1 - ряд для координат второй буквы в биграмме
        int count_strings = 0;


        //перебираем массив биграммы
        for (int i = 0; i < bigramm.length; i++) { //строки

            do { //строки координат
                for (int j = 0; j < bigramm[i].length; j++) { //столбцы

                    //перебираем массив алфавита
                    for (int k = 0; k < alphabet.length; k++) {
                        for (int l = 0; l < alphabet[k].length; l++) {

                            if (alphabet[k][l] == bigramm[i][j]) {

                                point[count_strings][0] = k;
                                point[count_strings][1] = l;
                                count_strings++;
                            }
                        }
                    } //перебираем массив алфавита

                }//столбец
            } while (count_strings != 2);

            count_strings = 0;

            // условия сдвигов
            if (point[0][0] == point[1][0]) {
                //если строки равны
                ++point[0][1];
                ++point[1][1];
                if (point[0][1] == 5) {
                    point[0][1] = 0;
                }
                if (point[1][1] == 5) {
                    point[1][1] = 0;
                }

                //если столбцы равны
            } else if (point[0][1] == point[1][1]) {
                ++point[0][0];
                ++point[1][0];
                if (point[0][0] == 5) {
                    point[0][0] = 0;
                }
                if (point[1][0] == 5) {
                    point[1][0] = 0;
                }

            } else {

                // когда i и j не равны
                int temp = point[0][1];
                point[0][1] = point[1][1];
                point[1][1] = temp;
            }

            //собираем шифрованную строку
            cryptText.append(alphabet[point[0][0]][point[0][1]]).
                    append(alphabet[point[1][0]][point[1][1]]);

        }//строки
        //перебираем массив биграммы

        return cryptText.toString();
    }

    @Override
    String decryptionAlgorithm(String text, String encryptKey) {
        return encryptionAlgorithm(text, encryptKey);
    }

    private char[][] getCryptAlphabet(String key) {

        // FIXME: 28.03.2021 из ключа не убираются одинаковые символы, есть решение либо regex либо hashset
        //  - но пока рабочего варианта не нашли (\w)\1
        // OPTIMIZE: 28.03.2021 доработать алфавит дополнительными символами кириллица, буква J, спецсимволы и т.п.
        String alphabets = "ABCDEFGHIKLMNOPQRSTUVWXYZ"; //j

        key = key.replaceAll(" ", "").toUpperCase();

        // FIXME: 28.03.2021 тут нужно убрать одинаковые символы из key

        alphabets = key + (alphabets.replaceAll("[" + key + "]", ""));

        // TODO: 07.03.2021 преобразовываем алфавит в двумерный массив 5 на 5
        char[] tempAlphabet = alphabets.toCharArray();
        char[][] newAlphabet = new char[5][5];
        for (int i = 0; i < newAlphabet.length; i++) {
            for (int j = 0; j < newAlphabet[i].length; j++) {
                newAlphabet[i][j] = tempAlphabet[i * newAlphabet[j].length + j];
            }
        }
        return newAlphabet;
    }

    private char[][] getBigramm(String str) {
        // TODO: 07.03.2021 создаем биграммы из текста который будем шифровать
        str = str.replaceAll(" ", "").toUpperCase();

        //если строка нечетная добавляем в конце X и делаем четной
        if (str.length() % 2 != 0) str = str + "X";

        //если в биграмме одинаковые символы
        int begin_count = 0;
        int end_count = 2;

        String substring;

        String newStr = "";
        do {
            substring = str.substring(begin_count, end_count);
            if (substring.length() == 2) {
                if (substring.charAt(0) == substring.charAt(1)) {
                    substring = substring.charAt(0) + "X";
                }
            }
            begin_count += 2;
            end_count += 2;

            newStr += substring;
        } while (end_count <= str.length());

        str = newStr;

        //формируем двумерный массив биграмм
        char[] arrayText = str.toCharArray();
        char[][] bigramm = new char[str.length() / 2][2];


        if (arrayText.length > 2) {

            for (int i = 0; i < bigramm.length; i++) {
                for (int j = 0; j < bigramm[i].length; j++) {
                    bigramm[i][j] = arrayText[i * bigramm[j].length + j];
                }
            }
        } else {
            for (int i = 0; i < bigramm[0].length; i++) {
                bigramm[0][i] = arrayText[i];
            }
        }
        //вывод для теста - уберем потом
        System.out.println(Arrays.deepToString((bigramm)));
        return bigramm;
    }

}
