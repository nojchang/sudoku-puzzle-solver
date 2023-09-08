package sudokuPuzzleSolver;

public class SudokuPuzzleSolver {
	//The puzzle is a 9x9 grid.
	private static final int SIZE_OF_GRID = 9;
	
	public static void main(String[] args) {
		
		/*The Sudoku puzzle is represented as a 2D array named puzzle. 
		  The numbers represent the initial Sudoku puzzle, where '0' represents empty cells.
		*/
		int[][] puzzle = {
				{4, 0, 0, 0, 9, 6, 0, 0, 8},
				{0, 5, 9, 0, 2, 4, 0, 0, 6},
				{0, 6, 0, 3, 0, 0, 0, 9, 4},
				{0, 0, 2, 0, 0, 0, 0, 6, 0},
				{6, 8, 0, 0, 0, 0, 4, 5, 1},
				{0, 7, 0, 0, 0, 0, 0, 8, 0},
				{8, 1, 5, 4, 0, 0, 6, 2, 7},
				{7, 0, 0, 2, 0, 0, 8, 0, 0},
				{2, 0, 0, 0, 6, 8, 0, 1, 5}		
			};	
		/*The initial state of the Sudoku puzzle is printed using printSudokuBoard.
		  The solveSudokuBoard method is called to solve the puzzle.
		  If the puzzle is solvable, it prints a success message along with the solved puzzle.
		  If the puzzle is unsolvable, it prints an error message.
		*/
		printSudokuBoard(puzzle);
		if (solveSudokuBoard(puzzle)) {
			System.out.println();
			System.out.println("Sudoku board was solved successfully!");
			System.out.println();
			printSudokuBoard(puzzle);
		}
		else {
			System.out.println("This sudoku board was unsolvable!");
		}
	}
	
	/*This method is used to print the initial state of the Sudoku puzzle to the console. 
	  It formats the grid with separators for rows and columns.
	  The goal is to visually display the Sudoku board.
	*/
	static void printSudokuBoard(int[][] sudokuBoard) {
		for (int row = 0; row < SIZE_OF_GRID; row++) {
			if (row % 3 == 0 && row != 0) {
				System.out.println("-----------");
			}
			for(int column = 0; column < SIZE_OF_GRID; column++) {
				if (column % 3 == 0 && column != 0) {
					System.out.print("|");
				}
				System.out.print(sudokuBoard[row][column]);
			}
			System.out.println();
		}
	}
	
	/*This method checks whether a given number already exists in the specified row of the Sudoku board.
	It iterates through the row and returns true if the number is found; otherwise, it returns false.
	*/
	static boolean checkRowForNumber(int[][] board, int number, int row) {
		for (int i = 0; i < SIZE_OF_GRID; i++) {
			if (board[row][i] == number) {
				return true;
			}
		}
		return false;
	}
	
	/*Similar to checkRowForNumber, this method checks whether a given number already exists in the specified column of the Sudoku board.
	It iterates through the column and returns true if the number is found; otherwise, it returns false.
	*/
	static boolean checkColumnForNumber(int[][] board, int number, int column) {
		for (int i = 0; i < SIZE_OF_GRID; i++) {
			if (board[i][column] == number) {
				return true;
			}
		}
		return false;
	}
	
	/*This method checks whether a given number already exists in the 3x3 box (or subgrid) 
	that contains the cell at the specified row and column.
	It calculates the coordinates of the top-left cell of the box, 
	then iterates through the box to search for the number.
	*/
	static boolean checkBoxForNumber(int[][] board, int number, int row, int column) {
		int checkLocalBoxRow = row - row % 3;
		int checkLocalBoxColumn = column - column % 3;
		
		for (int i = checkLocalBoxRow; i < checkLocalBoxRow + 3; i++) {
			for( int j = checkLocalBoxColumn; j < checkLocalBoxColumn + 3; j++) {
				if (board[i][j] == number) {
					return true;
				}
			}
		}
		return false;
	}
	
	/*This method checks whether it's valid to place the given number in the cell 
	at the specified row and column of the Sudoku board.
	It calls the three previous methods (checkRowForNumber, checkColumnForNumber, 
	and checkBoxForNumber) to ensure that the placement is valid.
	Returns true if the placement is valid (i.e., the number doesn't violate Sudoku rules)
	otherwise, it returns false.
	*/
	static boolean checkValidPlacement(int[][] board, int number, int row, int column) {
		return !checkRowForNumber(board, number, row) &&
			   !checkColumnForNumber(board, number, column) &&
			   !checkBoxForNumber(board, number, row, column);
	}
	
	/*This is the core method for solving the Sudoku puzzle using recursive backtracking.
	It iterates through each cell of the Sudoku board.
	If the cell is empty (contains 0), it tries to place numbers from 1 to 9, 
	checking the validity of each placement using checkValidPlacement.
	If a valid number placement is found, it updates the cell with that number 
	and recursively calls solveSudokuBoard to continue solving.
	If the puzzle is successfully solved, the method returns true. 
	Otherwise, it backtracks by resetting the cell and returns false.
	*/
	static boolean solveSudokuBoard(int[][] board) {
		for (int row = 0; row < SIZE_OF_GRID; row++) {
			for (int column = 0; column < SIZE_OF_GRID; column++) {
				if (board[row][column] == 0) {
					for (int numberToTest = 1; numberToTest <= SIZE_OF_GRID; numberToTest++) {
						if (checkValidPlacement(board, numberToTest, row, column)) {
							board[row][column] = numberToTest;
							
							/*Recursive, calling the solveSudokuBoard method again, 
							  this recursive call attempts to solve the puzzle further with the updated board
							*/
							if (solveSudokuBoard(board)) {
								return true;
							}
							else {
								board[row][column] =0;
							}
						}
					}
					return false;
				}
			}
		}
		return true;
	}
}