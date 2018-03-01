package sudoku;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Sudoku<E> {
	ArrayList<ArrayList<E>> matrix;
	
	public Sudoku() {
		matrix = new ArrayList<ArrayList<E>>();
		for (int i = 0 ; i < 9; i++) {
			ArrayList<E> e = new ArrayList<E>(Collections.nCopies(9, null));
			matrix.add(e);
		}
	}
	
	public E get (int col, int row) {
		return matrix.get(col).get(row);
	}
	
	public boolean set (E arg, int col, int row) {
//		if (matrix.isEmpty()) {
//			 ArrayList<E> e = new ArrayList<E>(9);
//			matrix.add(e);
//		}
		matrix.get(col).add(row -1 , arg);
		return true;
	}
	
	public boolean isSolved () {
		boolean result = true;
		for (ArrayList<E> a : matrix) {
			Set<E> temp = new HashSet();
			for (E e :  a) {
				temp.add(e);
				}
				if (temp.size() != 9) {
				result = false;
				}
			}
		return result;
	}
	
	public void show () {
		for (ArrayList<E> a : matrix) {
			for (E e :  a) {
				if (e != null) {
				System.out.print(e);
				}
				else System.out.print("  ");
			}
			System.out.print("\n");
		} 
	}
	
	public boolean solve() {
		for (ArrayList<E> a : matrix) {
			for (E e :  a) {
				if (e == null) {
					
				}
			}
		}
		return true;
	}
}
