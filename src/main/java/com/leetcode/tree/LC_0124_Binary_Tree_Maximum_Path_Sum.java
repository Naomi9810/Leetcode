/**
 * Created by Sijia on 2/15/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints: return 选边 只能选一边 但是 更新答案的时候 要算上全部的 helper function return's the max branch + node.val
 * 如果返回 加两边的值 就不能继续加upper branch 所以只返回一边的值 但是在内部每次进行比较得到结果
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.leetcode.tree;

import com.leetcode.util.TreeNode;

public class LC_0124_Binary_Tree_Maximum_Path_Sum {
    int res;

    public int maxPathSum(TreeNode root) {
        res = Integer.MIN_VALUE;
        maxPathSumHelper(root);
        return res;
    }

    private int maxPathSumHelper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = Math.max(maxPathSumHelper(node.left), 0);
        int right = Math.max(maxPathSumHelper(node.right), 0);

        res = Math.max(res, left + right + node.val);

        return node.val + Math.max(left, right);
    }

}
