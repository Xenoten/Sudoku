package sudoku;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Sudoku<E> {
	ArrayList<ArrayList<Integer>> matrix;
	
	public Sudoku() {
		matrix = new ArrayList<ArrayList<Integer>>();
		for (int i = 0 ; i < 9; i++) {
			ArrayList<Integer> e = new ArrayList<Integer>(Collections.nCopies(9, 0));
			matrix.add(e);
		}
	}
	
	public int get (int col, int row) {
		return matrix.get(col).get(row);
	}
	
	public boolean set (int arg, int col, int row) {
//		if (matrix.isEmpty()) {
//			 ArrayList<E> e = new ArrayList<E>(9);
//			matrix.add(e);
//		}
		matrix.get(col).add(row, arg);
		return true;
	}
	
	public boolean isSolved () {
		boolean result = true;
		for (ArrayList<Integer> a : matrix) {
			Set<Integer> temp = new HashSet();
			for (int e :  a) {
				temp.add(e);
				}
			System.out.println(temp.size());
				if (temp.size() != 9) {
				result = false;
				}
			}
		return result;
	}
	
	public boolean works (int arg, int col, int row) {
		boolean result = true;
		//matrix.get(col).set(row, arg);
		for (int i = 0; i<9; i++) {
			
				if(matrix.get(col).get(i).equals(arg)) {
					result = false;
//					System.out.print(col);
//					System.out.print(row);
				}
			
			
		}
		
		for (int i = 0; i<9; i++) {
			if(matrix.get(i).get(row) != null) {
				if(matrix.get(i).get(row).equals(arg)) {
				result = false;
//				System.out.print(col);
//				System.out.print(row);
				}
			}
			
		}
		
		int ncol = 0;
		int nrow = 0;
		if((col != 0) && (row != 0)) {
		if(col%3 == 2){ncol = col - 1;}
		if(col%3 == 1){ncol = col;}
		if(col%3 == 0){ncol = col - 2;}
		if(row%3 == 2){nrow = row - 1;}
		if(row%3 == 1){nrow = row;}
		if(row%3 == 0){nrow = row - 2;}
		}
		for ( int i = ncol; i < ncol+2; i++ ) {
			for (int j = nrow; j < nrow+2; j++) {
//					System.out.println(i);
//					System.out.println(j);
//					System.out.println(arg);
					if(matrix.get(i).get(j).equals(arg)) {
					result = false;
//					System.out.print(i);
//					System.out.print(j);
					}
				}
				
			
		}
		return result;
	}
	
	public void show () {
		for (ArrayList<Integer> a : matrix) {
			for (int e :  a) {
				if (e != 0) {
				System.out.print(e);
				}
				else System.out.print("  ");
			}
			System.out.print("\n");
		}
	} 
	
	public boolean solve(int col, int row) {
		if(isSolved()) {
			return true;
		}
		
		for (int i = 0; i<9; i++) {
			int temp = get(col, row);
			if(works(i, col, row)) {
				set(i, col, row);
				int ncol= col;
				int nrow = row;
				if(row == 8) {ncol++; nrow = 0;}
				if(solve(ncol, nrow)) {
				return true;
				}
			}
			set(temp, col, row);
		}
		return false;
	}
	
	
}
