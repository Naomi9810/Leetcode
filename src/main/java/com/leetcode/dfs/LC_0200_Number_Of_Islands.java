package com.leetcode.dfs;

/**
 * Time Complexity: O(N) - grid size
 * * <p>
 * * Space Complexity: O(N) - grid size
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */
public class LC_0200_Number_Of_Islands {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
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
        grid[i][j] = '0';
        int[][] dirs = new int[][] {{-1,0},{1, 0},{0, 1},{0, -1}};

        for (int[] dir: dirs) {
            int i2 = i + dir[0];
            int j2 = j + dir[1];
            if (i2 < 0 || j2 < 0 || i2 >= grid.length || j2 >= grid[0].length || grid[i2][j2] == '0') continue;
            dfs(grid, i2, j2);
        }
    }


}
