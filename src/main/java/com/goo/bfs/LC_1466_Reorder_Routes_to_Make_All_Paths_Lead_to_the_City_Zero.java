/**
 * Created by Sijia on 1/13/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints: dfs/ bfs or union find
 * <p> 1.  bfs 建立双向的graph 用set记录原有的direction 如果set里面没有 则res++
 * <p> 2.  pure set solution TLE
 * <p> 3.
 */

package com.goo.bfs;

import java.util.HashSet;
import java.util.Set;

public class LC_1466_Reorder_Routes_to_Make_All_Paths_Lead_to_the_City_Zero {
    public int minReorder(int n, int[][] connections) {
        // corner case:
        if (connections == null || connections.length == 0 || connections[0].length == 0) return 0;
        int res = 0;
        Set<Integer> set = new HashSet<>();
        set.add(0); // add as destination
        while (set.size() != n) {
            for (int i = 0; i < connections.length; i++) {
                int from = connections[i][0];
                int to = connections[i][1];
                if (!set.contains(to) && set.contains(from)) { // need to reorder
                    res++;
                    set.add(to);
                } else if (set.contains(to) && !set.contains(from)) { // no need to change, just add from
                    set.add(from);
                }
            }
        }
        return res;
    }
}
