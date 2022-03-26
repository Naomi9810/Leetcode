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

public class LC_1448_Count_Good_Nodes_in_Binary_Tree {
    int count = 0;
    public int goodNodes(TreeNode root) {
        countGood(root, Integer.MIN_VALUE);
        return count;
    }

    private void countGood(TreeNode node, int max) {
        if (node == null) return;
        if (node.val >= max) { // 当前node 大于最大的值
            count++;
            max = node.val;
        }
        countGood(node.left, max);
        countGood(node.right, max);
    }
}
