package archipov.stack;

public interface Queue<T> {
    void add(T item); // Добавить элемент в конец очереди
    T remove();       // Извлечение элемента из начала очереди

    boolean isEmpty();
}
