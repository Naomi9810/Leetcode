/**
 * Created by Sijia on 12/9/21
 * Time Complexity:
 * <p> O(m*n)
 * Space Complexity:
 * <p> O(m*n)
 * Hints:
 * <p> 1. Edit distance is when there is no connection between those two cities, distance ++, the just fly to the destination and add the idx if possible
 * <p> 2. Need to establish a graph to represent the connection between nodes
 * <p> 3. https://leetcode.com/problems/the-most-similar-path-in-a-graph/discuss/1403591/Easy-Move-from-72.-Edit-Distance-with-follow-up-thinking-process
 * <p> ATL PEK LAX DXB HND -> Name
 * ATL
 * DXB
 * HND
 * LAX
 * \
 * <p>
 * </>
 */

package com.leetcode.dp;

import java.util.*;

public class LC_1548_The_Most_Similar_Path_in_a_Graph {
    public List<Integer> mostSimilar(int n, int[][] roads, String[] names, String[] targetPath) {
        boolean[][] graph = new boolean[n][n];
        for (int[] r : roads) {
            graph[r[0]][r[1]] = true;
            graph[r[1]][r[0]] = true;
        }

        int len = targetPath.length;
        int[][] dp = new int[len][n];
        int[][] pre = new int[len][n];

        for (int j = 0; j < n; j++) {
            dp[0][j] = names[j].equals(targetPath[0]) ? 0 : 1; // if it's start point then edit distance is 0 otherwise is 1
        }

        // fill the dp matrix:
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < n; j++) {
                int min = len + 1; // if target not in the names, then each target will have m+1 edit distance see example 2
                for (int k = 0; k < n; k++) {
                    if (graph[k][j]) {
                        if (dp[i - 1][k] < min) {
                            // k is the shortest distance, choose k
                            min = dp[i - 1][k];
                            pre[i][j] = k;
                        }
                    }
                }
                dp[i][j] = min + (names[j].equals(targetPath[i]) ? 0 : 1);
            }
        }

        // pick the smallest from the last row:
        int min = len + 1, stop = 0;
        for (int j = 0; j < n; j++) {
            if (dp[len - 1][j] < min) {
                min = dp[len - 1][j];
                stop = j;
            }
        }
        List<Integer> res = new ArrayList<>();
        res.add(stop);

        for (int i = len - 1; i > 0; i--) {
            // find each stop's pre stop and add to res:
            stop = pre[i][stop];
            res.add(stop);
        }
        Collections.reverse(res);
        return res;
    }
}


