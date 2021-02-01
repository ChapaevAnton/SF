package vasko.collections.autoboxing;

import java.util.*;

public class CollectionMain {
    public static void main(String[] args) {
        String[] colors = {"yellow", "green", "blue"};
        LinkedList<String> list = new LinkedList<>(Arrays.asList(colors));
        list.add("Brown");
        System.out.println(list);

        colors = list.toArray(new String[0]);
        System.out.println(Arrays.toString(colors));
    }
}
