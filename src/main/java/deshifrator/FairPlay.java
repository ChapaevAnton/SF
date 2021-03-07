package deshifrator;

import java.util.Arrays;
import java.util.regex.Pattern;

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

        char[] key = keys.toCharArray();

        String alphabets = "ABCDEFGHIKLMNOPQRSTUVWXYZ"; //not J
        alphabets = keys + (alphabets.replaceAll("[" + keys + "]", ""));

        System.out.println(Arrays.toString(key));
        System.out.println(alphabets);

        char[] tempAlphabet = alphabets.toCharArray();
        char[][] newAlphabet = new char[5][5];
        for (int i = 0; i < newAlphabet.length; i++) {
            for (int j = 0; j < newAlphabet[i].length; j++) {
                newAlphabet[i][j] = tempAlphabet[i * newAlphabet[j].length + j];
            }
        }
        System.out.println(Arrays.deepToString(newAlphabet));

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


        //Pattern element1 = Pattern.compile("[" + bigramm[0][0] + "]");
        //Pattern element2 = Pattern.compile("[" + bigramm[0][1] + "]");

        int x1, y1;
        int x2, y2;


        for (int i = 0; i < newAlphabet.length; i++) {
            for (int j = 0; j < newAlphabet[i].length; j++) {

                if (newAlphabet[i][j] == bigramm[0][0]) {
                    x1 = i;
                    y1 = j;
                    System.out.println(bigramm[0][0] + "->" + x1 + " " + y1);
                }

                if (newAlphabet[i][j] == bigramm[0][1]) {

                    x2 = i;
                    y2 = j;
                    System.out.println(bigramm[0][1] + "->" + x2 + " " + y2);
                }

            }
        }




    }//конец метода


}
