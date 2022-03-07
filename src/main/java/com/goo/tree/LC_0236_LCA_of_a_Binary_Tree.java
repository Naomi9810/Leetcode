/**
 * Created by Sijia on 1/23/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints: LCA 思路
 * 1. 如果三者有一个是null 则返回null
 * 2. 左右各 run
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.goo.tree;

public class LC_0236_LCA_of_a_Binary_Tree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;
        if (root == p || root == q) return root; // 返回null 说明没找到

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right; // 左边tree 没有任何一个node
        else if (right == null) return left; // 右边tree 没有任何一个node
        else return root; // 左右tree各一个
    }
}
