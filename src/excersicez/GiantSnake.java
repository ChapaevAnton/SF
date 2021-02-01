package excersicez;

public class GiantSnake extends Monster {
    public static String scream = "Ssssss ";

    public GiantSnake(String name) {
        super(name + " the GiantSnake ", 7);
    }

    @Override
    public void growl() {
        System.out.println(scream);
        super.growl();
    }

    public void growl(boolean loud){
        if(!loud){
            growl();
        }else {
            System.out.print(scream.toUpperCase());
            super.growl();
        }
    }

    @Override
    public void attack() {
        growl(true);
        super.attack();
        System.out.println("     ...and hid in the grass");
    }
}
