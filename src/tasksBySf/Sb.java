package tasksBySf;

public class Sb {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Andrew");
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1; i++) {
            sb.delete(1,5);
        }
        System.out.println(sb.toString());

        System.out.println(System.currentTimeMillis() - startTime);
    }
}
