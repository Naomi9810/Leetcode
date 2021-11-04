package com.goo.dfs;

/**
 * Time Complexity: O(M*N) - m = grid.length, n = grid[0].length.
 * <p>
 * Space Complexity: O(M*N) - m = grid.length, n = grid[0].length.
 * <p>
 * Hints:
 * <p> 1. base case 1 - water is true. edge - is false. </>
 * <p> 2. when land - 0 enter the search, search four direction until it hits the base case </>
 * <p> 3. don't forget mark visited 1 - water </>
 */
public class LC_1254_Number_of_Closed_Islands {

  public int closedIsland(int[][] grid) {
    int res = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 0 && dfs(grid, i, j)) {
          res++;
        }
      }
    }
    return res;
  }

  private boolean dfs(int[][] grid, int i, int j) {
    // true is a closed island, false is not
    if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
      return false; // surround by edge
    }
    if (grid[i][j] == 1) {
      return true; // surround by water
    }
    // mark visited
    grid[i][j] = 1;
    boolean up = dfs(grid, i - 1, j);
    boolean down = dfs(grid, i + 1, j);
    boolean left = dfs(grid, i, j - 1);
    boolean right = dfs(grid, i, j + 1);
    return up && down && left && right;
  }

}
