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
    static String textDeCode = "HM UB WB IR EL";

    //TABLE ABCDEFGHIJKLMNOPQRSTUVWXYZ

    public static void main(String[] args) {

        encrypt();

    }


    static void encrypt() {
        // FIXME: 08.03.2021 мы ничего ни делаем с ключом, не убираем пробелы и не убираем одинаковы символы


        // TODO: 07.03.2021 генерируем алфавит 
        char[] key = keys.toCharArray();
        // FIXME: 09.03.2021 J не кодируется - но есть идея как расширить алфавит - подсказка нужен всегда заполненный массив
        String alphabets = "ABCDEFGHIKLMNOPQRSTUVWXYZ"; //not J
        alphabets = keys + (alphabets.replaceAll("[" + keys + "]", ""));

        //вывод для теста - уберем потом
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
        //вывод для теста - уберем потом
        System.out.println(Arrays.deepToString(newAlphabet));


        // TODO: 07.03.2021 создаем биграммы из текста который будем шифровать
        // FIXME: 08.03.2021 когда создаем биграммы мы не учитываем если количество символов в слове нечетное
        // FIXME: 09.03.2021 мы ничего не делаем если биграмма из одинаковых символов
        text = text.replaceAll(" ", "");
        char[][] bigramm = new char[text.length() / 2][2];
        System.out.println(text);
        char[] arrayText = text.toCharArray();
        for (int i = 0; i < bigramm.length; i++) {
            for (int j = 0; j < bigramm[i].length; j++) {
                bigramm[i][j] = arrayText[i * bigramm[j].length + j];
            }
        }
        //вывод для теста - уберем потом
        System.out.println(Arrays.deepToString((bigramm)));


        // TODO: 07.03.2021 ищем координаты элементов биграммы

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
                    for (int k = 0; k < newAlphabet.length; k++) {
                        for (int l = 0; l < newAlphabet[k].length; l++) {

                            // FIXME: 08.03.2021 нужно оптимизировать, как то в цикле
                            if (newAlphabet[k][l] == bigramm[i][j]) {

                                coordinates[count_strings][0] = k;
                                coordinates[count_strings][1] = l;

                                count_strings++;
                            }
                        }
                    } //перебираем массив алфавита

                }//столбец
            } while (count_strings != 2);

            // TODO: 08.03.2021 В ЭТОМ БЛОКЕ КООРДИНАТЫ БИГРАММ СФОРМИРОВАНЫ - ПИСАТЬ КОД ТУТ !!!
            // FIXME: 08.03.2021 нужно оптимизировать, как то в цикл
            // FIXME: 08.03.2021 может быть это заменить на do while - то есть обернуть цикл столбцов в него.
            count_strings = 0;

            // TODO: 08.03.2021 условия сдвигов


            // TODO: 08.03.2021 это нужно выполнять когда i и j не равны
            //замена координат - для получения координат новых букв
            int temp = coordinates[0][1];
            coordinates[0][1] = coordinates[1][1];
            coordinates[1][1] = temp;


            //собираем строку шифрованную
            textCode = textCode.concat(Character.toString(newAlphabet[coordinates[0][0]][coordinates[0][1]])).
                    concat(Character.toString(newAlphabet[coordinates[1][0]][coordinates[1][1]])).concat(" ");


            //вывод для теста - уберем потом
            System.out.println(Arrays.deepToString(coordinates));
            System.out.println(newAlphabet[coordinates[0][0]][coordinates[0][1]]);
            System.out.println(newAlphabet[coordinates[1][0]][coordinates[1][1]]);
            System.out.println("======================");


            // TODO: 08.03.2021 КОНЕЦ БЛОКА КООРДИНАТЫ БИГРАММ СФОРМИРОВАНЫ !!!

        }//строки
        //перебираем массив биграммы


        //шифрованная строка
        System.out.println(textCode);

    }//конец метода


}
