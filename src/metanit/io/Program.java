package metanit.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Program {

    public static void main(String[] args) {

        //Запишем данные.
        String text = "Hello World";
        try (FileOutputStream fos = new FileOutputStream("metanit1.txt")) {
            //Перевод строки в байты
            byte[] buffer = text.getBytes();
            fos.write(buffer,0, 5);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("The file has been written");

        //Считаем данные
        try(FileInputStream fis = new FileInputStream("metanit1.txt")){
            System.out.printf("File size: %d bytes \n", fis.available());

            int i = -1;
            while ((i = fis.read()) != -1){
                System.out.print((char) i);
            }
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }

        //Совместим оба класса и выполним чтение из одного и запись в другой файл
        try(FileInputStream fis = new FileInputStream("metanit1.txt");
                FileOutputStream fos = new FileOutputStream("metanit1_new.txt")){
            byte[] buffer = new byte[fis.available()];
            //Считываем буфер
            fis.read(buffer,0,buffer.length);
            fos.write(buffer,0, buffer.length);
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }

    }
}
