package tasksBySf.level9;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new OneZeroStream());
        for (int i = 0; i < 10; i++) {
            System.out.print(scanner.nextInt());
        }
    }
}
