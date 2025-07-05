package com.leetcode.tree;

import com.leetcode.util.TreeNode;

public class LC_0222_Count_Complete_Tree_Nodes {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        int leftDepth = getDepth(root, true);
        int rightDepth = getDepth(root, false);

        if (leftDepth == rightDepth) {
            // Tree is perfect: 2^depth - 1 nodes
            return (1 << leftDepth) - 1;
        }

        // Otherwise, recursively count
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int getDepth(TreeNode node, boolean left) {
        int depth = 0;
        while (node != null) {
            node = left ? node.left : node.right;
            depth++;
        }
        return depth;
    }
}
