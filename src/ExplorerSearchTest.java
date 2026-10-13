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

 @Test // Test case for a single cell island
    public void testReachableArea_singleCell() {
        int[][] island = {{0}};
        assertEquals(1, ExplorerSearch.reachableArea(island));
    }
 
    @Test // Test case for an island with no reachable area
    public void testReachableArea_allLand() {
        int[][] island = {
            {1,1,1},
            {1,0,1},
            {1,1,1},
        };
        assertEquals(9, ExplorerSearch.reachableArea(island));
    }
     @Test // Test case for an island with no reachable area
    public void testReachableArea_surroundedByObstacles() {
        int[][] island = {
            {1,3,1},
            {2,0,3},
            {1,2,1},
        };
        assertEquals(1, ExplorerSearch.reachableArea(island));
    }
 
    @Test // Test case for an island with diagonal paths blocked
    public void testReachableArea_diagonalNotAllowed() {
        int[][] island = {
            {0,3},
            {3,1},
        };
        assertEquals(1, ExplorerSearch.reachableArea(island));
    }
 
    @Test // Test case for an island with multiple paths
    public void testReachableArea_startInCorner() {
        int[][] island = {
            {0,1,1},
            {2,2,1},
            {1,1,1},
        };
        assertEquals(7, ExplorerSearch.reachableArea(island));
    }
}
