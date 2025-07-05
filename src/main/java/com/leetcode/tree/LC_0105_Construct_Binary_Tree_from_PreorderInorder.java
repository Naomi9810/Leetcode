/**
 * Created by Sijia on 2/24/22
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

import java.util.Arrays;

public class LC_0105_Construct_Binary_Tree_from_PreorderInorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) return null;
        if (preorder.length == 1) return new TreeNode(preorder[0]);

        TreeNode root = new TreeNode(preorder[0]);
        int root_idx = 0;
        while (root_idx < inorder.length) {
            if (inorder[root_idx] == preorder[0]) {
                break;
            }
            root_idx++;
        }
        int len = preorder.length;
        // preorder length == inorder length
        TreeNode left = buildTree(Arrays.copyOfRange(preorder, 1, root_idx + 1), Arrays.copyOfRange(inorder, 0, root_idx));
        TreeNode right = buildTree(Arrays.copyOfRange(preorder, root_idx + 1, len), Arrays.copyOfRange(inorder, root_idx + 1, len));

        root.left = left;
        root.right = right;
        return root;
    }
}
