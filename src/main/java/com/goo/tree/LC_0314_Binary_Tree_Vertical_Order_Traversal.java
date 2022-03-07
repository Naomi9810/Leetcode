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
        // Dfs order is wrong,  need to do level order
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
        // level order traverse  map
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Pair<TreeNode, Integer>> que = new ArrayDeque<>();
        que.offer(new Pair<>(root, 0));

        int left = 0, right = 0;

        while (!que.isEmpty()) {
            int size = que.size();
            while (size-- > 0) {
                Pair<TreeNode, Integer> p = que.poll();
                TreeNode cur = p.getKey();
                int pos = p.getValue();

                left = Math.min(left, pos);
                right = Math.max(right, pos);

                map.putIfAbsent(pos, new ArrayList<>());
                map.get(pos).add(cur.val);

                if (cur.left != null) {
                    que.offer(new Pair<>(cur.left, pos - 1));
                }
                if (cur.right != null) {
                    que.offer(new Pair<>(cur.right, pos + 1));
                }
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = left; i <= right; i++) { //是连续的 所以可以一层层读取
            res.add(map.get(i));
        }
        return res;


    }


}
