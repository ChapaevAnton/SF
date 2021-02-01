package excersicez;

public class Monster {
    private String name;
    private int health;
    private int damage;

    public Monster(String name, int damage) {
        this.name = name;
        this.damage = damage;
        System.out.print("Monster ");
    }

    public void growl() {
        System.out.println(name + " growled");
    }

    public void attack() {
        System.out.println("Monster " + name + " attacked with damage " + damage);
    }

}
