package tasksBySf.level9;

import java.io.*;
import java.net.ConnectException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

class ConvertException extends Exception {
    ConvertException(String msg) {
        super(msg);
    }
}

public class FileOutputStreamEx {
    public static void main(String[] args) throws IOException {
//        FileOutputStream fos = new FileOutputStream("request.txt");
//        fos.write("GIVE ME THE CODE PLEASE".getBytes());
//        fos.close();

        // copyFileUsingStream("test.txt", "smallFile.txt");
        try {
            copyFileUsingStream1("src/ut.txt", "UTF-8", "WINDOWS-1251", "src/win1251.txt");
            System.out.println("Перекодировка прошла удачно!");
        } catch (ConvertException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void copyFileUsingStream(String source, String dest) throws IOException {

        InputStream fis = new FileInputStream(source);

        OutputStream fos = new FileOutputStream(dest);

        byte[] buffer = new byte[1024];
        int length;
        while ((length = fis.read(buffer)) > 0) {
            fos.write(buffer, 0, length);
        }
        fis.close();
        fos.close();
    }

    private static void copyFileUsingStream1(String source, String sourceEnc, String destEnc, String dest) throws ConvertException {
        try (Reader fis = new InputStreamReader(new FileInputStream(new File(source)), Charset.forName(sourceEnc));
             Writer fos = new OutputStreamWriter(new FileOutputStream(new File(dest)), Charset.forName(destEnc))) {
            char[] budder = new char[1024];
            int length;
            while ((length = fis.read(budder)) > 0) {
                fos.write(budder, 0, length);
            }
        } catch (FileNotFoundException e) {
            throw new ConvertException("Не удалось открыть файл " + e.getMessage());

        } catch (UnsupportedCharsetException e) {
            throw new ConvertException("Указана неизвестная кодировк " + e.getMessage());

        } catch (IOException e) {
            throw new ConvertException("Возникла ошибка при копировании");

        }
    }
}
