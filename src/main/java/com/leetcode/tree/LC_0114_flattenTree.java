package com.leetcode.tree;

import com.leetcode.util.TreeNode;

public class LC_0114_flattenTree {
    public void flatten(TreeNode root) {
        flattenHelper(root);

    }

    public TreeNode flattenHelper(TreeNode node) {
        //only return tail not head because root doesn't change
        if (node == null) return node;
        if (node.left == null && node.right == null) return node;

        TreeNode leftTail = flattenHelper(node.left); //  left side flatten
        TreeNode rightTail = flattenHelper(node.right);

        if (leftTail != null) {
            leftTail.right = node.right;
            node.right = node.left; // node.left 是左边扁平之后的head
            node.left = null;
        }

        // Return the tail node of the flattened subtree
        return rightTail != null ? rightTail : leftTail;
    }
}
