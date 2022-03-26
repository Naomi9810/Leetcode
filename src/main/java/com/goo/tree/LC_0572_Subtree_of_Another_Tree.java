/**
 * Created by Sijia on 3/19/22
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

public class LC_0572_Subtree_of_Another_Tree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if (subRoot == null) return true;
        if (isSameTree(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);

    }
    public boolean isSameTree(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) return true;
        if (n1 == null || n2 == null) return false;
        if (n1.val != n2.val) return false;
        return isSameTree(n1.left, n2.left) && isSameTree(n1.right, n2.right);
    }
}
