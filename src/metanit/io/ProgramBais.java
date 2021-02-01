package metanit.io;

import java.io.ByteArrayInputStream;

public class ProgramBais {

    public static void main(String[] args) {
        byte[] array1 = {1, 3, 5, 7};
        ByteArrayInputStream byteStream = new ByteArrayInputStream(array1);
        int b;
        while ((b = byteStream.read()) != -1){
            System.out.println(b);
        }
    }
}
