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
        return reachableArea(island, new boolean[island.length][island[0].length], findStart(island));
    }

    private static int reachableArea(int[][] island, boolean[][] visited, int[] current){
        if(visited[current[0]][current[1]]) return 0;
        visited[current[0]][current[1]] = true;
        int moves = 1;
        List<int[]> possibleMoves = possibleMoves(island, current);
        if(possibleMoves.size() == 0) return moves;
        for(int[] move : possibleMoves){
            moves += reachableArea(island, visited, move);
        }

        return moves;
    }

    private static List<int[]> possibleMoves(int[][] island, int[] current){
        List<int[]> moves = new ArrayList<>();
        int r = current[0];
        int c = current[1];
        //up
        if(r-1 >= 0 && island[r-1][c] == 1) moves.add(new int[] {r-1, c});
        //down
        if(r+1 < island.length && island[r+1][c] == 1) moves.add(new int[] {r+1, c});
        //left
        if(c-1 >= 0 && island[r][c-1] == 1) moves.add(new int[] {r, c-1});
        //right
        if(c+1 < island[r].length && island[r][c+1] == 1) moves.add(new int[] {r, c+1});
        return moves;
    }

    private static int[] findStart(int[][] island){
        for(int r = 0; r < island.length; r++){
            for(int c = 0; c < island[r].length; c++){
                if(island[r][c] == 0){
                    return new int[]{r,c};
                }
            }
        }
        throw new IllegalArgumentException("Start not found");
    }

}
