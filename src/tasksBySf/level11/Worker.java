package tasksBySf.level11;

import java.util.Queue;
import java.util.Stack;

public class Worker {
    private final Stack<String> toDoQueue;

    public Worker(Stack toDoQueue) {
        this.toDoQueue = toDoQueue;
    }

    public void takeTask() {
        Object task = toDoQueue.pop();
        if (task != null){
            System.out.println("Выполняю задачу: " + task);
        }else {
            System.out.println("Нет работы! Можно идти домой!");
        }
    }
}
