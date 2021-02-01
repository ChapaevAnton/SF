package tasksBySf.level9;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Scanner;
public class Transcoder {

    public static void main(String[] args) throws FileNotFoundException {
//        copyFileUsingStream(new File("src/win1251.txt"),
//                Charset.forName("windows-1251"),
//                new File("src/utf8.txt"),
//                Charset.forName("utf-8"));
        Scanner in = new Scanner(new FileInputStream("src/numbers.txt"));
        System.out.println(in.nextInt() + in.nextInt());
    }

    private static void copyFileUsingStream(File source, Charset sEnc, File dest, Charset dEnc) throws IOException {
        Reader fis = new FileReader(source, sEnc);
        Writer fos = new FileWriter(dest, dEnc);
        char[] buffer = new char[1024];
        int length;
        while ((length = fis.read(buffer)) > 0) {
            fos.write(buffer, 0, length);
        }

        fis.close();
        fos.close();
    }
}
