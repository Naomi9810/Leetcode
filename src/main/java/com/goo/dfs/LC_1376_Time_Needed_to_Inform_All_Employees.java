package com.goo.dfs;

import java.util.*;

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
    Map<Integer,List<Integer>> map = new HashMap<>();

    for (int i = 0; i < manager.length; i++) {
      map.putIfAbsent(manager[i], new ArrayList<>());
      map.get(manager[i]).add(i);
    }
    return getInformTime(headID, map, informTime);
  }

  private int getInformTime(int cur, Map<Integer,List<Integer>> map, int[] informTime) {
    int time = informTime[cur];
    List<Integer> subList = map.get(cur);
    int subTime = 0;
    if (subList != null) {
      for (int sub: subList) {
        subTime = Math.max(subTime, getInformTime(sub, map, informTime));
      }
      time += subTime;
    }
    return time;
  }
}
