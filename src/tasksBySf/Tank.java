package tasksBySf;

public class Tank {
    private int x;
    private int y;
    private int position;
    private int fuel;
    private static final String name = "T-34";
    private static int count;
    private int n;

    public Tank() {
        this(0, 0, 100);

    }

    public Tank(int x, int y) {
        this(x, y, 100);

    }

    public Tank(int x, int y, int fuel) {
        this.x = x;
        this.y = y;
        this.fuel = fuel;
        n = ++count;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public void goForward(int next) {
        if (next < 0 && -next > -fuel) next = -fuel;
        else if (next > fuel) next = fuel;
        if (position % 2 == 0) x = x + next;
        else y = y + next;
        fuel -= Math.abs(next);
    }

    public void backWard(int next) {
        goForward(-next);
    }

    public void turnRight() {
        position++;
        if (position == 4) position = 0;
    }

    public void turnLeft() {
        position--;
        if (position == -1) position = 3;
    }

    public void printPosition() {
        System.out.println("The Tank " + name + "-" + n + " is at " + x + ", " + y + " now.");
    }

    public static void main(String[] args) {
        Tank justTank = new Tank();
        Tank anywareTank = new Tank(10, 10);
        Tank customTank = new Tank(20, 30, 200);
        justTank.goForward(200);
        justTank.printPosition();
        anywareTank.backWard(-200);
        anywareTank.printPosition();
        customTank.goForward(201);
        customTank.printPosition();

    }

}
