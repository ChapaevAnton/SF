package archipov.stack;

public interface Stack<T> {
    void push(T item);  // Добавить элемент на вершину стека
    T pop();            // взять элемент с вершины стека

    boolean isEmpty();
}
