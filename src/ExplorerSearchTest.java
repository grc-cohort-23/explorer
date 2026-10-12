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
    public void testReachableArea_noneReachableExceptStart() {
        int[][] island = {
            {1,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,3,3,3},
            {3,1,2,3,0,3},
            {1,1,1,3,3,3},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(1, actual);
    }

    @Test
    public void testReachableArea_noStartingPointShouldReturnZero() {
        int[][] island = {
            {1,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,3,3,3},
            {3,1,2,3,2,3},
            {1,1,1,3,3,3},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(0, actual);
    }

    @Test
    public void testReachableArea_nullGraph() {
        int[][] island = {
            {},
            {},
            {},
            {},
            {},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(0, actual);
    }

    @Test
    public void testReachableArea_singleDirection() {
        int[][] island = {
            {1,1,1,3,1,3},
            {3,2,3,3,1,3},
            {1,1,1,3,1,3},
            {3,1,2,3,0,3},
            {1,1,1,3,3,3},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(4, actual);
    }


    @Test (expected = IllegalArgumentException.class)
    public void testReachableArea_twoStartsShouldThrowIllegalArgumentException() {
        int[][] island = {
            {1,1,1,3,1,3},
            {3,0,3,3,1,3},
            {1,1,1,3,1,3},
            {3,1,2,3,0,3},
            {1,1,1,3,3,3},
        };
       ExplorerSearch.reachableArea(island);
    }
    
    /*
    Starting Point Test
    */
    @Test
    public void testStartingPoint_testValidStartingPoint() {
        int[][] island = {
            {1,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,1,3,3},
            {3,1,2,1,0,1},
            {1,1,1,2,1,1},
        };
        int[] actual = ExplorerSearch.startingPoint(island);
        assertArrayEquals(new int[] {3, 4}, actual);
    }

}
