import static org.junit.Assert.*;
import org.junit.Test;

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

    // Add more tests here!
    // Come up with varied cases

    @Test
    public void testReachableArea_NoAreas() {
        int[][] island = {
            {0,3,3,3,3,3},
            {2,2,1,1,3,1},
            {2,2,2,2,3,3},
            {3,1,2,2,3,1},
            {1,3,3,2,3,1},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(1, actual);
    }

    @Test // check if right move is possible
    public void canMoveRight() {
        int[][] island = {
            {0,1}
        };

        java.util.List<int[]> moves = ExplorerSearch.possibleMoves(island, new int[]{0, 0});

        assertEquals(1, moves.size());
        assertArrayEquals(new int[]{0, 1}, moves.get(0));
    }
    @Test // A walkable space to the left should be returned.
    public void testPossibleMoves_canMoveLeft() {
        int[][] island = {
            {1,0}
        };

        java.util.List<int[]> moves = ExplorerSearch.possibleMoves(island, new int[]{0,1});

        assertEquals(1, moves.size());
        assertArrayEquals(new int[]{0, 0}, moves.get(0));
    }
}
