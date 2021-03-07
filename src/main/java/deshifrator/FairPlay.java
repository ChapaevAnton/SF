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

        char[] key = keys.toCharArray();

        String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
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
//        System.out.println(Arrays.deepToString(newAlphabet));

        text = text.replaceAll(" ", "");
        char[][] bigramm = new char[text.length() / 2][2];
//        System.out.println(text);
        char[] arrayText = text.toCharArray();
        for (int i = 0; i < bigramm.length; i++) {
            for (int j = 0; j < bigramm[i].length; j++) {
                bigramm[i][j] = arrayText[i * bigramm[j].length + j];
            }
        }
        System.out.println(Arrays.deepToString((bigramm)));
    }


}
