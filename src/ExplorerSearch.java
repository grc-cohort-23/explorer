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
        int[] start = findStart(island);
        if (start == null) return 0;
        boolean[][] visited = new boolean[island.length][island[0].length];
        return explore(island, start[0], start[1], visited);
    }

    public static int[] findStart(int[][] island) {
    for (int r = 0; r < island.length; r++) {
        for (int c = 0; c < island[r].length; c++) {
            if (island[r][c] == 0) return new int[]{r, c};
        }
    }
    return null;
    }
    public static int explore(int[][] island, int r, int c, boolean[][] visited) {
    if (!canWalk(island, r, c) || visited[r][c]) return 0;

    visited[r][c] = true;
    int count = 1; // this square

    count += explore(island, r - 1, c, visited); // up
    count += explore(island, r + 1, c, visited); // down
    count += explore(island, r, c - 1, visited); // left
    count += explore(island, r, c + 1, visited); // right

    return count;
    }
    public static boolean canWalk(int[][] island, int r, int c) {
    if (r < 0 || r >= island.length) return false;
    if (c < 0 || c >= island[r].length) return false;
    return island[r][c] == 0 || island[r][c] == 1;
    }
}
