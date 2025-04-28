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

package com.leetcode.tree;

import com.leetcode.util.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class LC_0297_Serialize_and_Deserialize_Binary_Tree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> que = new ArrayDeque<>(Arrays.asList(data.split(",")));
        TreeNode root = buildTree(que);
        return root;
    }

    public void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("#").append(",");
        } else {
            sb.append(node.val).append(",");
            buildString(node.left, sb);
            buildString(node.right, sb);
        }
    }

    public TreeNode buildTree(Queue<String> que) {
        String cur = que.poll();
        if (cur == null || "#".equals(cur)) return null;
        TreeNode node = new TreeNode(Integer.parseInt(cur));
        node.left = buildTree(que);
        node.right = buildTree(que);
        return node;
    }
}
