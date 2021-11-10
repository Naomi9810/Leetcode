package com.goo.dfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Time Complexity: O(N) .
 * <p>
 * Space Complexity: O(N) - N is the # of the manager count
 * <p>
 * Hints:
 * <p> 1. Topdown DFS time = informTime[manager] + manager's employee
 * <p> 2. enter: not visited = 0, if already visited directly return mem value </>
 */
public class LC_1376_Time_Needed_to_Inform_All_Employees {

  public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
    Map<Integer, List<Integer>> managerToIdx = new HashMap<>();
    for (int i = 0; i < manager.length; i++) {
      // loop through the manager list
      managerToIdx.putIfAbsent(manager[i], new LinkedList<>());
      managerToIdx.get(manager[i]).add(i);
    }
    return calculateInformTime(headID, managerToIdx, informTime);


  }

  private int calculateInformTime(int manager, Map<Integer, List<Integer>> managerToIdx,
      int[] informTime) {
    int max = 0;
    if (!managerToIdx.containsKey(manager)) {
      return max;
    } else {
      List<Integer> subIdx = managerToIdx.get(manager);
      for (int sub: subIdx) {
        max = Math.max(max, calculateInformTime(sub, managerToIdx, informTime));
      }
      return max + informTime[manager];
    }
  }
}
