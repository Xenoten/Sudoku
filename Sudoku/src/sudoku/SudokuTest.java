package sudoku;

import static org.junit.Assert.*;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SudokuTest {
	Sudoku<Integer> spel;

	@Before
	public void setUp() throws Exception {
		spel = new Sudoku<Integer>();
	}

	@After
	public void tearDown() throws Exception {
		spel = null;
	}

	@Test
	public void testEmpty() {
		assertTrue(spel.solve());
	}
	
	@Test
	public void testSolvable() {
		spel.set(1, 0, 2);
		spel.set(6, 0, 5);
		spel.set(4, 0, 6);
		spel.set(8, 0, 7);
		spel.set(5, 1, 4);
		spel.set(1, 1, 6);
		spel.set(6, 1, 7);
		spel.set(8, 2, 0);
		spel.set(2, 2, 2);
		spel.set(5, 3, 2);
		spel.set(2, 3, 3);
		spel.set(6, 3, 6);
		spel.set(1, 4, 3);
		spel.set(3, 4, 7);
		spel.set(9, 5, 0);
		spel.set(8, 5, 6);
		spel.set(6, 6, 4);
		spel.set(1, 6, 7);
		spel.set(4, 6, 8);
		spel.set(6, 7, 0);
		spel.set(9, 7, 3);
		spel.set(2, 7, 5);
		spel.set(2, 8, 0);
		spel.set(5, 8, 1);
		spel.set(8, 8, 5);
		assertTrue(spel.solve());
	}
	
	@Test
	public void testUnsolvable() {
		spel.set(1, 1, 3);
		spel.set(1, 1, 6);
		spel.set(4, 1, 7);
		spel.set(8, 1, 8);
		spel.set(5, 2, 5);
		spel.set(1, 2, 7);
		spel.set(6, 2, 8);
		spel.set(8, 3, 1);
		spel.set(2, 3, 3);
		spel.set(5, 4, 3);
		spel.set(2, 4, 4);
		spel.set(6, 4, 7);
		spel.set(1, 5, 4);
		spel.set(3, 5, 8);
		spel.set(9, 6, 1);
		spel.set(8, 6, 7);
		spel.set(6, 7, 5);
		spel.set(1, 7, 8);
		spel.set(4, 7, 2);
		spel.set(6, 8, 1);
		spel.set(9, 8, 4);
		spel.set(2, 8, 6);
		spel.set(2, 8, 1);
		spel.set(5, 8, 2);
		spel.set(8, 8, 6);
		assertFalse(spel.solve());
	}
	

}
