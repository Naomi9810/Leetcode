/**
 * Created by Sijia on 3/17/22
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

import java.util.Arrays;

public class LC_0108_Convert_Sorted_Array_to_Binary_Search_Tree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        if (nums.length == 1) return new TreeNode(nums[0]);
        int len = nums.length;
        TreeNode root = new TreeNode(nums[len/2]);
        TreeNode left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, len/2));
        TreeNode right =  sortedArrayToBST(Arrays.copyOfRange(nums, len/2 + 1, len));
        root.left = left;
        root.right = right;
        return root;
    }
}
