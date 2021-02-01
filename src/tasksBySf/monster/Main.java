package tasksBySf.monster;

public class Main {
    public static void main(String[] args) {
        Player player = new Player("Tourist");
        Player.Backpack pb = player.backpack;
        System.out.println(pb);
        player.take("rope");
        System.out.println(pb);
        player.take("bottle");
        player.take("flower");
        System.out.println(pb);
    }
}
