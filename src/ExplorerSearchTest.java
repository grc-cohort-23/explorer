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
    public void testReachableArea_allReachable() {
        int[][] island = {
            {1,1,1,1,1,1},
            {1,1,1,1,1,1},
            {1,1,1,1,1,1},
            {1,1,1,1,0,1},
            {1,1,1,1,1,1},
        };

        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(30, actual);
    }

    @Test
    public void testReachableArea_allUnreachable() {
        int[][] island = {
            {1,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,1,3,3},
            {3,1,2,2,0,2},
            {1,1,1,2,3,1},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(1, actual);
    }

    @Test
    public void testReachableArea_noExplorer() {
        int[][] island = {
            {1,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,1,3,3},
            {3,1,2,1,1,1},
            {1,1,1,2,1,1},
        };

        assertThrows(IllegalArgumentException.class, () -> ExplorerSearch.reachableArea(island));
    }

        @Test
    public void testReachableArea_inACorner() {
        int[][] island = {
            {0,2,1,1,1,1},
            {1,1,1,1,1,1},
            {2,1,1,2,1,1},
            {1,1,1,1,1,1},
            {1,1,1,1,1,1},
        };

        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(27, actual);
    }

    @Test
    public void testReachableArea_inACornerBlocked() {
        int[][] island = {
            {0,2,1,1,1,1},
            {2,2,1,1,1,1},
            {2,1,1,2,1,1},
            {1,1,1,1,1,1},
            {1,1,1,1,1,1},
        };

        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(1, actual);
    }

        @Test
    public void testReachableArea_diagonalEscape() {
        int[][] island = {
            {1,1,1,2,1,1},
            {1,1,1,2,1,1},
            {1,1,1,1,2,1},
            {1,1,1,3,0,3},
            {1,1,1,1,3,1},
        };

        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(1, actual);
    }

    @Test
    public void testReachableArea_windingPath() {
        int[][] island = {
            {1,1,1,1,1,1},
            {1,2,2,2,2,1},
            {1,2,1,1,1,1},
            {1,2,2,3,3,3},
            {1,1,1,1,1,0},
        };

        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(20, actual);
    }

}
