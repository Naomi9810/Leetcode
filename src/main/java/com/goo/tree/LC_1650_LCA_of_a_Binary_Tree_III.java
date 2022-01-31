/**
 * Created by Sijia on 1/24/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints: 交叉法 两个node轮流
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.goo.tree;


public class LC_1650_LCA_of_a_Binary_Tree_III {
    public TreeNode lowestCommonAncestor(TreeNode p, TreeNode q) {
        if (p == null || q == null) return null;
        TreeNode node1 = p, node2 = q;
        while (node1 != node2) {
            node1 = node1 == null ? q : node1.parent;
            node2 = node2 == null ? p : node2.parent;
        }
        return node1;
    }
}
