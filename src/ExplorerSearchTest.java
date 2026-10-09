import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    public void testReachableArea_AllExceptLocationIsUnreachable() {
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
    public void testReachableArea_OnlyOneRowReachable() {
        int[][] island = {
            {1,1,1,3,1,1},
            {3,2,3,1,3,1},
            {2,2,3,2,3,3},
            {1,1,1,1,0,1},
            {3,2,2,2,3,3},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(6, actual);
    }

    @Test
    public void testReachableArea_OnlyOneColumnReachable() {
        int[][] island = {
            {1,1,1,3,1,2},
            {3,2,3,2,1,2},
            {2,2,3,2,1,3},
            {1,1,1,3,0,2},
            {3,2,2,2,1,3},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(5, actual);
    }

    @Test
    public void testExplorerLocation_middleOfIsland() {
        int[][] island = {
            {1,1,1,3,1,2},
            {3,2,3,2,1,2},
            {2,2,3,0,1,3},
            {1,1,1,3,2,2},
            {3,2,2,2,1,3},
        };
        int[] expected = {2, 3};
        assertArrayEquals(expected, ExplorerSearch.explorerLocation(island));
    }

    @Test
    public void testExplorerLocation_topRightCorner() {
        int[][] island = {
            {1,1,1,3,1,0},
            {3,2,3,2,1,2},
            {2,2,3,1,1,3},
            {1,1,1,3,2,2},
            {3,2,2,2,1,3},
        };
        int[] expected = {0, 5};
        assertArrayEquals(expected, ExplorerSearch.explorerLocation(island));
    }

    @Test
    public void testExplorerLocation_notFound_throwsExcpetion() {
        int[][] island = {
            {1,1,1,3,1,2},
            {3,2,3,2,1,2},
            {2,2,3,2,1,3},
            {1,1,1,3,2,2},
            {3,2,2,2,1,3},
        };
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ExplorerSearch.explorerLocation(island);
        });
        assertEquals("There's no explorer on the island", exception.getMessage());
    }

    @Test
    public void testExplorerLocation_at_2_1() {
        int[][] island = {
            {1,1,1,3,1,1},
            {3,2,3,2,1,2},
            {2,0,3,1,1,3},
            {1,1,1,3,2,2},
            {3,2,2,2,1,3},
        };
        int[] expected = {2, 1};
        assertArrayEquals(expected, ExplorerSearch.explorerLocation(island));
    }

    @Test
    public void testPossibleMoves_allDirectionsCanCross() {
        int[][] island = {
            {1,1,1,3,1,1},
            {3,1,3,2,1,2},
            {1,0,1,1,1,3},
            {1,1,1,3,2,2},
            {3,2,2,2,1,3},
        };
        int[] location = {2, 1};
        List<int[]> moves = ExplorerSearch.possibleMoves(island, location);
        Set<String> moveSet = toSet(moves);

        assertEquals(4, moves.size());
        assertTrue(moveSet.contains("1,1"));
        assertTrue(moveSet.contains("3,1"));
        assertTrue(moveSet.contains("2,0"));
        assertTrue(moveSet.contains("2,2"));
    }

    @Test
    public void testPossibleMoves_allDirectionsCannotCross() {
        int[][] island = {
            {1,1,1,3,1,1},
            {3,3,3,2,1,2},
            {2,0,2,1,1,3},
            {1,3,1,3,2,2},
            {3,2,2,2,1,3},
        };
        int[] location = {2, 1};
        List<int[]> moves = ExplorerSearch.possibleMoves(island, location);
        assertTrue(moves.isEmpty());
    }

    @Test
    public void testPossibleMoves_moveOnlyLeftOnStraightPath() {
        int[][] island = {
            {1,1,1,1,1,0},
        };
        int[] location = {0, 5};
        List<int[]> moves = ExplorerSearch.possibleMoves(island, location);
        Set<String> moveSet = toSet(moves);

        assertEquals(1, moves.size());
        assertTrue(moveSet.contains("0,4"));
    }

    @Test
    public void testPossibleMoves_moveOnlyRightOnStraightPath() {
        int[][] island = {
            {0,1,1,1,1,1},
        };
        int[] location = {0, 0};
        List<int[]> moves = ExplorerSearch.possibleMoves(island, location);
        Set<String> moveSet = toSet(moves);

        assertEquals(1, moves.size());
        assertTrue(moveSet.contains("0,1"));
    }

    @Test
    public void testPossibleMoves_oneOpen_twoPathsCannotCross_oneEdge() {
        int[][] island = {
            {2, 2, 2},
            {1, 0, 1},
            {3, 3, 3}
        };
        int[] location = {1, 1};
        List<int[]> moves = ExplorerSearch.possibleMoves(island, location);
        Set<String> moveSet = toSet(moves);

        assertEquals(2, moves.size());
        assertTrue(moveSet.contains("1,2"));
        assertTrue(moveSet.contains("1,0"));
    }

    @Test
    public void testPossibleMoves_cannotCrossPathAbove() {
        int[][] island = {
            {2, 2, 2},
            {1, 0, 1},
            {3, 1, 3}
        };
        int[] location = {1, 1};
        List<int[]> moves = ExplorerSearch.possibleMoves(island, location);
        Set<String> moveSet = toSet(moves);

        assertFalse(moveSet.contains("0,1"));
        assertTrue(moveSet.contains("2,1"));
        assertTrue(moveSet.contains("1,0"));
        assertTrue(moveSet.contains("1,2"));
    }

    @Test
    public void testPossibleMoves_cannotCrossPathBelow() {
        int[][] island = {
            {2, 1, 2},
            {1, 0, 1},
            {3, 3, 3}
        };
        int[] location = {1, 1};
        List<int[]> moves = ExplorerSearch.possibleMoves(island, location);
        Set<String> moveSet = toSet(moves);

        assertTrue(moveSet.contains("0,1"));
        assertFalse(moveSet.contains("2,1"));
        assertTrue(moveSet.contains("1,0"));
        assertTrue(moveSet.contains("1,2"));
    }

    @Test
    public void testPossibleMoves_cannotCrossPathOnTheLeft() {
        int[][] island = {
            {2, 1, 2},
            {2, 0, 1},
            {3, 1, 3}
        };
        int[] location = {1, 1};
        List<int[]> moves = ExplorerSearch.possibleMoves(island, location);
        Set<String> moveSet = toSet(moves);

        assertTrue(moveSet.contains("0,1"));
        assertTrue(moveSet.contains("2,1"));
        assertFalse(moveSet.contains("1,0"));
        assertTrue(moveSet.contains("1,2"));
    }

    @Test
    public void testPossibleMoves_cannotCrossPathOnTheRight() {
        int[][] island = {
            {2, 1, 2},
            {1, 0, 3},
            {3, 1, 3}
        };
        int[] location = {1, 1};
        List<int[]> moves = ExplorerSearch.possibleMoves(island, location);
        Set<String> moveSet = toSet(moves);

        assertTrue(moveSet.contains("0,1"));
        assertTrue(moveSet.contains("2,1"));
        assertTrue(moveSet.contains("1,0"));
        assertFalse(moveSet.contains("1,2"));
    }

    @Test
    public void testPossibleMoves_topLeftCornerWithOneAvailableButUnreachable() {
        int[][] island = {
            {0, 2},
            {3, 1}
        };
        int[] location = {0, 0};
        List<int[]> moves = ExplorerSearch.possibleMoves(island, location);

        assertTrue(moves.isEmpty());
    }

    private Set<String> toSet(List<int[]> list) {
        Set<String> set = new HashSet<>();
        for (int[] arr : list) {
            set.add(arr[0] + "," + arr[1]);
        }
        return set;
    }
}
