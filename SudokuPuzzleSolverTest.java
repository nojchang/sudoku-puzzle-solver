package sudokuPuzzleSolver;

public class SudokuPuzzleSolverTest {
	public static void main(String[] args) {
        testCheckRowForNumber();
        testCheckColumnForNumber();
        testCheckBoxForNumber();
        testCheckValidPlacement();
        testSolveSudokuBoard();
    }

    // Test method for checkRowForNumber
    public static void testCheckRowForNumber() {
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

        // Test cases for checkRowForNumber
        boolean result1 = SudokuPuzzleSolver.checkRowForNumber(puzzle, 1, 0);
        boolean result2 = SudokuPuzzleSolver.checkRowForNumber(puzzle, 4, 0);
        boolean result3 = SudokuPuzzleSolver.checkRowForNumber(puzzle, 9, 0);

        // Manually check the results and print a message
        if (!result1 && result2 && result3) {
            System.out.println("checkRowForNumber test passed");
        } else {
            System.out.println("checkRowForNumber test failed");
        }
    }

    // Test method for checkColumnForNumber
    public static void testCheckColumnForNumber() {
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

        // Test cases for checkColumnForNumber
        boolean result1 = SudokuPuzzleSolver.checkColumnForNumber(puzzle, 3, 0);
        boolean result2 = SudokuPuzzleSolver.checkColumnForNumber(puzzle, 4, 0);
        boolean result3 = SudokuPuzzleSolver.checkColumnForNumber(puzzle, 7, 0);

        // Manually check the results and print a message
        if (!result1 && result2 && result3) {
            System.out.println("checkColumnForNumber test passed");
        } else {
            System.out.println("checkColumnForNumber test failed");
        }
    }

    // Test method for checkBoxForNumber
    public static void testCheckBoxForNumber() {
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

        // Test cases for checkBoxForNumber
        boolean result1 = SudokuPuzzleSolver.checkBoxForNumber(puzzle, 1, 0, 0);
        boolean result2 = SudokuPuzzleSolver.checkBoxForNumber(puzzle, 4, 0, 0);
        boolean result3 = SudokuPuzzleSolver.checkBoxForNumber(puzzle, 5, 0, 0);

        // Manually check the results and print a message
        if (!result1 && result2 && result3) {
            System.out.println("checkBoxForNumber test passed");
        } else {
            System.out.println("checkBoxForNumber test failed");
        }
    }

    // Test method for checkValidPlacement
    public static void testCheckValidPlacement() {
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

        // Test cases for checkValidPlacement
        boolean result1 = SudokuPuzzleSolver.checkValidPlacement(puzzle, 2, 3, 2); //This test case should return false.
        boolean result2 = SudokuPuzzleSolver.checkValidPlacement(puzzle, 3, 0, 1); //This test case should return true.

        // Manually check the results and print a message
        if (!result1 && result2) {
            System.out.println("checkValidPlacement test passed");
        } else {
            System.out.println("checkValidPlacement test failed");
        }
    }

    // Test method for solveSudokuBoard
    public static void testSolveSudokuBoard() {
        int[][] unsolvableBoard = {
        	{4, 0, 0, 0, 9, 6, 0, 0, 8},
			{0, 5, 9, 0, 2, 4, 0, 0, 6},
			{0, 6, 0, 3, 0, 0, 0, 9, 4},
			{0, 0, 2, 0, 0, 0, 0, 6, 0},
			{6, 8, 0, 0, 0, 0, 4, 5, 1},
			{0, 7, 0, 0, 0, 0, 0, 8, 0},
			{8, 1, 5, 4, 0, 0, 6, 2, 7},
			{4, 0, 0, 2, 0, 0, 8, 0, 0},
			{2, 0, 0, 0, 6, 8, 0, 1, 5}		
		};	

        // Test case for an unsolvable board
        boolean result1 = SudokuPuzzleSolver.solveSudokuBoard(unsolvableBoard);

        int[][] solvableBoard = {
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

        // Test case for a solvable board
        boolean result2 = SudokuPuzzleSolver.solveSudokuBoard(solvableBoard);

        // Manually check the results and print a message
        if (!result1 && result2) {
            System.out.println("solveSudokuBoard test passed");
        } else {
            System.out.println("solveSudokuBoard test failed");
        }
    }
}