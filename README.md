# sudoku-puzzle-solver
# Sudoku Puzzle Solver

This Java program, `SudokuPuzzleSolver`, is designed to solve 9x9 Sudoku puzzles. Sudoku is a popular logic-based number placement game. The program provides the ability to input a Sudoku puzzle, solve it, and display the solved puzzle if solvable.

## Table of Contents

- [How to Use](#how-to-use)
- [Program Overview](#program-overview)
- [Methods](#methods)
- [Testing](#testing)

## How to Use

1. Clone or download the repository to your local machine.
2. Open the Java project in your preferred Java development environment (e.g., Eclipse, IntelliJ IDEA).
3. Locate the `SudokuPuzzleSolver` class within the project.
4. Replace the example Sudoku puzzle in the `main` method with your own puzzle or use the provided example.

```java
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
```

5. Run the program. It will attempt to solve the puzzle.
6. If a solution is found, the program will display the solved puzzle.

   For example:
```
400|096|008
059|024|006
060|300|094
-----------
002|000|060
680|000|451
070|000|080
-----------
815|400|627
700|200|800
200|068|015

Sudoku board was solved successfully!

427|196|538
359|824|176
168|357|294
-----------
942|581|763
683|972|451
571|643|982
-----------
815|439|627
736|215|849
294|768|315
```
8. If the puzzle is unsolvable, an error message will be shown.

   For example:
```
400|096|008
059|024|006
060|300|094
-----------
002|000|060
680|000|451
070|000|080
-----------
815|400|627
700|200|800
700|068|015
This sudoku board was unsolvable!
```

## Program Overview

The `SudokuPuzzleSolver` program consists of the following key components:

- `main` method: This is the entry point of the program. It initializes a Sudoku puzzle, attempts to solve it, and prints the result.

- `printSudokuBoard` method: This method is responsible for printing the Sudoku puzzle in a user-friendly format with rows and columns separated by horizontal and vertical lines.

- Helper methods:
  - `checkRowForNumber`: Checks whether a number exists in a specified row of the Sudoku board.
  - `checkColumnForNumber`: Checks whether a number exists in a specified column of the Sudoku board.
  - `checkBoxForNumber`: Checks whether a number exists in a specified 3x3 box of the Sudoku board.
  - `checkValidPlacement`: Checks whether it is valid to place a number in a specific cell based on Sudoku rules.

- `solveSudokuBoard` method: The core solving algorithm implemented using recursive backtracking. It iterates through each cell, attempts to place numbers, and recursively solves the puzzle. If the puzzle is solvable, it returns `true`; otherwise, it returns `false`.

## Methods

### `printSudokuBoard(int[][] sudokuBoard)`

This method is responsible for printing the initial state of the Sudoku puzzle to the console in a user-friendly format.

### `checkRowForNumber(int[][] board, int number, int row)`

Checks whether a given number already exists in the specified row of the Sudoku board.

### `checkColumnForNumber(int[][] board, int number, int column)`

Checks whether a given number already exists in the specified column of the Sudoku board.

### `checkBoxForNumber(int[][] board, int number, int row, int column)`

Checks whether a given number already exists in the 3x3 box (or subgrid) that contains the cell at the specified row and column.

### `checkValidPlacement(int[][] board, int number, int row, int column)`

Checks whether it's valid to place the given number in the cell at the specified row and column of the Sudoku board. It combines the checks from the previous three methods.

### `solveSudokuBoard(int[][] board)`

The core method for solving the Sudoku puzzle using recursive backtracking. It iterates through each cell of the Sudoku board, attempting to place numbers and checking their validity. If the puzzle is solvable, it returns `true`; otherwise, it returns `false`.

## Testing

The program includes a test class, `SudokuPuzzleSolverTest`, that contains test methods for the utility methods (`checkRowForNumber`, `checkColumnForNumber`, `checkBoxForNumber`, `checkValidPlacement`) and the main puzzle-solving method (`solveSudokuBoard`). These tests ensure that the utility methods work correctly and that the puzzle-solving algorithm produces the expected results.

To run the tests, execute the `main` method within the `SudokuPuzzleSolverTest` class. The program will run the tests and display whether each test case passed or failed.

Feel free to use and modify this Sudoku puzzle solver to solve your own Sudoku puzzles or integrate it into your projects!
