/**
 * Created by Sijia on 1/24/22
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

public class LC_1676_LCA_of_a_Binary_Tree_IV {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        if (root == null || nodes == null || nodes.length == 0) return null;
        if (nodes.length == 1) return nodes[0];
        TreeNode common = nodes[0];
        for (int i = 1; i < nodes.length; i++) {
            common = LCA(root, common, nodes[i]);
        }
        return common;
    }

    private TreeNode LCA(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null || a == null || b == null) return null;
        if (root == a) return a;
        if (root == b) return b;
        TreeNode left = LCA(root.left, a, b);
        TreeNode right = LCA(root.right, a, b);
        return left == null ? right : right == null ? left : root;
    }
}
