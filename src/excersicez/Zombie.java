package excersicez;

public class Zombie extends Monster {

    public static String scream = "Raaaauuughhhh ";

    public Zombie(String name) {
        super(name, 5);
        System.out.println(name + " the Zombie" + " was created");
    }

    @Override
    public void growl() {
        System.out.print(scream);
        super.growl();
    }

    public void growl(boolean loud) {
        if (!loud) {
            growl();
        } else {
            System.out.print(scream.toUpperCase());
            super.growl();
        }
    }

    @Override
    public void attack() {
        super.attack();
        growl();
    }
}
