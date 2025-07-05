package com.leetcode.tree;

import com.leetcode.util.TreeNode;

import java.util.Arrays;

public class LC_0106_Construct_Binary_Tree_from_PostorderInorder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0) return null;
        if (inorder.length == 1) return new TreeNode(inorder[0]);

        int len = postorder.length;
        TreeNode root = new TreeNode(postorder[len-1]);

        // find the root index in inorder
        int i = 0;
        for (;i < len;i++) {
            if (inorder[i] == root.val){
                break;
            }
        }

        TreeNode leftNode = buildTree(Arrays.copyOfRange(inorder, 0, i), Arrays.copyOfRange(postorder, 0, i));
        TreeNode rightNode = buildTree(Arrays.copyOfRange(inorder, i+1, len), Arrays.copyOfRange(postorder, i, len-1));

        root.left = leftNode;
        root.right = rightNode;

        return root;
    }
}
