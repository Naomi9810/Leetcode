/**
 * Created by Sijia on 4/27/22
 * Time Complexity:
 * Space Complexity:
 * Hints:  一分为二，root 跟target 比较， 如果root比target <= 那么root.left 必定在leftGroup，需要split root.right，
 * splited的也有两部分，leftGroup 需要安装在root.right
 * 然后 root变为 splited的leftRoot 然后返回 splited 右边也是如此
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.goo.tree;

public class LC_0776_Split_BST {
    public TreeNode[] splitBST(TreeNode root, int target) {
        if (root == null) {
            return new TreeNode[] {null, null};
        } else if (root.val <= target) {
            TreeNode[] splited = splitBST(root.right, target);
            root.right = splited[0];
            splited[0] = root;
            return splited;
        } else {
            TreeNode[] splited = splitBST(root.left, target);
            root.left = splited[1];
            splited[1] = root;
            return splited;
        }
    }
}
