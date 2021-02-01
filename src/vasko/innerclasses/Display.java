package vasko.innerclasses;

public class Display {
    private static final int DISPLAY_HEIGHT = 1920;
    private static final int DISPLAY_WIDTH = 1280;

    public Display() {
        Pixel pixel = new Pixel(10, 10, Colour.BLUE);
    }

    private class Pixel {
        private int x;
        private int y;
        private Colour colour;

        private Pixel(int x, int y, Colour colour) {

            if (0 <= x && x <= DISPLAY_WIDTH && 0 <= y && y <= DISPLAY_HEIGHT) {
                this.x = x;
                this.y = y;
                this.colour = colour;
                System.out.println("Creating " + colour + " pixel at (" + x + ", " + y + ")");
            } else {
                throw new IllegalArgumentException("Coordinate x and y should be between 0-" + DISPLAY_WIDTH + " and 0-" + DISPLAY_HEIGHT);
            }
        }
    }

    public enum Colour {
        RED, GREEN, BLUE, CYAN, MAGENTA, YELLOW, BLACK;
    }
}
