/**
 * Created by Sijia on 3/9/22
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

public class LC_0099_Recover_Binary_Search_Tree {
    //  compare each node with its next one
    // 从左到右的 inOrder pre >= cur 第一个要换的是 pre 然后 pre <=cur 第二个要换的是 cur
    private TreeNode first, second, pre;

    public void recoverTree(TreeNode root) {
        if (root == null) return;
        first = null;
        second = null;
        pre = null;
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    public void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);

        if (first == null && (pre == null || pre.val >= node.val)) {
            first = pre;
        }

        if (first != null && pre.val >= node.val) {
            second = node;
        }

        pre = node;
        inorder(node.right);

    }
}
