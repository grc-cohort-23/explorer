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
    int[] start = findStart(island);
    if (start == null) return 0;
    boolean[][] visited = new boolean[island.length][island[0].length];
    return explore(island, visited, start[0], start[1]);
}
   public static int[] findStart(int[][] island) {
    for (int i = 0; i < island.length; i++) {
        for (int j = 0; j < island[i].length; j++) {
            if (island[i][j] == 0) {
                return new int[]{i, j};
            }
        }
    }
    return null;
}

public static List<int[]> neighbors(int[][] island, int row, int col) {
    List<int[]> result = new ArrayList<>();
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    for (int[] d : dirs) {
        int r = row + d[0];
        int c = col + d[1];
        if (r >= 0 && r < island.length && c >= 0 && c < island[r].length
                && (island[r][c] == 0 || island[r][c] == 1)) {
            result.add(new int[]{r, c});
        }
    }
    return result;
}
private static int explore(int[][] island, boolean[][] visited, int row, int col) {
    visited[row][col] = true;
    int count = 1;
    for (int[] next : neighbors(island, row, col)) {
        int nextRow = next[0];
        int nextCol = next[1];
        if (!visited[nextRow][nextCol]) {
            count += explore(island, visited, nextRow, nextCol);
        }
    }
    return count;
}
}
