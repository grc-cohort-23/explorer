import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

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
        int[] explorer = getExplorer(island);
        boolean[][] visited = new boolean[island.length][island[0].length];
        return canReach(island, explorer, visited);
        // Implement your method here!
        // Please also make more test cases
        // I STRONGLY RECOMMEND testing some helpers you might make too
    }    
    
    public static int canReach(int[][] island, int[] current, boolean[][] visited){
        if(visited[current[0]][current[1]]) return 0;
        if(island[current[0]][current[1]] == 2 || island[current[0]][current[1]] == 3) return 0;

        visited[current[0]][current[1]] = true;

        List<int[]> neighbors = openSpaces(island, current);
        int total = 1;
        for(int[] neighbor : neighbors){
            total = total + canReach(island, neighbor, visited);
        }
        return total;
    }

    private static List<int[]> openSpaces(int[][] island, int[] current) {
        int curR = current[0];
        int curC = current[1];

        int newR, newC;
        List<int[]> possible = new ArrayList<>();

        //Up
        newR = curR - 1;
        newC = curC;
        if(newR >= 0 && island[newR][newC] != 2 && newR >= 0 && island[newR][newC] != 3){
            possible.add(new int[]{newR, newC});
        }

        //Down
        newR = curR + 1;
        newC = curC;
        if(newR < island.length && island[newR][newC] != 2 && newR < island.length && island[newR][newC] != 3){
            possible.add(new int[]{newR, newC});
        }

        //Left
        newR = curR;
        newC = curC -1;
        if(newC >= 0 && island[newR][newC] != 2 && newC >= 0 && island[newR][newC] != 3 ){
            possible.add(new int[]{newR, newC});
        }

        //Right
        newR = curR;
        newC = curC + 1;
        if(newC < island[newR].length && island[newR][newC] != 2 && newC < island[newR].length && island[newR][newC] != 3){
            possible.add(new int[]{newR, newC});
        }

        return possible;
    }

    private static int[] getExplorer(int[][] island) {
        for(int i = 0; i < island.length; i++){
            for(int j = 0; j < island[i].length; j++){
                if(island[i][j] == 0){
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No explorer present");
    }
}