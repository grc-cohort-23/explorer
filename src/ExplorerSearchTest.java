import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Set;
import java.util.HashSet;
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
    public void testExplorerFound() {
        int[][] island = {
            {3,3,2,3},
            {3,2,2,1},
            {2,2,1,1},
            {0,1,1,3}
        };
        int[] expected = {3,0};
        assertArrayEquals(expected, ExplorerSearch.findExplorer(island));
    }

    @Test
    public void testExplorerNotFound() {
        int[][] island = {
            {3,3,2,3},
            {3,2,2,1},
            {2,2,1,1},
            {1,1,1,3}
        };
        try {
            ExplorerSearch.findExplorer(island);
            fail("IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException exception) {
            assertEquals("Explorer not found!", exception.getMessage());
        }
    }

    @Test
    public void testPossibleMovesAllDirectionsFree() {
        int[][] island = {
            {1,1,1},
            {1,0,1},
            {1,1,1}
        };
        int[] pos = {1,1};
        List<int[]> moves = ExplorerSearch.possibleMoves(island, pos);
        Set<String> movesStrings = toSet(moves);

        assertEquals(4, moves.size());
        assertTrue(movesStrings.contains("0,1"));
        assertTrue(movesStrings.contains("1,0"));
        assertTrue(movesStrings.contains("2,1"));
        assertTrue(movesStrings.contains("1,2"));
    }

    @Test
    public void testPossibleMovesAllDirectionsBlockedWithRiverAndMountain() {
        int[][] island = {
            {3,2,2},
            {3,0,3},
            {2,2,3}
        };
        int[] pos = {1,1};
        List<int[]> moves = ExplorerSearch.possibleMoves(island, pos);

        assertEquals(0, moves.size());
    }

    @Test 
    public void testCannotMove() {
        int[][] island = {
            {1,2,1},
            {3,0,3},
            {1,2,1}
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(1, actual);
    }

    private Set<String> toSet(List<int[]> list) {
        Set<String> set = new HashSet<>();
        for (int[] arr : list) {
            set.add(arr[0] + "," + arr[1]);
        }
        return set;
    }
}
