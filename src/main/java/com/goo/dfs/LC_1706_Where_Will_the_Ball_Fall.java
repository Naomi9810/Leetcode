package com.goo.dfs;

/**
 * Time Complexity: O(M*N) - m = grid.length, n = grid[0].length.
 * <p>
 * Space Complexity: O(N) n = grid[0].length.
 * <p>
 * Hints:
 * <p> 1. encounter the triangle shape will get stuck </>
 * <p> 2. what form a triangle shape:
 * <p> grid[i][j] = 1 && grid [i][j+1] = -1
 * <p> grid[i][j] = -1 && grid[i][j-1] = 1
 * <p> if not a triangle：
 * <p> grid[i][j] = 1 pass, then i++, j++ -  go right side
 * <p> grid[i][j] = -1 pass, then i++, j-1 - go left side
 * </>
 */
public class LC_1706_Where_Will_the_Ball_Fall {

  public int[] findBall(int[][] grid) {
    int[] res = new int[grid[0].length];
    for (int j = 0; j < grid[0].length; j++) {
      res[j] = fall(grid, 0, j);
    }
    return res;
  }

  private int fall(int[][] grid, int i, int j) {
    int row = grid.length;
    int col = grid[0].length;
    while (i < row) {
      if (grid[i][j] == 1) {
        if (j + 1 == col || grid[i][j + 1] == -1) {
          return -1;
        }
        i++;
        j++;
      } else {
        if (j - 1 < 0 || grid[i][j - 1] == 1) {
          return -1;
        }
        i++;
        j--;
      }
    }
    return j;
  }
}
