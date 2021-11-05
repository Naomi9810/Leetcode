package com.goo.dijkstra;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Time Complexity: O(M*N log M*N) - m = row, n = col.
 * <p>
 * Space Complexity: O(M*N) - m = row, n = col.
 * <p>
 * Hints:
 * <p> 1. search find the max path from (0,0) to (row-1, col-1): Dijkstra, the total cost
 * will never go down when a new edge join the path and then find the min value during in this route
 * 2. use a priority queue to choose the next step with the maximum value. Keep track of the min
 * value along the path </>
 */
public class LC_1102_Path_With_Maximum_Minimum_Value {

  public int maximumMinimumPath(int[][] grid) {
    int row = grid.length;
    int col = grid[0].length;
    boolean[][] visited = new boolean[row][col];

    PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
    // keep track of the maximum min in the path
    maxHeap.offer(new int[]{grid[0][0], 0, 0}); // cost, i, j
    int min = grid[0][0];

    while (!maxHeap.isEmpty()) {
      int[] cur = maxHeap.poll();
      min = cur[0];
      int i = cur[1];
      int j = cur[2];
      visited[i][j] = true;

      if (i == row - 1 && j == col - 1) {
        return min; // reach the target point
      }

      int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
      for (int[] dir : directions) {
        int i2 = i + dir[0];
        int j2 = j + dir[1];

        if (i2 >= 0 && i2 < row && j2 >= 0 && j2 < col && !visited[i2][j2]) {
          maxHeap.offer(new int[]{Math.min(grid[i2][j2], min), i2, j2});
        }
      }
    }
    return min;
  }
}
