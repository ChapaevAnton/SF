package excersicez;

public class PrintOtOn {
//    public static void out(int n) {
//        for (int i = n - 1; i >= 0; i++) {
//            System.out.println(i);
//        }
//    }

    public static void out(int m, int n) {
        for (int i = m; i > n; i--) {
            System.out.println(i);
        }
    }

    public static void out(int price) {
        for (int i = 1; i <= 5; i++) {
            System.out.println(price * i);
        }
    }

    public static int mult(int a, int b) {
        int mult = 1;
        for (int i = a; i <= b; i++) {
            mult *= i;
        }
        return mult;
    }

    public static int calculate(int a, int n) {
        return (int) Math.pow(a, n);
    }

    public static void out1(int n) {
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.println(i);
            }
        }
    }

    public static int mod(int n, int d) {
        int x = n / d;
        return n - (x * d);
    }

    public static int sum(int a, int b) {
        int sum = 0;
        for (int i = a; i <= b; i = i + 2) {
            sum += i;
        }
        return sum;
    }

    public static int count(int a, int b) {
        int count = 0;
        for (int i = a; i <= b; i++) {
            if (i % 2 != 0) count++;
        }
        return count;
    }

    public static int checkStrings(String left, String right) {
        int count = 0;
        for (int i = 0; i < Math.min(left.length(),right.length()); i++) {
            if(left.charAt(i) != right.charAt(i)) count ++;
        }
        return count;
    }

    public static String code(String s) {
        StringBuilder sb = new StringBuilder(s);
        if(sb.toString().equals("")) return "empty";
        else if(sb.length() > 0 && sb.length() <= 4) return sb.toString();
        else
            for (int i = 0; i <= sb.length() - 4; i++) {
                sb.setCharAt(i, '#');
            }
        return sb.toString();
    }

    public static boolean check(int i) {
        boolean result = true;
        String str = String.valueOf(i);
        for (int j = 0; i < str.length() / 2; j++){
            if(str.charAt(j) != str.charAt(str.length() - j - 1)) result = false;
        }
        return result;
    }

    public static String collect(String s) {
        StringBuilder sb = new StringBuilder();
        String[] abb = s.split(" ");
        for (int i = 0; i < abb.length; i ++){
            sb.append(abb[i].charAt(0));
        }
        return sb.toString();
    }
}
