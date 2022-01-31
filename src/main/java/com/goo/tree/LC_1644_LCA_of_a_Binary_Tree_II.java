/**
 * Created by Sijia on 1/24/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints: p and q may not exist in the tree
 * 1.  Two target nodes is not guaranteed to exist in the tree
 * 2.  A node is considered as descendant of itself.
 * we cannot instantly return the node we found here because we don't know if all m and n exist in the tree!
 * <p> 1. same logic as 1, just add a boolean / or counter
 * <p> 2. can't use same function need a helper
 * <p> 3. 注意一定要先call 完LCA 这样才能确保 两个boolean拿到update
 */

package com.goo.tree;

public class LC_1644_LCA_of_a_Binary_Tree_II {
    boolean findP = false;
    boolean findQ = false;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = LCA(root, p, q);
        return findP && findQ ? res : null;
    }

    public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;
        TreeNode left = LCA(root.left, p, q);
        TreeNode right = LCA(root.right, p, q);
        if (root == p) {
            findP = true;
            return root;
        }
        if (root == q) {
            findQ = true;
            return root;
        }
        return left == null ? right : right == null ? left : root;
    }
}
