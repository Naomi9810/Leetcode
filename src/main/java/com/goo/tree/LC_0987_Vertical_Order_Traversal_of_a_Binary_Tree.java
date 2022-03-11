/**
 * Created by Sijia on 3/6/22
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

public class LC_0987_Vertical_Order_Traversal_of_a_Binary_Tree {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        // level order traverse  map
        Map<Integer, PriorityQueue<int[]>> map = new HashMap<>(); //. col, depth and val
        Queue<Pair<TreeNode, Integer>> que = new ArrayDeque<>(); // node, col
        que.offer(new Pair<>(root, 0));

        int left = 0, right = 0;
        int depth = 0;

        while (!que.isEmpty()) {
            int size = que.size();
            while (size-- > 0) {
                Pair<TreeNode, Integer> p = que.poll();
                TreeNode cur = p.getKey();
                int pos = p.getValue();

                left = Math.min(left, pos);
                right = Math.max(right, pos);

                PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> {
                    if (a[0] != b[0]) {
                        return Integer.compare(a[0], b[0]);
                    } else {
                        return Integer.compare(a[1], b[1]);
                    }
                }); // compare depth first, then value

                map.putIfAbsent(pos, minHeap);
                map.get(pos).add(new int[] {depth, cur.val});

                if (cur.left != null) {
                    que.offer(new Pair<>(cur.left, pos - 1));
                }
                if (cur.right != null) {
                    que.offer(new Pair<>(cur.right, pos + 1));
                }
            }
            depth++;
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            PriorityQueue<int[]> minHeap = map.get(i);
            List<Integer> orderList = new ArrayList<>();
            while (!minHeap.isEmpty()) {
                orderList.add(minHeap.poll()[1]);
            }
            res.add(orderList);
        }
        return res;

    }
}
