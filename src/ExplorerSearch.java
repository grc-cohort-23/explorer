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
        if (island == null || island.length == 0) {
            return 0;
        }
        
        int startRow = 0;
        int startCol = 0;
        boolean found = false;

        boolean[][] visited = new boolean[island.length][island[0].length];

        for (int[] row : island) {
            startCol = 0;


            for (int slot : row) {
                if(slot == 0) {
                    found = true;
                     break;
                }
                startCol++;
            }
            
            if (found) {
                break;
            }
            startRow++;
        }

        if (!found) {
            return 0;
        }

        

        return explore(island, startRow, startCol, visited);
    }

    private static int explore(int[][] island, int startRow, int startCol, boolean[][] visited) {
        if (startCol < 0 || startRow < 0 || startRow >= island.length || startCol >= island[0].length ) return 0; 
            int count = 1;
            if (visited[startRow][startCol]) {
                return 0;
            }
            if(island[startRow][startCol] == 2 || 
                island[startRow][startCol] == 3) {
                    return 0;
                }
            
            
            visited[startRow][startCol] = true;
            count += explore(island, startRow-1, startCol, visited);
            count += explore(island, startRow+1, startCol, visited);
            count += explore(island, startRow, startCol-1, visited);
            count += explore(island, startRow, startCol+1, visited);
            return count;
        }
}
