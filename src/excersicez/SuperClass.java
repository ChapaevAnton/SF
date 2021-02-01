package excersicez;

public class SuperClass {
    private int d;

    public SuperClass(int age){
        this.d = age;
    }

    public void getD() {
        System.out.println(this.d);
    }

}

class SubClass extends SuperClass{

    public SubClass(int age) {
        super(age + 1);
    }

    public static void main(String[] args) {
        SubClass sb = new SubClass(1);
        sb.getD();

    }

    public void eat(){}
}