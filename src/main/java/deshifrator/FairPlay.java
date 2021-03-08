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
    static String textCode = "";
    static String textDeCode = "HMUBWBIREL";

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


        //массив для хранения координат пар биграмм
        int[][] coordinates = new int[2][2];
        int count = 0;


        //перебираем массив биграммы
        for (int i = 0; i < bigramm.length; i++) {

            for (int j = 0; j < bigramm[i].length; j++) {

                //перебираем массив алфавита
                for (int k = 0; k < newAlphabet.length; k++) {
                    for (int l = 0; l < newAlphabet[k].length; l++) {

                        // FIXME: 08.03.2021 нужно оптимизировать, как то в цикле
                        if (newAlphabet[k][l] == bigramm[i][j]) {
                            coordinates[count][0] = k;
                            coordinates[count][1] = l;
                            count++;
                        }
                    }
                } //перебираем массив алфавита

            }//столбец

            // FIXME: 08.03.2021 нужно оптимизировать, как то в цикле
            if (count == 2) {
                count = 0;
            }
            // TODO: 08.03.2021 условия сдвигов



            // TODO: 08.03.2021 это нужно выполнять когда i и j не равны
            //замена координат - для получения координат новых букв
            int temp = coordinates[0][1];
            coordinates[0][1] = coordinates[1][1];
            coordinates[1][1] = temp;


            //пары
            System.out.println(Arrays.deepToString(coordinates));

            System.out.println("======================");


            System.out.println(newAlphabet[coordinates[0][0]][coordinates[0][1]]);
            System.out.println(newAlphabet[coordinates[1][0]][coordinates[1][1]]);

            textCode = textCode.concat(Character.toString(newAlphabet[coordinates[0][0]][coordinates[0][1]])).
                    concat(Character.toString(newAlphabet[coordinates[1][0]][coordinates[1][1]])).concat(" ");


        }//строка
        //перебираем массив биграммы


        System.out.println(textCode);

    }//конец метода


}
