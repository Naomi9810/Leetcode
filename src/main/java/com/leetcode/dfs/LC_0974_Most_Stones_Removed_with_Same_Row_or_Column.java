package com.leetcode.dfs;


import java.util.HashSet;
import java.util.Set;

/**
 * Time Complexity: O(N^2) N ia # of stone
 * <p>
 * Space Complexity: O(N)
 * <p>
 * Hints:
 * <p> 1.  can use dfs to search four direction, number of islands - not search 4 direction but
 * search same i, j
 * <p> 2.  can use union find to find the size
 * <p> 3.
 */
public class LC_0974_Most_Stones_Removed_with_Same_Row_or_Column {

    public int removeStones(int[][] stones) {
        if (stones.length == 1) {
            return 0;
        }
        Set<int[]> visited = new HashSet<>();
        int numOfIslands = 0;
        for (int[] stone : stones) {
            if (!visited.contains(stone)) {
                dfs(stone, stones, visited);
                numOfIslands++;
            }
        }
        return stones.length - numOfIslands;

    }

    // search same i, j
    private void dfs(int[] stone, int[][] stones, Set<int[]> visited) {
        visited.add(stone);
        int i = stone[0];
        int j = stone[1];
        for (int[] nextStone : stones) {
            int i2 = nextStone[0];
            int j2 = nextStone[1];
            if (!visited.contains(nextStone) && (i2 == i || j2 == j)) {
                dfs(nextStone, stones, visited);
            }
        }
    }
}

/**
 * Union find code:
 * Map<Integer, Integer> f = new HashMap<>();
 * int islands = 0;
 * <p>
 * public int removeStones(int[][] stones) {
 * for (int i = 0; i < stones.length; ++i) {
 * union(stones[i][0], ~stones[i][1]); // ?
 * }
 * return stones.length - islands;
 * }
 * <p>
 * public int find(int x) {
 * if (f.putIfAbsent(x, x) == null) {
 * islands++;
 * }
 * if (x != f.get(x)) {
 * f.put(x, find(f.get(x)));
 * }
 * return f.get(x);
 * }
 * <p>
 * public void union(int x, int y) {
 * x = find(x);
 * y = find(y);
 * if (x != y) {
 * f.put(x, y);
 * islands--;
 * }
 * }
 */

