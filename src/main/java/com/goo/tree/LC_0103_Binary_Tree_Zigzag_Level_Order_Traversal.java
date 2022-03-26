/**
 * Created by Sijia on 3/23/22
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

public class LC_0103_Binary_Tree_Zigzag_Level_Order_Traversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> que = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        que.offer(root);
        boolean depthOdd = false;

        while (!que.isEmpty()) {
            int size = que.size();
            LinkedList<Integer> level = new LinkedList<>();
            while (size-- > 0) {
                TreeNode cur = que.poll();
                if (!depthOdd) {
                    level.addLast(cur.val);
                } else {
                    level.addFirst(cur.val);
                }
                if (cur.left != null) {
                    que.add(cur.left);
                }
                if (cur.right!= null) {
                    que.add(cur.right);
                }
            }
            res.add(level);
            depthOdd = !depthOdd;
        }
        return res;
    }
}
