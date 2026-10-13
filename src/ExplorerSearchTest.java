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
    public void testReachableArea_noReachable() {
        int[][] island = {
                { 1, 1, 1, 3, 1, 1 },
                { 3, 2, 3, 1, 3, 1 },
                { 1, 1, 1, 1, 3, 3 },
                { 3, 1, 2, 2, 0, 3 },
                { 1, 1, 1, 2, 3, 1 },
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(1, actual);
    }

    @Test
    public void testReachableArea_noStarter() {
        int[][] island = {
                { 1, 1, 1, 3, 1, 1 },
                { 3, 2, 3, 1, 3, 1 },
                { 1, 1, 1, 1, 3, 3 },
                { 3, 1, 2, 2, 2, 3 },
                { 1, 1, 1, 2, 3, 1 }
        };

        assertThrows(IllegalArgumentException.class, () -> {
            ExplorerSearch.reachableArea(island);
        });
    }

    @Test
    public void testReachableArea_AllReachable() {
        int[][] island = {
                { 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 0, 1 },
                { 1, 1, 1, 1, 1, 1 },
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(30, actual);
    }
    
    @Test
    public void testReachableArea_someUnreachableWithDifferntStarter() {
        int[][] island = {
                { 1, 1, 0, 3, 1, 1 },
                { 3, 2, 1, 1, 3, 1 },
                { 1, 1, 1, 1, 3, 3 },
                { 3, 1, 2, 1, 2, 1 },
                { 1, 1, 1, 2, 1, 1 },
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(14, actual);
    }
    // Add more tests here!
    // Come up with varied cases
}
