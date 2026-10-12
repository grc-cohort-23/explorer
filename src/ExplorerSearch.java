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
        PrettyPrint.prettyPrintln(island);
        // Implement your method here!
        // Please also make more test cases
        // I STRONGLY RECOMMEND testing some helpers you might make too
        //pretty print implementation
        PrettyPrint.prettyPrintln(island);
        int [] start = theStartingPositionWhere0Is(island);
        if (start == null) return 0;
        boolean [][] seen = new boolean [island.length][island[0].length];

        //pretty print
        int area = explore(island, seen, start[0], start[1]);
        PrettyPrint.prettyPrintln(seen);
        return area;

        // return explore (island, seen, start[0], start[1]);
    }
    //helper to find starting location 0 
    //we need to add a handler to dissallow a second starting point
    private static int[] theStartingPositionWhere0Is(int[][] island) {
        
        int[] start = null;
        for(int r = 0; r<island.length; r++){
            for(int c = 0; c<island[r].length; c++){
                if(island[r][c] == 0){
                    if(start != null){
                        throw new IllegalArgumentException("two starting points found");
                    }
                }
                start = new int [] {r, c};
            }
            
        }
        return start;
    }
    private static int explore(int[][] island, boolean[][] seen, int r, int c){

        //first if statement for possible moves boundaries of the graph
        if(r<0 || r>= island.length || c<0 || c>=island[r].length) {return 0;}
        //second if statement for visited checks
        if(seen[r][c]) {return 0;}
        //third if statement for possible move but wall checks or water
        if(island[r][c] == 2 || island[r][c] == 3) {return 0;}
        //mark true if visited or seen
        seen[r][c] = true;
        //return count where we add movement logic
        int count = 1; // we start on 0 which is a position we count
        //up
        count += explore(island, seen, r-1, c);
        //down
        count += explore(island, seen, r+1, c);
        //left
        count += explore(island, seen, r, c-1);
        //right
        count += explore(island, seen, r, c+1);

        return count;
    }

}

