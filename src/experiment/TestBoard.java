package experiment;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TestBoard {
    
    private Map<TestBoardCell, Set<TestBoardCell>> cells;
    private Map<TestBoardCell, Set<TestBoardCell>> targets;
    
    public TestBoard() {
    	//setup this
    }

    public void calcTargets(TestBoardCell startCell, int pathlength) {
    	//do this
    }

    public TestBoardCell getCell(int row, int column) {
    	return new TestBoardCell(row, column);
        
    }

    public Set<TestBoardCell> getTargets() {
		return new HashSet<>();
    }
}
