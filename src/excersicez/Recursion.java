package excersicez;

public class Recursion {
    public static void main(String[] args) {
        counter(3);
    }

    public static  void counter(int n){
        if(n == 0) return;

        counter(n - 1);
        System.out.println(n);
    }
}
