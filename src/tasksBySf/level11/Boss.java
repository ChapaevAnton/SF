package tasksBySf.level11;

import java.util.Queue;
import java.util.Stack;

public class Boss {
    private final Stack<String> toDoQueue;

    public Boss(Stack<String> toDoQueue) {
        this.toDoQueue = toDoQueue;
    }

    public void giveTask(String task) {
        toDoQueue.add(task);
        System.out.println("Дал задачу: " + task);
    }
}
