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

package com.goo.tree;

import java.util.*;

public class LC_0863_All_Nodes_Distance_K_in_Binary_Tree {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> graph = new HashMap<>();
        buildGraph(root, graph, null);

        Queue<TreeNode> que = new ArrayDeque<>();
        Set<TreeNode> visited = new HashSet<>();
        List<Integer> res = new ArrayList<>();

        que.offer(target);
        visited.add(target);
        int step = 0;

        while (!que.isEmpty()) {
            int size = que.size();
            while (size-- > 0) {
                TreeNode cur = que.poll();
                if (step == k) {
                    res.add(cur.val);
                }
                TreeNode parent = graph.get(cur);
                if (parent != null && !visited.contains(parent)) {
                    que.offer(parent);
                    visited.add(parent);
                }
                if (cur.left != null && !visited.contains(cur.left) ) {
                    que.offer(cur.left);
                    visited.add(cur.left);
                }
                if (cur.right != null && !visited.contains(cur.right) ) {
                    que.offer(cur.right);
                    visited.add(cur.right);
                }
            }
            step++;
        }

        return res;
    }

    private void buildGraph(TreeNode node, Map<TreeNode, TreeNode> graph, TreeNode parent) {
        if (node == null) return;
        if (parent != null) {
            graph.putIfAbsent(node, parent);
        }
        buildGraph(node.left, graph, node);
        buildGraph(node.right, graph, node);
    }
}
