package com.goo.dijkstra;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Time Complexity: O(M*N log M*N) - m = row, n = col.
 * <p>
 * Space Complexity: O(M*N) - m = row, n = col.
 * <p>
 * Hints:
 * <p> 1. search find the shortest path from (0,0) to (row-1, col-1): Dijkstra, the total cost
 * will never go down when a new edge join the path </>
 * <p> 2. can also be solved by Binary search + DFS, giving a threshold, see if we can reach to the
 * target within that threshold
 * <p> 3. Not a dp question because the hiker can go 4 direction </>
 * </>
 */
public class LC_1631_Path_With_Minimum_Effort {

  public int minimumEffortPath(int[][] heights) {
    int row = heights.length;
    int col = heights[0].length;
    int[][] dist = new int[row][col];
    for (int i = 0; i < row; i++) {
      Arrays.fill(dist[i], Integer.MAX_VALUE);
    }
    // represent the minEffort to get to current point

    PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparing(a -> a[0]));
    minHeap.offer(new int[]{0, 0, 0});// distance, i, j

    while (!minHeap.isEmpty()) {
      int[] top = minHeap.poll();
      int cost = top[0];
      int i = top[1];
      int j = top[2];
      if (cost > dist[i][j]) {
        continue;
      }
      if (i == row - 1 && j == col - 1) {
        return cost; // reach the target point
      }

      int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
      for (int[] dir : directions) {
        int i2 = i + dir[0];
        int j2 = j + dir[1];
        if (i2 >= 0 && i2 < row && j2 >= 0 && j2 < col) {
          int cost2 = Math.max(cost,
              Math.abs(heights[i2][j2] - heights[i][j])); // the cost to go to (i2, j2)
          if (cost2 < dist[i2][j2]) {
            // replace the min cost with a cheaper option and put in queue
            dist[i2][j2] = cost2;
            minHeap.offer(new int[]{cost2, i2, j2});
          }
        }
      }
    }
    return 0;
  }
}
