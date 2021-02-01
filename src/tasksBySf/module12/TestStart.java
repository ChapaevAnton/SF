package tasksBySf.module12;

import vasko.interfaces.CellPhone;

import java.util.List;

public class TestStart extends Thread {

    int i;

    public TestStart(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println(i);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new TestStart(i).start();
        }
    }
}
