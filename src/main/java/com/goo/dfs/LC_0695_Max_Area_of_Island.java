package com.goo.dfs;

/**
 * Time Complexity: O(N) - grid size
 * <p>
 * Space Complexity: O(N) - grid size
 * <p>
 * Hints:
 * <p> 1. Use dfs to calculate area, island is 1 non island is zero
 */
public class LC_0695_Max_Area_of_Island {

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int max = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    max = Math.max(max, dfs(grid, i, j, visited));
                }
            }
        }
        return max;

    }

    private int dfs(int[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j]
                || grid[i][j] == 0) {
            return 0;
        } else {
            int area = 0;
            visited[i][j] = true;
            int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            for (int[] d : dir) {
                int i2 = i + d[0];
                int j2 = j + d[1];
                area += dfs(grid, i2, j2, visited);
            }
            return area;
        }
    }

}
