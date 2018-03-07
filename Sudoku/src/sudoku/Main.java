package sudoku;

import javafx.application.Application;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello World");
		
		
		
		Sudoku<Integer> spel = new Sudoku();
		spel.set(1, 1, 1);
		spel.set(2, 2, 2);
		spel.set(3, 3, 3);
		spel.set(1, 4, 4);
		spel.set(2, 5, 5);
		spel.set(3, 6, 6);
		spel.set(4, 7, 7);
		spel.show();
		System.out.println(spel.works(1, 2, 2));
		spel.solve();
		spel.show();
		spel.reset();
		spel.solve();
		spel.show();
		
	}

}
