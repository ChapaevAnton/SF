package tasksBySf.level9;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamEx {

    public static void main(String[] args) throws IOException {
        File file = new File("smallFile.txt");
        FileInputStream fis = new FileInputStream(file);
        System.out.println(fis.available());
        int i = 0;
        int count = 0;
        while ((i = fis.read()) != -1) {
            if (i >= '0' && i <= '9') {
                count++;
            }

            //  System.out.print((char) i);
        }
        System.out.println(count);

        fis.close();
        System.out.println();

    }
}
