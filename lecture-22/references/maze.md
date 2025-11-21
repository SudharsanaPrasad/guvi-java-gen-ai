### Problem Statement

You are given a 2D grid of integers:

* `0` means the cell is free.
* `-1` means the cell is blocked.

You start at the top-left cell `(0, 0)` and want to reach the bottom-right cell `(n - 1, m - 1)`.

You may move one step at a time in four directions:

* Up
* Down
* Left
* Right

You cannot:

* Move outside the grid.
* Step on a blocked cell.
* Visit the same cell more than once in the same path.

The task is to use backtracking to find one valid path from the start to the end, if it exists. The path can be represented as a sequence of grid coordinates.

---

### Sample Input

Grid (3 x 3):

```text
0   0   0
-1  -1  0
0   0   0
```

One valid path from `(0, 0)` to `(2, 2)` is:

`(0,0) -> (0,1) -> (0,2) -> (1,2) -> (2,2)`
(You do not need to print it in this exact format, only to return or print the sequence of cells.)

---

### Approach

This is a classic backtracking problem.

1. Start at cell `(0, 0)`.
2. At each step, check if the current cell is:

   * Inside the grid.
   * Not blocked.
   * Not already visited in the current path.
3. Mark the current cell as visited and add it to the current path.
4. If the current cell is the bottom-right cell, we have found a solution. Return true.
5. Otherwise, recursively try to move from the current cell in some fixed order of directions, for example:

   * Down
   * Right
   * Up
   * Left
6. If any recursive call returns true, propagate true upwards and keep the current path.
7. If none of the directions lead to a solution, then:

   * Remove the current cell from the path.
   * Mark it as not visited.
   * Return false to indicate that this route did not work.

The key idea is:

* "Choose" a cell (mark visited, add to path).
* "Explore" all possible moves from it.
* If none work, "unchoose" it (undo the mark and path) and go back to try other options.

Time complexity in the worst case is exponential, since in the worst case we may explore many combinations of cells. That is acceptable here because the primary goal is to understand backtracking.

---

### Pseudocode

```text
function findPath(grid):
    n = number of rows in grid
    m = number of columns in grid

    create visited[n][m], initialized to false
    create empty list path

    if explorePathFromCell(grid, 0, 0, visited, path, n, m) is true:
        print "Path found:"
        print path
    else:
        print "No path exists"


function explorePathFromCell(grid, row, col, visited, path, n, m):

    # 1. Boundary check
    if row < 0 or row >= n or col < 0 or col >= m:
        return false

    # 2. Blocked or already visited
    if grid[row][col] == -1 or visited[row][col] is true:
        return false

    # 3. Mark current cell and add to path
    visited[row][col] = true
    append (row, col) to path

    # 4. Check if goal is reached
    if row == n - 1 and col == m - 1:
        return true

    # 5. Explore all four directions

    # move down
    if explorePathFromCell(grid, row + 1, col, visited, path, n, m) is true:
        return true

    # move right
    if explorePathFromCell(grid, row, col + 1, visited, path, n, m) is true:
        return true

    # move up
    if explorePathFromCell(grid, row - 1, col, visited, path, n, m) is true:
        return true

    # move left
    if explorePathFromCell(grid, row, col - 1, visited, path, n, m) is true:
        return true

    # 6. Backtrack if none of the directions worked
    remove last element from path
    visited[row][col] = false

    return false
```

---

### Implementation

```java
import java.util.ArrayList;
import java.util.List;

public class MazePathBacktracking {

    // Simple class to represent a cell in the grid
    static class Cell {
        int row;
        int col;

        Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return "(" + row + ", " + col + ")";
        }
    }

    public static void main(String[] args) {
        // 0 represents a free cell, -1 represents a blocked cell
        int[][] grid = {
            {  0,  0,  0 },
            { -1, -1,  0 },
            {  0,  0,  0 }
        };

        List<Cell> path = findPath(grid);

        if (path == null) {
            System.out.println("No path exists.");
        } else {
            System.out.println("Path found:");
            for (Cell cell : path) {
                System.out.print(cell + " ");
            }
        }
    }

    // Tries to find one valid path from (0,0) to (n-1,m-1).
    // Returns the path as a list of cells, or null if no path exists.
    public static List<Cell> findPath(int[][] grid) {
        int n = grid.length;
        if (n == 0) {
            return null;
        }
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        List<Cell> path = new ArrayList<>();

        boolean hasPath = explorePathFromCell(grid, 0, 0, visited, path);

        if (hasPath) {
            return path;
        } else {
            return null;
        }
    }

    // Recursive backtracking function.
    private static boolean explorePathFromCell(int[][] grid,
                               int row,
                               int col,
                               boolean[][] visited,
                               List<Cell> path) {

        int n = grid.length;
        int m = grid[0].length;

        // 1. Check boundaries
        if (row < 0 || row >= n || col < 0 || col >= m) {
            return false;
        }

        // 2. Check if cell is blocked or already visited
        if (grid[row][col] == -1 || visited[row][col]) {
            return false;
        }

        // 3. Choose: mark current cell as part of the path
        visited[row][col] = true;
        path.add(new Cell(row, col));

        // 4. Check if we have reached the destination
        if (row == n - 1 && col == m - 1) {
            return true;
        }

        // 5. Explore neighbors: down, right, up, left

        // Move down
        if (explorePathFromCell(grid, row + 1, col, visited, path)) {
            return true;
        }

        // Move right
        if (explorePathFromCell(grid, row, col + 1, visited, path)) {
            return true;
        }

        // Move up
        if (explorePathFromCell(grid, row - 1, col, visited, path)) {
            return true;
        }

        // Move left
        if (explorePathFromCell(grid, row, col - 1, visited, path)) {
            return true;
        }

        // 6. Backtrack: undo the current move
        path.remove(path.size() - 1);
        visited[row][col] = false;

        return false;
    }
}
```
