/**
 * Created by Sijia on 3/27/22
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

import com.leetcode.util.Node;

public class LC_0510_Inorder_Successor_in_BST_II {
    public Node inorderSuccessor(Node node) {
        // the successor is somewhere lower in the right subtree
        // 向右一步一直左
        if (node.right != null) {
            node = node.right;
            while (node.left != null) node = node.left;
            return node;
        }

        // the successor is somewhere upper in the tree 第一个左孩子的parent
        while (node.parent != null && node == node.parent.right) node = node.parent;
        return node.parent;
    }
}
