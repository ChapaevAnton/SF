package tasksBySf.level10;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        method1();
    }

    public static void method1() {
        try {
            System.out.print("Try ");
            throw new Exception();
        } catch (Exception e) {
            System.out.print("Catch ");
            return;
        } finally {
            System.out.print("Finally ");
        }
    }
}