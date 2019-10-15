import java.util.ArrayList;

public class Ship {
    public int length;
    public boolean horizontal;
    public int[][] coordinates;
    private int health;


    Ship(int length, boolean horizontal) {
        this.length = length;
        this.horizontal = horizontal;
        health = length;

    }

    public int[][] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(int[][] coordinates) {
        this.coordinates = coordinates;
    }
}
