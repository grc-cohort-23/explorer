import java.util.ArrayList;
import java.util.List;

public class ExplorerSearch {

    public static void main(int[] args){
        int[][] island = {
            {1,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,1,3,3},
            {3,1,2,1,0,1},
            {1,1,1,2,1,1},
        };

        int[][] island2 = {
            {1,1,1,3,1,1},
            {3,0,3,1,3,1},
            {1,1,1,1,3,3},
            {3,1,2,1,2,1},
            {1,1,1,2,1,1},
        };
    }

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

        // explorerLocation variable
        int[] start = explorerLocation(island);

        //visited boolean matrix
        boolean[][] visited = new boolean[island.length][island[0].length];

        //variable for reachableSpaces
        return reachableArea(island, visited, start);
    }

    public static int reachableArea(int[][] island, boolean[][] visited, int[] current){
        int curR = current[0];
        int curC = current[1];
        int reachableSpaces = 0;
        if(visited[curR][curC]) return 0;
        visited[curR][curC] = true;
        int count = 1;

        List<int[]> neighbors = possibleMoves(island, current);
        for(int[] neighbor : neighbors){
            count += reachableArea(island, visited, neighbor);
        }
        return count;
    }

    public static List<int[]> possibleMoves(int[][] island, int[] current){
        int curR = current[0];
        int curC = current[1];

        int newR, newC;
        List<int[]> possible = new ArrayList<>();

        //UP
        newR = curR - 1;
        newC = curC;
        if(newR >= 0 && island[newR][newC] != 2 && island[newR][newC] != 3){
            possible.add(new int[]{newR, newC});
        }
         //DOWN
        newR = curR + 1;
        newC = curC;
        if(newR < island.length && island[newR][newC] != 2 && island[newR][newC] != 3){
            possible.add(new int[]{newR, newC});
        }

        //LEFT
        newR = curR;
        newC = curC - 1;
        if(newC >= 0 && island[newR][newC] != 2 && island[newR][newC] != 3){
            possible.add(new int[]{newR, newC});
        }

        //Right
        newR = curR;
        newC = curC + 1;
        if(newC < island[newR].length && island[newR][newC] != 2 && island[newR][newC] != 3){
            possible.add(new int[] {newR, newC});
        }

        return possible;
    }

    public static int[] explorerLocation(int[][] island){
        for(int row = 0; row < island.length; row++){
            for(int column = 0; column < island[row].length; column++){
                if(island[row][column] == 0){
                    return new int[]{row, column};
                }
            }
        }
        throw new IllegalArgumentException("no explorer present");
    }
}
