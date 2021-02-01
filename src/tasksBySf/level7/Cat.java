package tasksBySf.level7;

public class Cat extends Animal implements Soundable{

    @Override
    public void print() {
        System.out.println(this);
    }

    @Override
    public void sound() {
        System.out.println("Meow");
    }

    @Override
    public String toString() {
        return "I am a Cat";
    }
}
