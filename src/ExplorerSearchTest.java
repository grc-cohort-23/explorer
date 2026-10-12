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
    public void testReachableArea_noneUnreachable() {
        int[][] island = {
            {1,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,2,3,3},
            {3,1,2,3,0,2},
            {1,1,1,2,3,1},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(1, actual);
    }

    @Test
    public void testReachableArea_noStart() {
        int[][] island = {
            {1,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,2,3,3},
            {3,1,2,3,3,2},
            {1,1,1,2,3,1},
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
            {1,1,1,3,1,2},
            {3,2,3,3,1,2},
            {1,1,1,3,1,3},
            {3,1,2,2,0,2},
            {1,1,1,2,3,2},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(4, actual);
    }
    //edge case we need to solve for 
    @Test (expected = IllegalArgumentException.class)
    public void testReachableArea_twoStarts() {
        int[][] island = {
            {1,1,1,0,1,1},
            {3,2,3,2,3,1},
            {1,1,1,1,3,3},
            {3,1,2,1,0,1},
            {1,1,1,2,1,1},
        };
        ExplorerSearch.reachableArea(island);
    }
    
}
