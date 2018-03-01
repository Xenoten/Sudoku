package sudoku;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello World");
		
		Sudoku<Integer> spel = new Sudoku();
		spel.set(1, 1, 1);
		spel.set(1, 2, 2);
		spel.set(1, 3, 3);
		spel.set(1, 4, 4);
		spel.set(1, 5, 5);
		spel.set(1, 6, 6);
		spel.set(1, 7, 7);
		spel.show();

	}

}
