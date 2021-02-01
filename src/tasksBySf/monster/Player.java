package tasksBySf.monster;

public class Player extends Human {

     Backpack backpack = new Backpack();

    public Player(String name) {
        super(name);
    }

    public Backpack getBackpack() {
        return backpack;
    }

    public void take(String thing){
        backpack.put(thing);
    }

    class Backpack {
        private String stuff = "";

        void put(String thing) {
            stuff += thing + ",";
        }

        public String toString() {
            if (stuff.equals("")) {
                return "the backpack is empty";
            }
            return stuff.substring(0, stuff.length() - 1) + " in the backpack";
        }
    }
}
