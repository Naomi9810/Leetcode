package com.goo.kthHeap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Time Complexity:
 * <p> O(N *  log(N))
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1. build map <node, path to root></> brute force will exceed time limit
 * <p> 2. optimization -> binary lifting
 * <p> 3. https://www.youtube.com/watch?v=oib-XsjFa-M
 * https://leetcode.com/problems/kth-ancestor-of-a-tree-node/discuss/686591/Java-Clean-(Binary-Lifting)
 * The idea is not find parent one by one, we first jump to the nearest pre-compute node. For
 * example, if we want to find 9th parent, we first jump to 8th parent node, which we already
 * pre-compute, then we call parent[] only one time to find the 9th parent.
 */
public class LC_1483_Kth_Ancestor_of_a_Tree_Node {

  Map<Integer, List<Integer>> parentToNode = new HashMap<>();
  Integer[][] mem;

  public void TreeAncestor(int n, int[] parent) {
    this.mem = new Integer[n][30];
    for (int i = 0; i < n; i++) {
      int parentNode = parent[i];
      parentToNode.computeIfAbsent(parentNode, value -> new ArrayList<>()).add(i);
      if (i > 0) mem[i][0] = parent[i];    //memo[i][j], i is currentNode, j is jth parent from curNode
    }
    dfs(0);
  }

  private void dfs(int cur) {
    for (int i = 1; mem[cur][i - 1] != null; i++) {
      int next = mem[cur][i - 1];
      mem[cur][i] = mem[next][i - 1];
    }
    for (int child : parentToNode.getOrDefault(cur, new ArrayList<>()))
      dfs(child);
  }

  public int getKthAncestor(int node, int k) {
    for (int i = 0; k > 0; i++) {
      if (k % 2 == 1) {
        if (mem[node][i] == null) return -1;
        node = mem[node][i];
      }
      k /= 2;
    }
    return node;
  }
}
