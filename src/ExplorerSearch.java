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
        int[] start = startingPoint(island);
        if(start == null) return 0;
        boolean[][] seen = new boolean [island.length][island[0].length];
        return explore (island, seen, start[0], start[1]);
    }

    public static int explore(int[][] island, boolean[][] seen, int row, int col) {

        //first if statement for possible moves boundaries of the graph

        if(row < 0 || row >= island.length || col < 0 || col >= island[row].length) {
            return 0;
        }
        //second if statement for visited checks
        if(seen[row][col]) {return 0;}
        //third if statment for possible move but wall checks or water
        if(island[row][col] == 2 || island[row][col] == 3){ return 0;}
        //mark true if they are visited or seen
        seen[row][col] = true;
        //return count where we add movement logic
        int count = 1; //starting point is inclusive

        //up
        count += explore(island, seen, row-1, col);
        //down
        count += explore(island, seen, row+1, col);
        //left
        count += explore(island, seen, row, col-1);
        //right
        count += explore(island, seen, row, col+1);

        return count;
    }

    public static int[] startingPoint(int[][] island) {
        int[] start = null;
        for (int row = 0; row < island.length; row++) {
            
            for (int col = 0; col < island[row].length; col++) {
                if (island[row][col] == 0) {
                    if(start != null) {
                        throw new IllegalArgumentException("two starting points not allowed");
                    }
                    start = new int[]{row, col};
                }
            }
        }

        return start;
    }
}
