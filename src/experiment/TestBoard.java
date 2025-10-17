package experiment;

import java.util.HashSet;
import java.util.Set;

public class TestBoard {
    
    private TestBoardCell[][] grid;
    private Set<TestBoardCell> targets;
    private Set<TestBoardCell> visited;
    final static int COLS = 4;
    final static int ROWS = 4;
    
    public TestBoard() {
    	targets = new HashSet<>();
    	visited = new HashSet<>();
    	grid = new TestBoardCell[ROWS][COLS];
    	
    	//setup board with cells
    	for(int i = 0; i < ROWS; i++) {
    		for(int j = 0; j < COLS; j++) {
    			grid[i][j] = new TestBoardCell(i, j);
    		}
    	}
    	
    	//find every adjacency of each cell, hint said to do it here
    	for(int i = 0; i < ROWS; i++) {
    		for(int j = 0; j < COLS; j++) {
    			TestBoardCell cell = grid[i][j];
    			
    			if(i - 1 >= 0) {
    				cell.addAdjacency(grid[i-1][j]);
    			}
    			if(i + 1 < ROWS) {
    				cell.addAdjacency(grid[i+1][j]);
    			}
    			if(j - 1 >= 0) {
    				cell.addAdjacency(grid[i][j-1]);
    			}
    			if(j+1 < COLS) {
    				cell.addAdjacency(grid[i][j+1]);
    			}
    		}
    	}
    }

    public void calcTargets(TestBoardCell startCell, int numSteps) {
    	//source: slides from clue path walkthrough
    	for(TestBoardCell adjCell : startCell.getAdjList()) {
    		if(visited.contains(adjCell)) {
    			//do nothing
    		} else {
    			visited.add(adjCell);
    			if(numSteps == 1) {
    				targets.add(adjCell);
    			} else {
    				calcTargets(adjCell, numSteps-1);
    			}
    		}
    		visited.remove(adjCell);
    	}
    }

    public TestBoardCell getCell(int row, int column) {
    	return grid[row][column];
        
    }

    public Set<TestBoardCell> getTargets() {
		return this.targets;
    }
}
