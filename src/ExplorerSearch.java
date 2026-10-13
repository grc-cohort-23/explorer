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
        if (island == null || island.length == 0) {
        return 0;
    }

    int[] start = findStartingPosition(island);

    if (start == null) {
        return 0;
    }

    boolean[][] visited =
    new boolean[island.length][island[0].length];

    return explore(island, start, visited);
}

private static int explore(int[][] island, int[] current,
    boolean[][] visited) {
    int row = current[0];
    int col = current[1];

    if (visited[row][col]) {
        return 0;
    }

    visited[row][col] = true;
    int count = 1;

    for (int[] next : possibleMoves(island, current)) {
        int nextRow = next[0];
        int nextCol = next[1];

        if (!visited[nextRow][nextCol]) {
            count += explore(island, next, visited);
        }
    }

    return count;
}
    
        // Implement your method here!
        // Please also make more test cases
        // I STRONGLY RECOMMEND testing some helpers you might make too
        
        public static int[] findStartingPosition(int[][] island) {
            for (int row = 0; row < island.length; row++) {
                for (int column = 0; column < island[row].length; column++) {
                    if (island[row][column] == 0) {
                        return new int[]{row, column};
                    }
                }
            }
            return null;
        }

     public static List<int[]> possibleMoves(
            int[][] island, int[] current) {

        List<int[]> moves = new ArrayList<>();

        int row = current[0];
        int col = current[1];

        
        int[][] directions = {
            {-1, 0}, // Up
            {1, 0}, // down,
            {0, -1}, // left
            {0, 1} //right
        };

        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

             if (newRow < 0 || newRow >= island.length) {
                continue;
            }

             if (newCol < 0 || newCol >= island[newRow].length) {
                continue;
            }

 
            if (island[newRow][newCol] == 0
                    || island[newRow][newCol] == 1) {
                moves.add(new int[] { newRow, newCol });
            }
        }

        return moves;
    }
}


    
    
    
