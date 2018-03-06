
package sudoku;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Sudoku<E> {
	ArrayList<ArrayList<Integer>> matrix;
	private boolean solved = false;
	private boolean solvable = true;
	
	/* constructor */
	
	public Sudoku() {
		matrix = new ArrayList<ArrayList<Integer>>();
		for (int i = 0 ; i < 9; i++) {
			ArrayList<Integer> e = new ArrayList<Integer>(Collections.nCopies(9, 0));
			matrix.add(e);
		}
	}
	
	/**
	 * Gets value at selected coordinates.
	 * @param col index of column
	 * @param row index of row
	 * @return value of selected row and column
	 */
	
	public int get (int col, int row) {
		return matrix.get(row-1).get(col-1);
	}
	
	/**
	 * sets a value at specified coordinate
	 * @param arg the value to be inserted
	 * @param col index of column
	 * @param row index of row
	 * @return returns true
	 */
	
	public boolean set (int arg, int col, int row) {

		matrix.get(row-1).set(col-1, arg);
		return true;
	}
	
	/**
	 * Evaluates whether or not the sudoku is filled or not.
	 * @return true if 9 unique values are present, none of which are zero. otherwise false.
	 */
	
	public boolean isSolved () {
		boolean result = true;
		
		for (ArrayList<Integer> a : matrix) {
			Set<Integer> temp = new HashSet();
			for (int e :  a) {
				temp.add(e);
				}
			
			
			if (temp.size() != 9 || temp.contains(0)) {
				result = false;
			}
		}
		
		for (int i = 0; i < 9; i++){
			Set<Integer> temp2 = new HashSet();
			for(ArrayList<Integer> t: matrix){
				temp2.add(t.get(i));
			}
			if (temp2.size() != 9 || temp2.contains(0)) {
				result = false;
			}
		}
		return result;
	}
	
	/**
	 * evaluates if specified value could be placed at designated coordinates according to sudoku rules.
	 * @param arg specified value
	 * @param col index of column
	 * @param row index of row
	 * @return false if insertion would break sudoku rules, otherwise true.
	 */
	
	public boolean works (int arg, int col, int row) {
		System.out.println(col + " "+ row);
		boolean result = true;
		
		for (int i = 1; i < 10; i++) {
				if(get(col, i) == arg) {
					result = false;
				}
		}
		
		for (int i = 1; i<10; i++) {
				if(get(i, row) == arg) {
					result = false;
				}
		}
		
		int ncol = col - 1;
		int nrow = row - 1;
		if(ncol%3 == 2){ncol = ncol - 2;}
		if(ncol%3 == 1){ncol = ncol - 1;}
		if(ncol%3 == 0){ncol = ncol;}
		if(nrow%3 == 2){nrow = nrow - 2;}
		if(nrow%3 == 1){nrow = nrow - 1;}
		if(nrow%3 == 0){nrow = nrow;}
		for ( int i = ncol; i < ncol+3; i++ ) {
			for (int j = nrow; j < nrow+3; j++) {
					if(get(i+1, j+1) == arg) {
					result = false;
					}
				}
				
			
		}
		return result;
	}
	
	/**
	 * prints current sudoku in terminal as text. testing purposes only.
	 */
	
	public void show () {
		for (ArrayList<Integer> a : matrix) {
			for (int e :  a) {
				
				System.out.print(e);
			
			}
			System.out.print("\n");
		}
	} 
	
	/**
	 * recursive method.
	 * evaluates isSolved() and stops recursion if true.
	 * if pre-existing value is found, evaluates whether it is in accordance to the rules using works().
	 * continues recursion if true, stops and sets solvable = false if false.
	 * if no value found and solvable is true, attempts to set value from 1-9 according to works().
	 * recurses with next row or column if true.
	 * returns false if no value 1-9 for works() returns true, resulting in backtracking.
	 * @param col index of column.
	 * @param row index of row.
	 * @return true if solved false if not.
	 */
	
	public boolean solve(int col, int row) {
		boolean result = false;
		
		int ncol= col;
		int nrow = row +1;
		if(nrow == 10) {ncol++; nrow = 1;}
		
		
		if(isSolved()) {
			solved = true;
			return true;
		}
		
		else if (get(col, row) != 0) {
			int temp = get(col, row);
			set(0, col, row);
			if (works(temp, col, row)){
				set(temp, col, row);
				return solve(ncol, nrow);
			}
			else {
				set(temp,col,row);
				solvable = false;
				return false;
			}
		}
		
		else {
			for (int i = 1; i<10; i++) {
				if(works(i, col, row) && solvable) {
					set(i, col, row);
					
					if(solve(ncol, nrow)){
						result = true;
					}
					else if (i == 9 && !solved){
						set(0, col, row);
					}
				}
				else if (i == 9 && !solved){
					set(0, col, row);
				}
				
			}
		
		}
		return result;
	}
	
	
}