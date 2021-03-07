package deshifrator;

import java.util.Arrays;

public class FairPlay {

    char[][] alphabet = {
            {'A', 'B', 'C', 'D', 'E'},
            {'F', 'G', 'H', 'I', 'K'},
            {'L', 'M', 'N', 'O', 'P'},
            {'Q', 'R', 'S', 'T', 'U'},
            {'V', 'W', 'X', 'Y', 'Z'}};
    static String keys = "TABLE";
    static String text = "FOR EXAMPLE";

    //TABLE ABCDEFGHIJKLMNOPQRSTUVWXYZ

    public static void main(String[] args) {

        encrypt();

    }


    static void encrypt() {

        // TODO: 07.03.2021 генерируем алфавит 
        char[] key = keys.toCharArray();

        String alphabets = "ABCDEFGHIKLMNOPQRSTUVWXYZ"; //not J
        alphabets = keys + (alphabets.replaceAll("[" + keys + "]", ""));

        System.out.println(Arrays.toString(key));
        System.out.println(alphabets);

        // TODO: 07.03.2021 преобразовываем алфавит в двумерный массив 5 на 5 
        char[] tempAlphabet = alphabets.toCharArray();
        char[][] newAlphabet = new char[5][5];
        for (int i = 0; i < newAlphabet.length; i++) {
            for (int j = 0; j < newAlphabet[i].length; j++) {
                newAlphabet[i][j] = tempAlphabet[i * newAlphabet[j].length + j];
            }
        }
        System.out.println(Arrays.deepToString(newAlphabet));

        // TODO: 07.03.2021 создаем биграммы из текста который будем шифровать 
        text = text.replaceAll(" ", "");
        char[][] bigramm = new char[text.length() / 2][2];
        System.out.println(text);
        char[] arrayText = text.toCharArray();
        for (int i = 0; i < bigramm.length; i++) {
            for (int j = 0; j < bigramm[i].length; j++) {
                bigramm[i][j] = arrayText[i * bigramm[j].length + j];
            }
        }
        System.out.println(Arrays.deepToString((bigramm)));


        // TODO: 07.03.2021 ищем координаты элементов биграммы
        //Pattern element1 = Pattern.compile("[" + bigramm[0][0] + "]");
        //Pattern element2 = Pattern.compile("[" + bigramm[0][1] + "]");

        //перебираем массив биграммы
        for (int i = 0; i < bigramm.length; i++) {
            for (int j = 0; j < bigramm[i].length; j++) {

                //перебираем массив алфавита
                for (int x = 0; x < newAlphabet.length; x++) {
                    for (int y = 0; y < newAlphabet[x].length; y++) {


                        if (newAlphabet[x][y] == bigramm[i][j]) {

                            System.out.println(bigramm[i][j] + "->" + x + " " + y);
                        }

                    }
                } //перебираем массив алфавита

            }
        }//перебираем массив биграммы


    }//конец метода


}
