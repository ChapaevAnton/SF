package tasksBySf.file;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\ainje\\OneDrive\\Desktop\\Курсы");
        long size = getFolderSize(file);
        System.out.println((size / 1024 / 1024) + "MB");

    }

    private static long getFolderSize(File file) {
        long length = 0;
        File[] files = file.listFiles();
        for (File value : files) {
            if (value.isFile()) {
                length += value.length();
            } else {
                length += getFolderSize(value);
            }
        }
        return length;
    }
}
