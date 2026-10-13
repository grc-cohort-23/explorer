import static org.junit.Assert.*;
import org.junit.Test;
import java.util.List;

public class ExplorerSearchTest {
    @Test
    public void testReachableArea_someUnreachable() {
        int[][] island = {
            {1,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,1,3,3},
            {3,1,2,1,0,1},
            {1,1,1,2,1,1},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(14, actual);
    }

  

    
@Test 
public void testStart() {
    int[][] island = {
        {1, 1, 1},
        {1, 0, 1},
        {1, 1, 1},
    };

    int[] start = ExplorerSearch.findStartingPosition(island);
    assertArrayEquals(new int[]{1, 1}, start);
     
}

@Test 
public void testReachableAreaDoesNotCountCellsTwice() {
        int[][] island = {
            {0, 1},
            {1, 0}
        };
        assertEquals(4, ExplorerSearch.reachableArea(island));
    }


@Test
    public void testPossibleMovesAllDirections() {
        int[][] island = {
            {2, 1, 2},
            {1, 0, 1},
            {2, 1, 2}
        };

            List<int[]> moves =
            ExplorerSearch.possibleMoves(island, new int[]{1, 1});

        assertEquals(4, moves.size());
    }

}