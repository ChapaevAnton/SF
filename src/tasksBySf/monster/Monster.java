package tasksBySf.monster;

public abstract class Monster extends Entity{


    private int force;


    public Monster(String name, int force) {
        super(name);
        this.force = force;
        System.out.println("Monster " + name + " was created");
    }

    protected int getForce() {
        return force;
    }
}
