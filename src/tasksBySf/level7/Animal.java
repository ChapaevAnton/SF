package tasksBySf.level7;

public abstract class Animal {

    public void print(){
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "I am an animal";
    }
}
