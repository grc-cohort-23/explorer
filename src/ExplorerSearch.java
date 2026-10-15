import java.util.ArrayList;
import java.util.List;

public class ExplorerSearch {

    /**
     * Returns how much land area an explorer can reach on a rectangular island.
     * 
     * The island is represented by a rectangular int[][] that contains
     * ONLY the following numbers:
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
        if(island == null) throw new NullPointerException();

        boolean[][] visited = new boolean[island.length][island[0].length];
        
        return reachableArea(findStart(island),island,visited);
    }

    public static int reachableArea(int[] node ,int[][] island, boolean[][] visited){
        if(island[node[0]][node[1]] != 1 && island[node[0]][node[1]] != 0) return 0; //Filters out 2 & 3
        if(visited[node[0]][node[1]]) return 0;
        visited[node[0]][node[1]] = true;

        int totalArea = 1;

        int[][] directions = new int[][]{
                                        {0,-1}, //UP
                                        {0,1},  //DOWN
                                        {-1,0}, //LEFT
                                        {1,0}   //RIGHT
                                    };

        for(int[] direction : directions){
            if(node[0] + direction[0] >= 0              // if not to far Up
            && node[0] + direction[0] < island.length   // if not to far Down
            && node[1] + direction[1] >= 0              // if not to far Left   
            && node[1] + direction[1] < island[node[0]].length  // if not to far Right
            ){
                totalArea += reachableArea(new int[]{node[0]+direction[0],node[1]+direction[1]},island,visited);
            }
        }

        

        return totalArea;
    }

    public static int[] findStart(int[][] island){
        for(int r = 0; r < island.length; r++){
            for(int c = 0; c < island[r].length; c++){
                if(island[r][c] == 0)return new int[]{r,c};
            }
        }
        throw new IllegalArgumentException();
    }
}
