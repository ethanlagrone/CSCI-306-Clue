package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.*;

import experiment.*;

public class BoardTestsExp {
    
    private static TestBoard board;
    
    @BeforeEach
    public void setUp() {
        board = new TestBoard();
    }

    @Test
    public void testAdjacency() {
        Set<TestBoardCell> adjCells = board.getCell(0,0).getAdjList();
        assertEquals(2, adjCells.size());
        assertTrue(adjCells.contains(board.getCell(1, 0)));
        assertTrue(adjCells.contains(board.getCell(0, 1)));

        adjCells = board.getCell(3,0).getAdjList();
        assertEquals(2, adjCells.size());
        assertTrue(adjCells.contains(board.getCell(2, 0)));
        assertTrue(adjCells.contains(board.getCell(3, 1)));

        adjCells = board.getCell(0,3).getAdjList();
        assertEquals(2, adjCells.size());
        assertTrue(adjCells.contains(board.getCell(1, 3)));
        assertTrue(adjCells.contains(board.getCell(0, 2)));

        adjCells = board.getCell(3,3).getAdjList();
        assertEquals(2, adjCells.size());
        assertTrue(adjCells.contains(board.getCell(2, 3)));
        assertTrue(adjCells.contains(board.getCell(3, 2)));

        adjCells = board.getCell(1,1).getAdjList();
        assertEquals(4, adjCells.size());
        assertTrue(adjCells.contains(board.getCell(0, 1)));
        assertTrue(adjCells.contains(board.getCell(2, 1)));
        assertTrue(adjCells.contains(board.getCell(1, 0)));
        assertTrue(adjCells.contains(board.getCell(1, 2)));
    }

    @Test
    public void testTargetsNormal() {
        board.calcTargets(board.getCell(0, 0), 1);
        Set<TestBoardCell> targets = board.getTargets();
        assertEquals(2, targets.size());
        assertTrue(targets.contains(board.getCell(1, 0)));
        assertTrue(targets.contains(board.getCell(0,1)));

        board.calcTargets(board.getCell(0, 0), 2);
        targets = board.getTargets();
        assertEquals(3, targets.size());
        assertTrue(targets.contains(board.getCell(2, 0)));
        assertTrue(targets.contains(board.getCell(0,2)));
        assertTrue(targets.contains(board.getCell(1,1)));

        board.calcTargets(board.getCell(0, 0), 3);
        targets = board.getTargets();
        assertEquals(6, targets.size());
        assertTrue(targets.contains(board.getCell(0, 1)));
        assertTrue(targets.contains(board.getCell(0,3)));
        assertTrue(targets.contains(board.getCell(1,0)));
        assertTrue(targets.contains(board.getCell(1,2)));
        assertTrue(targets.contains(board.getCell(2,1)));
        assertTrue(targets.contains(board.getCell(3,0)));

        board.calcTargets(board.getCell(1, 1), 1);
        targets = board.getTargets();
        assertEquals(4, targets.size());
        assertTrue(targets.contains(board.getCell(0, 1)));
        assertTrue(targets.contains(board.getCell(2, 1)));
        assertTrue(targets.contains(board.getCell(1, 0)));
        assertTrue(targets.contains(board.getCell(1, 2)));

        board.calcTargets(board.getCell(1, 1), 2);
        targets = board.getTargets();
        assertEquals(6, targets.size());
        assertTrue(targets.contains(board.getCell(0, 0)));
        assertTrue(targets.contains(board.getCell(0, 2)));
        assertTrue(targets.contains(board.getCell(1, 3)));
        assertTrue(targets.contains(board.getCell(2, 0)));
        assertTrue(targets.contains(board.getCell(2, 2)));
        assertTrue(targets.contains(board.getCell(3, 1)));

        board.calcTargets(board.getCell(1, 1), 3);
        targets = board.getTargets();
        assertEquals(6, targets.size());
        assertTrue(targets.contains(board.getCell(0, 3)));
        assertTrue(targets.contains(board.getCell(1, 0)));
        assertTrue(targets.contains(board.getCell(1, 2)));
        assertTrue(targets.contains(board.getCell(2, 3)));
        assertTrue(targets.contains(board.getCell(3, 0)));
        assertTrue(targets.contains(board.getCell(3, 2)));

        board.calcTargets(board.getCell(1, 1), 4);
        targets = board.getTargets();
        assertEquals(6, targets.size());
        assertTrue(targets.contains(board.getCell(0, 2)));
        assertTrue(targets.contains(board.getCell(1, 3)));
        assertTrue(targets.contains(board.getCell(2, 0)));
        assertTrue(targets.contains(board.getCell(2, 2)));
        assertTrue(targets.contains(board.getCell(3, 1)));
        assertTrue(targets.contains(board.getCell(3, 3)));
    }
    
    /*
    @Test
    public void 
    */
}
