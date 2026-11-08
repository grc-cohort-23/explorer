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

        if (start == null) {
            return 0;
        }

        boolean[][] visited =
            new boolean[island.length][island[0].length];

        return dfs(island, start[0], start[1], visited);
    }



    static int[] findStart(int[][] island) {
        for (int row = 0; row < island.length; row++) {
            for (int col = 0; col < island[row].length; col++) {
                if (island[row][col] == 0) {
                    return new int[]{row, col};
                }
            }
        }
        return null;
    }


    static boolean isValidMove(int[][] island, int row, int col) {
        if (row < 0 || row >= island.length) {
            return false;
        }

        if (col < 0 || col >= island[row].length) {
            return false;
        }

        if (island[row][col] == 2 || island[row][col] == 3) {
            return false;
        }

        return true;
    }


    static int dfs(int[][] island, int row, int col, boolean[][] visited) {

        if (!isValidMove(island, row, col)) {
            return 0;
        }

        if (visited[row][col]) {
            return 0;
        }

        visited[row][col] = true;

        int count = 1;

        count += dfs(island, row - 1, col, visited);
        count += dfs(island, row + 1, col, visited);
        count += dfs(island, row, col - 1, visited);
        count += dfs(island, row, col + 1, visited);

        return count;
    }



}
