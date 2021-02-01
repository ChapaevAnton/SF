package tasksBySf.anonim;

public class Main {

    public static void main(String[] args) {
        CoolPrinter.add("Own, two,");
        CoolPrinter.add("I love you.");
        CoolPrinter.add("Three, four,");
        CoolPrinter.add("Touch the floor.");
        CoolPrinter.print(new Formatter() {
            @Override
            public String format(String line) {
                return "** " + line + " **";
            }
        });
    }
}
