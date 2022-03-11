/**
 * Created by Sijia on 3/8/22
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

import java.util.*;

public class LC_0399_Evaluate_Division {
    static final double NOT_FOUND = -1.00000;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        buildGraph(equations, values, graph);

        int size = queries.size();
        double[] res = new double[size];
        for (int i = 0; i< size; i++) {
            List<String> query = queries.get(i);
            String start = query.get(0), end = query.get(1);
            res[i] = compute(start, end, graph, new HashSet<>());
        }
        return res;
    }

    private void buildGraph(List<List<String>> equations, double[] values, Map<String, Map<String, Double>> graph) {
        for (int i = 0; i< values.length; i++) {
            List<String> eq = equations.get(i);
            String start = eq.get(0), end = eq.get(1);

            graph.putIfAbsent(start, new HashMap<>());
            graph.get(start).put(end, values[i]);

            graph.putIfAbsent(end, new HashMap<>());
            graph.get(end).put(start, 1/values[i]);
        }

    }

    private double compute(String start, String end, Map<String, Map<String, Double>> graph, Set<String> visited) {
        if (!graph.containsKey(start) || !graph.containsKey(end)) {
            return NOT_FOUND;
        }

        if (graph.get(start).containsKey(end)) {
            return graph.get(start).get(end);
        }

        visited.add(start);
        for (Map.Entry<String, Double> entry: graph.get(start).entrySet()) {
            String next = entry.getKey();
            if (!visited.contains(next)) {
                double res = compute(next, end, graph, visited);
                if (res != NOT_FOUND) {
                    return res * entry.getValue();
                }
            }
        }
        return NOT_FOUND;
    }
}
