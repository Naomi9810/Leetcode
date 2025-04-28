/**
 * Created by Sijia on 3/16/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.leetcode.tree;

import com.leetcode.util.TreeNode;

public class LC_0270_Closest_Binary_Search_Tree_Value {
    public int closestValue(TreeNode root, double target) {
        int val, closest = root.val;
        while (root != null) {
            val = root.val;
            closest = Math.abs(val - target) < Math.abs(closest - target) ? val : closest;
            root =  target < root.val ? root.left : root.right;
            //  因为只找最close的 所以只用考虑一边 就可以  不像如果找k个
        }
        return closest;
    }
}
