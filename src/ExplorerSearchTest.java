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
    public void testFindStart() {
        int[][] island = {
            {1, 1, 2},
            {1, 0, 3},
            {2, 1, 1}
        };

        int[] actual = ExplorerSearch.findStart(island);

        assertArrayEquals(new int[]{1, 1}, actual);
    }


    @Test
    public void testIsValidMove() {
        int[][] island = {
            {0, 1, 2},
            {1, 3, 1},
            {2, 1, 1}
        };

        assertTrue(ExplorerSearch.isValidMove(island, 0, 0));
        assertTrue(ExplorerSearch.isValidMove(island, 0, 1));

        assertFalse(ExplorerSearch.isValidMove(island, 0, 2));
        assertFalse(ExplorerSearch.isValidMove(island, 1, 1));

        assertFalse(ExplorerSearch.isValidMove(island, -1, 0));
        assertFalse(ExplorerSearch.isValidMove(island, 3, 0));
        assertFalse(ExplorerSearch.isValidMove(island, 0, -1));
        assertFalse(ExplorerSearch.isValidMove(island, 0, 3));
    }


    @Test
    public void testDfs() {
        int[][] island = {
            {0, 1, 2},
            {1, 1, 3},
            {2, 1, 1}
        };

        boolean[][] visited = new boolean[3][3];

        int actual = ExplorerSearch.dfs(island, 0, 0, visited);

        assertEquals(6, actual);
    }


    @Test
    public void testReachableArea_allFields() {
        int[][] island = {
            {0, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
        };

        assertEquals(9, ExplorerSearch.reachableArea(island));
    }

    @Test
    public void testReachableArea_blocked() {
        int[][] island = {
            {0, 2, 1},
            {3, 2, 1},
            {1, 1, 1}
        };

        assertEquals(1, ExplorerSearch.reachableArea(island));
    }

    @Test
    public void testReachableArea_singleSpace() {
        int[][] island = {
            {0}
        };

        assertEquals(1, ExplorerSearch.reachableArea(island));
    }

}
