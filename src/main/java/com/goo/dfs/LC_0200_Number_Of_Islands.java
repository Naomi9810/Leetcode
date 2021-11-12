package com.goo.dfs;

/**
 * Time Complexity: O(N) - grid size
 *  * <p>
 *  * Space Complexity: O(N) - grid size
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */
public class LC_0200_Number_Of_Islands {

  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }
    int count = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == '1') {
          dfs(grid, i, j);
          count++;
        }
      }
    }
    return count;


  }

  private void dfs(char[][] grid, int i, int j) {
    if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
      return;
    }
    grid[i][j] = '0'; // marked as visited:
    int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    for (int[] d : dir) {
        int i2 = i + d[0];
        int j2 = j + d[1];
        dfs(grid, i2, j2);
    }
  }

}
