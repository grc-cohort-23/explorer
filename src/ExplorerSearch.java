import java.util.ArrayList;
import java.util.List;

public class ExplorerSearch {

    /**
     * Returns how much land area an explorer can reach on a rectangular island.
     * 
     * The island is represented by a rectangular int[][] that contains
     * ONLY the following nunbers:
     * 
     * '0': represents the starting location of the explorer
     * '1': represents a field the explorer can walk through
     * '2': represents a body of water the explorer cannot cross
     * '3': represents a mountain the explorer cannot cross
     * 
     * The explorer can move one square at a time: up, down, left, or right.
     * They CANNOT move diagonally.
     * They CANNOT move off the edge of the island.
     * They CANNOT move onto a a body of water or mountain.
     * 
     * This method should return the total number of spaces the explorer is able
     * to reach from their starting location. It should include the starting
     * location of the explorer.
     * 
     * For example
     * 
     * @param island the locations on the island
     * @return the number of spaces the explorer can reach
     */
    public static int reachableArea(int[][] island) {
        // Implement your method here!
        // Please also make more test cases
        // I STRONGLY RECOMMEND testing some helpers you might make too
        return -1;
    }

    /**
     * Finds the explorer in a 2D array representing an island.
     * 
     * @param island 2D integer array representing an island.
     * @return An int array containing the (y,x) position of the explorer.
     * @throws IllegalArgumentException If explorer is not found on the island.
     */
    public static int[] findExplorer(int[][] island) {
        for (int y = 0; y < island.length; y++) {
            for (int x = 0; x < island[y].length; x++) {
                if (island[y][x] == 0) return new int[]{y,x};
            }
        }
        throw new IllegalArgumentException("Explorer not found!");
    }
}
