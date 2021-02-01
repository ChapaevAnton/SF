package tasksBySf.level10;

import vasko.collections.stackQueue.StackQueueLauncher;

public class Main {
    public static void main(String[] args) {
        int[] array = {1, 2, -1, 5, 3};
//        int s = 0, i;
//        for (i = 0; i < array.length; i++) {
//            s += array[i];
//        }
//        System.out.println(s);

        String str = "Hello how are you";
        System.out.println("Length of the String: "+str.length());
        for(int i=0; i<str.length(); i++) {
            System.out.println(str.charAt(i));
        }
        //Accessing element at greater than the length of the String
        System.out.println(str.charAt(40));
    }
}
