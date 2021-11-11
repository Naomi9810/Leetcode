package com.goo.bfs;

import java.util.LinkedList;
import java.util.Queue;


/**
 * Time Complexity: O(N) N is the grid size, first DFS then BFS
 * <p>
 * Space Complexity: O(M) - N is grid size
 * <p>
 * Hints:
 * <p> 1. First use DFS to reveal the target and explore the board, so we got the base
 * <p> 2. Second use BFS to find the shortest path, use {m, m} as the target point
 * <p> 3. Base board should be 2*m+1
 */
public class LC_1778_Shortest_Path_in_a_Hidden_Grid {

  private static final int[][] DIR = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
  private static final char[] FORWARD = {'U', 'D', 'L', 'R'};
  private static final char[] BACKWARD = {'D', 'U', 'R', 'L'};

  private static final int BLOCKED = -1;
  private static final int UNEXPLORED = 0;
  private static final int PATH = 1;
  private static final int TARGET = 2;

  public int findShortestPath(GridMaster master) {
    int m = 500;
    int[][] base = new int[m * 2 + 1][m * 2 + 1];
    // use {m, m} as the start point
    int[] start = new int[]{m, m};
    dfsFindTarget(master, base, start);
    base[m][m] = BLOCKED; // use blocked as visited in bfs, this is the start point
    return bfsFindShortestPath(base, start);
  }


  private void dfsFindTarget(GridMaster master, int[][] base, int[] cur) {
    int i = cur[0];
    int j = cur[1];
    if (base[i][j] != UNEXPLORED) {
      return;
    }
    if (master.isTarget()) {
      base[i][j] = TARGET;
    } else {
      base[i][j] = PATH;
    }

    for (int d = 0; d < 4; d++) {
      int i2 = i + DIR[d][0];
      int j2 = j + DIR[d][1];
      char forward = FORWARD[d];
      char backward = BACKWARD[d];

      if (i2 < 0 || j2 < 0 || i2 >= base.length && j2 >= base.length) {
        continue;
      } else if (!master.canMove(forward)) {
        base[i2][j2] = BLOCKED;
      } else {
        master.move(forward);
        dfsFindTarget(master, base, new int[]{i2, j2});
        master.move(backward);
      }
    }
  }


  private int bfsFindShortestPath(int[][] base, int[] start) {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(start);
    int dis = 0;

    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        int[] cur = queue.poll();
        int i = cur[0];
        int j = cur[1];
        for (int d = 0; d < 4; d++) {
          int i2 = i + DIR[d][0];
          int j2 = j + DIR[d][1];
          if (base[i2][j2] == TARGET) {
            return dis + 1;
          } else if (base[i2][j2] == BLOCKED) {
            continue;
          } else {
            queue.offer(new int[]{i2, j2});
            base[i2][j2] = BLOCKED;
          }
        }
      }
      dis++;
    }
    return -1;
  }
}
