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
            int[] pos = ExplorerSearch.findExplorer(island);
            fail("IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException exception) {
            assertEquals("Explorer not found!", exception.getMessage());
        }
    }
}
