import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    public void testReachableArea_allReachable(){
        int[][] island = {
            {1,1,1,1,1},
            {1,1,1,1,1},
            {1,1,1,1,1},
            {1,1,1,1,1},
            {1,1,1,1,0}
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(25, actual);
    }

    @Test
    public void testReachableArea_noReachable(){
        int[][] island = {
            {1,1,1,1,1},
            {1,1,1,1,1},
            {1,1,1,1,1},
            {1,1,1,1,3},
            {1,1,1,2,0}
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(1, actual);
    }

    @Test
    public void testHelperReachableArea_someUnreachable(){
        int[][] island = {
            {1,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,1,3,3},
            {3,1,2,1,0,1},
            {1,1,1,2,1,1},
        };
        boolean[][] visited = new boolean[5][6];

        int actual = ExplorerSearch.reachableArea(new int[]{3,4},island,visited);
        assertEquals(14, actual);

        boolean[][] expected = {{false,false,false,false,false,false},
                                {false,false,false,true,false,false},
                                {true,true,true,true,false,false},
                                {false,true,false,true,true,true},
                                {true,true,true,false,true,true}};
        for(int i = 0; i < 5; i++){

            assertArrayEquals(expected[i],visited[i]);
        }
        
    }


    @Test
    public void testFindStartDefault(){
        int[][] island = {
            {1,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,1,3,3},
            {3,1,2,1,0,1},
            {1,1,1,2,1,1},
        };
        int[] actual = ExplorerSearch.findStart(island);
        assertArrayEquals(new int[]{3,4}, actual);
    }

    @Test
    public void testFindStartBig(){
        int[][] island = {
            {1, 1, 1, 3, 3, 2, 1, 3, 2, 1},
            {3, 1, 1, 1, 3, 1, 2, 3, 0, 1},
            {1, 1, 2, 1, 1, 1, 3, 1, 1, 3},
            {2, 1, 1, 1, 1, 2, 1, 1, 3, 2},
            {3, 1, 2, 1, 2, 1, 1, 1, 1, 1},
            {1, 1, 3, 1, 1, 1, 2, 1, 1, 3},
            {2, 1, 1, 1, 3, 2, 1, 1, 3, 2},
            {3, 2, 3, 1, 2, 1, 1, 1, 1, 2},
            {1, 1, 2, 2, 3, 3, 2, 1, 1, 1},
            {3, 3, 1, 2, 1, 2, 3, 2, 2, 3}
        };
        int[] actual = ExplorerSearch.findStart(island);
        assertArrayEquals(new int[]{1,8}, actual);
    }

    @Test
    public void testFindStartNoneFound(){
        int[][] island = {
            {1, 1, 1, 3, 3, 2, 1, 3, 2, 1},
            {3, 1, 1, 1, 3, 1, 2, 3, 1, 1},
            {1, 1, 2, 1, 1, 1, 3, 1, 1, 3},
            {2, 1, 1, 1, 1, 2, 1, 1, 3, 2},
            {3, 1, 2, 1, 2, 1, 1, 1, 1, 1},
            {1, 1, 3, 1, 1, 1, 2, 1, 1, 3},
            {2, 1, 1, 1, 3, 2, 1, 1, 3, 2},
            {3, 2, 3, 1, 2, 1, 1, 1, 1, 2},
            {1, 1, 2, 2, 3, 3, 2, 1, 1, 1},
            {3, 3, 1, 2, 1, 2, 3, 2, 2, 3}
        };
        assertThrows(IllegalArgumentException.class, () -> {
            ExplorerSearch.findStart(island);
        });
    }
}
