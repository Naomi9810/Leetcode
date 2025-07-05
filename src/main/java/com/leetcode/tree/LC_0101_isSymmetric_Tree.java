package com.leetcode.tree;

import com.leetcode.util.TreeNode;

public class LC_0101_isSymmetric_Tree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetricHelper(root.left, root.right);

    }

    public boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return isSymmetricHelper(left.right, right.left) && isSymmetricHelper(left.left, right.right);

    }
}
