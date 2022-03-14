/**
 * Created by Sijia on 3/12/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.goo.dfs;

import java.util.ArrayList;
import java.util.List;

public class LC_0797_All_Paths_From_Source_to_Target {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        if (graph == null || graph.length == 0 || graph[0].length == 0 ) return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);

        dfs(graph, 0, res, path);
        return res;
    }

    private void dfs(int[][] graph, int i, List<List<Integer>> res, List<Integer> path) {
        // base case:
        if (i == graph.length - 1) {
            res.add(new ArrayList<>(path)); //一定要加 new的
            return;
        }
        for (int node: graph[i]) {
            path.add(node);
            dfs(graph, node, res, path);
            path.remove(path.size()-1);

        }
    }
}
