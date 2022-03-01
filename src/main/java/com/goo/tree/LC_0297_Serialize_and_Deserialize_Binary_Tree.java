/**
 * Created by Sijia on 2/26/22
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

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class LC_0297_Serialize_and_Deserialize_Binary_Tree {
    private static final String DIVIDER = ",";
    private static final String NN = "X";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NN).append(DIVIDER);
        } else {
            sb.append(node.val).append(DIVIDER);
            buildString(node.left, sb);
            buildString(node.right, sb);
        }
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> nodes = new ArrayDeque<>(Arrays.asList(data.split(DIVIDER)));
        return buildTree(nodes);
    }

    private TreeNode buildTree(Deque<String> nodes) {
        String val = nodes.poll();
        if (val == null || val.equals(NN)) return null;
        else {
            TreeNode node = new TreeNode(Integer.parseInt(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }
}
