package com.leetcode.tree;

import com.leetcode.util.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LC_0199_Binary_Tree_Right_Side_View {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();

        // level order traverse and find the right most node;
        List<Integer> res =  new ArrayList<>();

        Queue<TreeNode> que = new ArrayDeque<>();
        que.add(root);

        while (!que.isEmpty()) {
            int size = que.size();
            while (size-- > 0) {
                TreeNode cur = que.remove();
                if (size == 0) {
                    // right most
                    res.add(cur.val);
                }
                if (cur.left != null) que.add(cur.left);
                if (cur.right != null) que.add(cur.right);
            }
        }
        return res;

    }
}
