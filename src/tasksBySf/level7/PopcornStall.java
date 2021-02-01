package tasksBySf.level7;

public class PopcornStall implements Soundable{

    public void print() {
        System.out.println("It's PopcornStall");
    }

    @Override
    public void sound() {
        System.out.println("Hey! The best popcorn is here!");
    }
}
