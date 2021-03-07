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


    }


}
