/**
 * Created by Sijia on 1/25/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints: https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/discuss/334583/Java-O(n)-Short-and-Simple-Recursion
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.leetcode.tree;

import com.leetcode.util.TreeNode;

import java.util.HashMap;

public class LC_1123_LCA_of_Deepest_Leaves {
    HashMap<TreeNode, Integer> heights = new HashMap<>();

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null || getHeight(root.left) == getHeight(root.right)) return root; // 左右子树🌲高度相同
        return lcaDeepestLeaves(getHeight(root.left) > getHeight(root.right)?root.left: root.right); // 总是找deeper的
    }

    private int getHeight(TreeNode node) {
        if (node == null) return -1;
        heights.putIfAbsent(node, Math.max(getHeight(node.left), getHeight(node.right)) + 1); // 左右子树🌲max + 1
        return heights.get(node);
    }

}
