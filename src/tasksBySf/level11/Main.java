package tasksBySf.level11;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Stack toDoQueue = new Stack();
        Boss boss = new Boss(toDoQueue);

        Worker worker = new Worker(toDoQueue);
        for (int i = 1; i <= 5; i++) {
            boss.giveTask("Задание " + i);
        }

        while (!toDoQueue.isEmpty()){
            worker.takeTask();
        }
    }
}
