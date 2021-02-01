package archipov;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Поиск файлов в папках на диске
 */

public class Main {
    public static void main(String[] args) {
        ArrayList<File> fileList = new ArrayList<>();
        searchFiles(new File("C:\\"), fileList);
        for(File file: fileList){
            System.out.println(file.getAbsolutePath());
        }
    }
    // File rootFile - Папка с который начинвется поиск, т.е. корневая папка для поиска
    // fileList - Список в который будут добавляться найденные файлы
    private static void searchFiles(File rootFile, List<File> fileList){
        if(rootFile.isDirectory()){ // Является ли корневая папка папкой.
            System.out.println("searching at: " + rootFile.getAbsolutePath());
            File[] directoryFiles = rootFile.listFiles(); //Получим все файлы которые лежат внутри папки
            if(directoryFiles != null){
                for(File file : directoryFiles){
                    if(file.isDirectory()){
                        searchFiles(file, fileList);
                    }else {
                        if(file.getName().toLowerCase().endsWith(".jpg")){
                            fileList.add(file);
                        }
                    }
                }
            }
        }
    }
}
