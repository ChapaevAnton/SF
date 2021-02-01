package tasksBySf.level11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class test {

    public static void main(String[] args) {
        Collection<? super String> collection = new LinkedList<>(); // 2

        collection.add("Hello"); // 3
        System.out.println(collection.size());
        List<Object> list = new ArrayList<>();
        modifyList(list);
        List<Integer> list2 = new ArrayList<>();
        list2.add(5);
        list2.add(6);
        list2.add(7);
        System.out.println(total(list2));

    }

    private static void modifyList(List<? super Number> list) {
        list.add(5.6d); // does not compile
        list.add(131232134342344L); // does not compile
        list.add(118); // does not compile
    }

    public static long total(List<? extends Number> list) {
        long count = 0;
        for (Number number : list) {
            count += number.longValue();
        }
        return count;
    }

    public static <T extends Number> void ship(T number) {
        double value = number.doubleValue();
        System.out.println("Preparing " + value);
    }
}
