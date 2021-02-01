package tasksBySf.level7;

public class Dog extends Animal implements Soundable{

    @Override
    public void print() {
        System.out.println(this);
    }

    @Override
    public void sound() {
        System.out.println("Bark");
    }

    @Override
    public String toString() {
        return "I am a Dog";
    }
}
