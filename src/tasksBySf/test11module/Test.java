package tasksBySf.test11module;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        ArrayDeque<String> greetings = new ArrayDeque<>();
        greetings.push("hello");
        greetings.push("hi");
        greetings.push("ola");

        greetings.pop();
        System.out.println(greetings.peek());
        System.out.println(greetings);
        while (greetings.peek() != null) {
            System.out.print(greetings.pop());
        }

        HashSet<? super ClassCastException> set = new HashSet<Exception>();
        List<? extends Object> objects = new ArrayList<Object>();
    }
}
