package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
//        Pattern pattern = Pattern.compile("([a-zA-Z0-9]){0,10}([\\s]){0,}([a-zA-Z0-9]){1,}[\\.]{0,1}[\\s]{1,}");
//        Matcher matcher = pattern.matcher("dssd 123 ");
//        boolean ft = matcher.matches();
//
//        Pattern pattern1 = Pattern.compile("([a-z]){5}([\\s]){1,10}([a-z]){0,10}");
//        Matcher matcher1 = pattern1.matcher("azzaz aasasdasdaa");
//        boolean ft1 = matcher1.matches();
//
//        System.out.println("ft = " + ft1);
//
//        String text = "<strike>Это удалить!</strike>А это хороший текст, его трогать не надо.<strike> и это не нужно!</strike>";
//        Pattern pattern = Pattern.compile("<strike>.*?</strike>");
//        Matcher matcher = pattern.matcher(text);
//
//        while (matcher.find()){
//            int start = matcher.start();
//            int end = matcher.end();
//            System.out.println("Found match\n" + text.substring(start, end) + "\nfrom" + start + "to" + (end - 1));
//        }
//
//        System.out.println("Clean the text");
//        System.out.println(matcher.replaceAll(""));

        String text = "2000 2176 1956";
        Pattern pattern = Pattern.compile("");
        Matcher matcher = pattern.matcher(text);

        while(matcher.find()){
            int start = matcher.start();
            int end = matcher.end();
            System.out.println("Found match\n" + text.substring(start, end) + "\nfrom" + start + "to" + (end - 1));
        }
    }
}
