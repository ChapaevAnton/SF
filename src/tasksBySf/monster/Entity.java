package tasksBySf.monster;

public abstract class Entity {
    private String name;
    private int hp;
    private boolean destroyed = false;

    public Entity(String name) {
        this.name = name;
    }

    protected boolean isDestroyed() {
        return destroyed;
    }

    protected boolean damage(int dhp) {
        hp -= dhp;
        if(hp < 0){
            destroyed = true;
            System.out.println("Monster " + name + " was destroyed");
            return true;
        }
        return false;
    }
}
