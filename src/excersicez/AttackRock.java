package excersicez;

public class AttackRock {
    public static boolean check(String left, String right) {
        boolean result = true;
        for (int i = 1; i < Math.min(left.length(), right.length()); i++) {
            if ((left.charAt(i - 1) != right.charAt(i - 1)) && (left.charAt(i) != right.charAt(i))){
                result = false;
            }
        }
        return result;
    }
}
