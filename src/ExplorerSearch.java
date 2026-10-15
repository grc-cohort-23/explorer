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

        // tracking the starter using a helper function
        int[] start = explorerLocation(island);
        boolean[][] visited = visited = new boolean[island.length][island[0].length];
        return reachableArea(island, visited, start);

    }


    /**
     * This method checks for reachable areas. [rows][columns]
     * 
     * @param island int[][] parameter for matrix
     * @param visited the boolean[][] variables for [x][y] that have been visited in this method
     * @param current the current [x][y] for traversal purposes
     * @return
     */
    public static int reachableArea(int[][] island, boolean[][] visited, int[] current){
        /*
        Assign the curX and curY values
         */
        int curX = current[0];
        int curY = current[1];
        
        //check if the current has been visited
        if(visited[curX][curY]) return 0;

        visited[curX][curY] = true;

        List<int[]> neighbors = possibleMoves(island, current);

        //initialize sum, starts at 1 to indicate the starting location as a "move"
        int sum = 1;

        // loop neighbors
        for(int[] neighbor : neighbors) {
                sum += reachableArea(island,visited,neighbor);
        }
        return sum;

    }

    public static List<int[]> possibleMoves(int[][] island, int[] current) {
        int curX = current[0];
        int curY = current[1];

        int newX, newY;
        List<int[]> possible = new ArrayList<>();

        // up
        newX = curX - 1;
        newY = curY;
        if(newX >= 0 && island[newX][newY] == 1){
            possible.add(new int[]{newX, newY});
        }

        // down
        newX = curX + 1;
        newY = curY;
        if(newX < island.length && island[newX][newY] == 1){
            possible.add(new int[]{newX, newY});
        }

        // left
        newX = curX;
        newY = curY - 1;
        if(newY >= 0 && island[newX][newY] == 1){
            possible.add(new int[]{newX, newY});
        }

        // right
        newX = curX;
        newY = curY + 1;
        if(newY < island[curX].length && island[newX][newY] == 1){
            possible.add(new int[]{newX, newY});
        }

        return possible;
    }

    /**
     * 
     * @param island int[][] parameter for matrix
     * @return the int [row][column] representing the location of the explorer in the value of 0
     * @throws IllegalArgumentException if the explorer isn't found
     */

    public static int[] explorerLocation(int[][] island) {
        for(int row = 0; row < island.length; row++){ // loop rows
            for(int column = 0; column < island[row].length; column++){ // loop columns by using row length
                if(island[row][column] == 0){
                    return new int[] {row,column};
                }
            }
        }

        throw new IllegalArgumentException("Explorer not found or doesn't exist.");
    }
}
