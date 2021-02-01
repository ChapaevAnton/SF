package javaRush;

import java.util.Arrays;

public class Solution {

    private static String UNEXPECTED_TYPE = "Я такого типа числа не жду!";

    public static void main(String[] args) {
        System.out.println(toCustomString((byte) 12));
        System.out.println(toCustomString(12));
        System.out.println(toCustomString(12.));
        System.out.println(toCustomString(12L));
    }

    public static String toCustomString(Number number) {
        //напишите тут ваш код
        if (number instanceof Byte) {
            Byte ix = (Byte) number;
            return String.valueOf(ix / 2 + "b");
        } else if (number instanceof Integer) {
            Integer ix = (Integer) number;
            return String.valueOf(ix / 3 + "");
        } else if (number instanceof Double) {
            Double ix = (Double) number;
            return String.valueOf(ix * 20 + "");
        }
        return UNEXPECTED_TYPE;
    }
}
