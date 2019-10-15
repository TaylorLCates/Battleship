import java.util.ArrayList;
import java.util.Random;

public class Board {
    public static int numRows = 8;
    public static int numCols = 8;
    public static int health;
    public static String[][] battleShipGrid;
    private static Random random;
    public static ArrayList<Ship> ships = new ArrayList<Ship>();


    public Board() {
        this.battleShipGrid = new String[numRows][numCols];
        random = new Random();
        for (int i =1; i < 5; i++) {
            var isHorizontal = random.nextBoolean();
            ships.add(new Ship(i+1, isHorizontal));
        }
        this.arrangeBattleShips();
    }

    public static void printBoard() {
        System.out.print("  ");
        for(int i = 0; i < numCols; i++)
            System.out.print(i);
        System.out.println();

        for(int i = 0; i < battleShipGrid.length; i++) {
            for (int j = 0; j < battleShipGrid[i].length; j++) {
                if (j == 0)
                    System.out.print(i + "|" + battleShipGrid[i][j]);
                else if (j == battleShipGrid[i].length - 1)
                    System.out.print(battleShipGrid[i][j] + "|" + i);
                else
                    System.out.print(battleShipGrid[i][j]);
            }
            System.out.println();
        }

        System.out.print("  ");
        for(int i = 0; i < numCols; i++)
            System.out.print(i);
        System.out.println();
    }


    public static void arrangeBattleShips() {

        for (int i = 0; i < battleShipGrid.length; i++) {
            for (int j = 0; j < battleShipGrid[i].length; j++) {
                battleShipGrid[i][j] = " ";
            }
        }

        //IF you're reading this, just know that this is where the code get's super ugly because
        //I was trying to fix a problem that didn't exist and haven't taken out everything that doesn't need
        //to be here.
        for (int i =0; i < ships.size(); i++) {
            Ship originalShip = ships.get(i);
            Ship newShip = new Ship(originalShip.length, originalShip.horizontal);
            int startingCol = 0;
            int startingRow = 0;
            if (newShip.horizontal) {
                startingCol = random.nextInt(8 - newShip.length);
                startingRow = random.nextInt(8);
            } else {
                startingRow = random.nextInt(8 - newShip.length);
                startingCol = random.nextInt(8);
            }
            int[][] coordinates = new int[][]{};
            for (int j = 0; j < newShip.length; j++) {
                var tempIteratingCoordinate = new int[]{j};
                var tempCoordinate = new int[]{ startingRow, startingCol};
                newShip.setCoordinates(new int[][]{tempIteratingCoordinate, tempCoordinate});

            }
            //newShip.setCoordinates();
            ships.set(i,newShip);
        }
    }

    public static void hit() {
        if (health > 0) {
            System.out.println("Good hit!");
            health--;
        } else System.out.println("Ship has sunk");
    }
}
