package excersicez;

public class Battle {
    final static private int MAX = 5;
    public int n = 0;
    public static Monster[] monsters;

    Battle() {
        monsters = new Monster[MAX];
    }

    public void add(Monster monster) {
        if (n < MAX) {
            monsters[n++] = monster;
        } else {
            System.out.println("No more monsters!");
        }
    }

    public void start() {
        run();
    }

    private void run() {
        for (int i = 0; i < n; i++) {
            if (monsters[i] != null)
                monsters[i].attack();
        }
    }
}
