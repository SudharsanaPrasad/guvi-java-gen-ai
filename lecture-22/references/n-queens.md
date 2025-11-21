### Problem: N-Queens using Backtracking

You are given a chessboard of size n x n.

Place n queens on the board so that:

* No two queens are in the same row
* No two queens are in the same column
* No two queens are on the same diagonal

Input to the program:

* An integer n (size of the board and number of queens)

Output from the program:

* All valid arrangements of n queens
* Each arrangement can be shown as an n x n board, where:

  * 'Q' represents a queen
  * '.' represents an empty cell

The goal is to generate and return (or print) all such valid boards using backtracking.

---

### Approach

1. We place queens row by row.
2. For the current row, we try each column:

   * Check if placing a queen at (row, col) is safe:

     * It must not share a column with any previous queen.
     * It must not share a diagonal with any previous queen.
3. If it is safe:

   * Place the queen in that column for this row.
   * Move to the next row and repeat.
4. If we reach a row index equal to n:

   * We have placed queens in all rows.
   * This forms one complete valid solution. We record it.
5. If in some row no column is safe:

   * We backtrack:

     * Return to the previous row.
     * Move that queen to the next possible column.
6. We explore all possibilities in this way and collect all valid boards.

Key backtracking idea:

* Build the solution step by step.
* At each step, only keep safe choices.
* If a partial choice cannot lead to a full solution, undo it and try something else.

---

### Pseudocode

Representation:

* queens[row] = col means there is a queen at (row, col).

Safe check:

* For every previously placed queen at (prevRow, prevCol):

  * Columns must differ: prevCol != col
  * Main diagonal (top-left to bottom-right) must differ: prevRow - prevCol != row - col
  * Anti-diagonal (top-right to bottom-left) must differ: prevRow + prevCol != row + col

```text
function solveNQueens(n):
    result = empty list of solutions
    queens = array of size n   // queens[row] = col

    function isSafe(row, col):
        for prevRow from 0 to row - 1:
            prevCol = queens[prevRow]

            if prevCol == col:
                return false   // same column

            if prevRow - prevCol == row - col:
                return false   // same main diagonal

            if prevRow + prevCol == row + col:
                return false   // same anti-diagonal

        return true

    function buildBoard():
        board = empty list of strings
        for row from 0 to n - 1:
            rowString = ""
            for col from 0 to n - 1:
                if queens[row] == col:
                    rowString += "Q"
                else:
                    rowString += "."
            add rowString to board
        return board

    function backtrack(row):
        if row == n:
            add buildBoard() to result
            return

        for col from 0 to n - 1:
            if isSafe(row, col):
                queens[row] = col
                backtrack(row + 1)
                // no explicit undo needed, queens[row] will be overwritten

    backtrack(0)
    return result
```

---

### Implementation

```java
import java.util.ArrayList;
import java.util.List;

public class NQueens {

    // Public method to solve N-Queens and return all boards
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        int[] queens = new int[n]; // queens[row] = col

        backtrack(0, n, queens, results);
        return results;
    }

    // Backtracking: try to place a queen in the given row
    private static void backtrack(int row, int n, int[] queens, List<List<String>> results) {
        // If all rows are filled, we found a complete solution
        if (row == n) {
            results.add(buildBoard(queens, n));
            return;
        }

        // Try each column in the current row
        for (int col = 0; col < n; col++) {
            if (isSafe(row, col, queens)) {
                queens[row] = col;     // place queen
                backtrack(row + 1, n, queens, results);
                // no explicit "undo" needed, this row's value will be overwritten
            }
        }
    }

    // Check if placing a queen at (row, col) is safe
    private static boolean isSafe(int row, int col, int[] queens) {
        for (int prevRow = 0; prevRow < row; prevRow++) {
            int prevCol = queens[prevRow];

            // Same column
            if (prevCol == col) {
                return false;
            }

            // Same main diagonal (row - col constant)
            if ((prevRow - prevCol) == (row - col)) {
                return false;
            }

            // Same anti-diagonal (row + col constant)
            if ((prevRow + prevCol) == (row + col)) {
                return false;
            }
        }
        return true;
    }

    // Convert the queens array into a board representation
    private static List<String> buildBoard(int[] queens, int n) {
        List<String> board = new ArrayList<>();

        for (int row = 0; row < n; row++) {
            StringBuilder sb = new StringBuilder();
            for (int col = 0; col < n; col++) {
                if (queens[row] == col) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            board.add(sb.toString());
        }

        return board;
    }

    // Simple demo
    public static void main(String[] args) {
        int n = 4;
        List<List<String>> solutions = solveNQueens(n);

        System.out.println("Number of solutions for n = " + n + ": " + solutions.size());
        for (List<String> board : solutions) {
            for (String row : board) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}
```
