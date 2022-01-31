/**
 * Created by Sijia on 1/14/22
 * Revisited: 1/22/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints: recursion, if there is no child, then add to the list, remove the node, do it again.
 * LeafNode: height ==0  RootNode Depth ==0
 * https://i.stack.imgur.com/8yPi9.png
 * 如果从leave开始数 就是height 如果从root开始数 就是depth
 * level order traverse 是get相同depth的结果
 * <p> 1. https://leetcode.com/problems/find-leaves-of-binary-tree/discuss/83775/Java-backtracking-O(n)-time-O(n)-space-No-hashing!
 * <p> 2. group leaves of same level together and also to cut the tree. This is the exact role backtracking plays.
 * The helper function returns the level which is the distance from its furthest subtree leaf to root, which helps to identify which group the root belongs to
 * <p> 3.
 */

package com.goo.tree;

import java.util.ArrayList;
import java.util.List;

public class LC_0366_Find_Leaves_of_Binary_Tree {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        findLeavesHelper(root, res);
        return res;
    }

    private int findLeavesHelper(TreeNode root, List<List<Integer>> res) {
        if (root == null) {
            return -1;
        }
        int leftHeight = findLeavesHelper(root.left, res);
        int rightHeight = findLeavesHelper(root.right, res);
        int height = Math.max(leftHeight, rightHeight) + 1; // leaves height will be 0
        if (res.size() == height) { // 每个height 一个新的ArrayList 去存结果
            res.add(new ArrayList<>());
        }
        res.get(height).add(root.val);
        root.left = root.right = null;
        return height;
    }
}
