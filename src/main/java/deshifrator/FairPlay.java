package deshifrator;

import java.util.Arrays;

public class FairPlay extends EncryptString {


    //типы шифрования
    private final static String FAIR_ENCRYPT = "FAIR_ENCRYPT";

    FairPlay(String str) {
        super(str, FAIR_ENCRYPT, false);
    }


    @Override
    String encryptionAlgorithm(String text, String encryptKey) {

        String cryptText="";
        char[][] alphabet = getCryptAlphabet(encryptKey);
        char[][] bigramm = getBigramm(text);
        //массив для хранения координат пар биграмм
        int[][] coordinates = new int[2][2];
        //счетчик ряда count_strings
        //0 - ряд для координат первой буквы в биграмме
        //1 - ряд для координат второй буквы в биграмме
        int count_strings = 0;


        //перебираем массив биграммы
        for (int i = 0; i < bigramm.length; i++) { //строки

            do { //перещелкиваем ряды координаты
                for (int j = 0; j < bigramm[i].length; j++) { //столбцы

                    //перебираем массив алфавита
                    for (int k = 0; k < alphabet.length; k++) {
                        for (int l = 0; l < alphabet[k].length; l++) {

                            if (alphabet[k][l] == bigramm[i][j]) {

                                coordinates[count_strings][0] = k;
                                coordinates[count_strings][1] = l;
                                count_strings++;
                            }
                        }
                    } //перебираем массив алфавита

                }//столбец
            } while (count_strings != 2);

            // TODO: 08.03.2021 В ЭТОМ БЛОКЕ КООРДИНАТЫ БИГРАММ СФОРМИРОВАНЫ - ПИСАТЬ КОД ТУТ !!!
            count_strings = 0;

            // TODO: 08.03.2021 условия сдвигов
            // OPTIMIZE: 13.03.2021 оптимизировать перебор элементов
            if (coordinates[0][0] == coordinates[1][0]) {
                //если строки равны
                ++coordinates[0][1];
                ++coordinates[1][1];
                if (coordinates[0][1] == 5) {
                    coordinates[0][1] = 0;
                }
                if (coordinates[1][1] == 5) {
                    coordinates[1][1] = 0;
                }

                //если столбцы равны
            } else if (coordinates[0][1] == coordinates[1][1]) {
                ++coordinates[0][0];
                ++coordinates[1][0];
                if (coordinates[0][0] == 5) {
                    coordinates[0][0] = 0;
                }
                if (coordinates[1][0] == 5) {
                    coordinates[1][0] = 0;
                }

            } else {

                // TODO: 08.03.2021 это нужно выполнять когда i и j не равны
                //замена координат - для получения координат новых букв
                int temp = coordinates[0][1];
                coordinates[0][1] = coordinates[1][1];
                coordinates[1][1] = temp;
            }


            //собираем строку шифрованную
            cryptText = cryptText.concat(Character.toString(alphabet[coordinates[0][0]][coordinates[0][1]])).
                    concat(Character.toString(alphabet[coordinates[1][0]][coordinates[1][1]])).concat(" ");


            // TODO: 08.03.2021 КОНЕЦ БЛОКА КООРДИНАТЫ БИГРАММ СФОРМИРОВАНЫ !!!

        }//строки
        //перебираем массив биграммы

        return cryptText;
    }

    @Override
    String decryptionAlgorithm(String text, String encryptKey) {
        return null;
    }


    private char[][] getCryptAlphabet(String key) {

        // FIXME: 28.03.2021 Нужно убрать пробелы из алфавита
        //// FIXME: 28.03.2021 Сделать буквы заглавными
        String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ.,! ";
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
        //// FIXME: 28.03.2021 Сделать буквы заглавными
        str = str.replaceAll(" ", "");

        //если строка нечетная добавляем в конце X и делаем четной

        if (str.length() % 2 != 0) str = str + "X";

        //если в биграмме одинаковые символы
        int begin_count = 0;
        int end_count = 2;

        String substring;

        String newText = "";
        do {
            substring = str.substring(begin_count, end_count);
            if (substring.length() == 2) {
                if (substring.charAt(0) == substring.charAt(1)) {
                    substring = substring.charAt(0) + "X";
                }
            }
            begin_count += 2;
            end_count += 2;

            newText += substring;
        } while (end_count <= str.length());
        str = newText;

        //формируем двумерный массив биграмм
        char[] arrayText = str.toCharArray();
        char[][] bigramm = new char[str.length() / 2][2];


        if (arrayText.length > 2) {

            for (int i = 0; i < bigramm.length; i++) {
                for (int j = 0; j < bigramm[i].length; j++) {
                    bigramm[i][j] = arrayText[i * bigramm[j].length + j];
                }
            }
            //вывод для теста - уберем потом
            System.out.println(Arrays.deepToString((bigramm)));
        } else {
            for (int i = 0; i < bigramm[0].length; i++) {
                bigramm[0][i] = arrayText[i];
            }
        }

        return bigramm;
    }


    void encrypt() {


        // FIXME: 28.03.2021 для флага наличия икас в конце строки
        //if (uneven) textCode = new String(textCode.substring(0, textCode.length() - 1));


    }//конец метода


}
