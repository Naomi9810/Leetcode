package com.goo.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Order has to from parent to child
 * <p>
 * A topdown approach classical bfs, use only has 4 options to determine next move.
 * <p>
 * Time Complexity: O(4 ^ N) - Worst case: We have 4 options each time we go next steps
 * <p>
 * Space complexity : O(4 ^ N)
 */
public class LC_365_Water_and_Jug_Problem {

  public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
    if (targetCapacity < 0 || targetCapacity > jug1Capacity + jug2Capacity) {
      return false;
    }

    Set<Integer> visited = new HashSet<>();
    Queue<Integer> queue = new LinkedList<>();
    queue.add(0);
    int[] options = new int [] {jug1Capacity, jug2Capacity, -jug1Capacity, -jug2Capacity};

    while(!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int cur = queue.poll();
        if (cur == targetCapacity) {
          return true;
        }
        for (int o: options) {
          int next = cur + o;
          if (next < 0 || next > jug1Capacity + jug2Capacity) {
            continue;
          }
          if (!visited.contains(next)) {
            queue.add(next);
            visited.add(next);
          }
        }
      }
    }
    return false;
  }
}
