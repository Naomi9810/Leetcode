/**
 * Created by Sijia on 2/21/22
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

import javafx.util.Pair;

import java.util.*;

public class LC_0314_Binary_Tree_Vertical_Order_Traversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        // Dfs order is wrong, need to sort by depth
//        Map<Integer, List<int[]>> map = new TreeMap<>();
//        dfs(root, 0, 0, map);
//        List<List<Integer>> res = new ArrayList<>();
//        for (List<int[]> list: map.values()) {
//            list.sort((a, b) -> a[0] - b[0]);
//            List<Integer> col = new ArrayList<>();
//            for (int[] node : list)
//                col.add(node[1]);
//            res.add(col);
//        }
//        return res;
//    }
//
//    public void dfs(TreeNode root, int depth, int col, Map<Integer, List<int[]>> map) {
//        if (root == null)
//            return;
//        map.putIfAbsent(col, new ArrayList<>());
//        map.get(col).add(new int[]{depth, root.val});
//        dfs(root.left, depth + 1, col - 1, map);
//        dfs(root.right, depth + 1, col + 1, map);

        if (root == null) return new ArrayList<>();

        Queue<Pair<Integer, TreeNode>> que = new ArrayDeque<>();  // Pair<col, TreeNode>
        Map<Integer, List<Integer>> map = new TreeMap<>();

        que.offer(new Pair<>(0, root));
        map.putIfAbsent(0, new ArrayList<>());
        map.get(0).add(root.val);

        while (!que.isEmpty()) {
            Pair<Integer, TreeNode> cur = que.poll();
            int col = cur.getKey();
            TreeNode curNode = cur.getValue();

            if (curNode.left != null) {
                que.offer(new Pair<>(col - 1, curNode.left));
                map.putIfAbsent(col - 1, new ArrayList<>());
                map.get(col - 1).add(curNode.left.val);
            }

            if (curNode.right != null) {
                que.offer(new Pair<>(col + 1, curNode.right));
                map.putIfAbsent(col + 1, new ArrayList<>());
                map.get(col + 1).add(curNode.right.val);
            }
        }

        return new ArrayList<>(map.values());
    }


}
