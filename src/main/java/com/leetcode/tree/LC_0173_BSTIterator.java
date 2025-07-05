package com.leetcode.tree;

import com.leetcode.util.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class LC_0173_BSTIterator {
    class BSTIterator {
        Queue<TreeNode> queue;

        public BSTIterator(TreeNode root) {
            queue = new ArrayDeque<>();
            putNodeInQueue(root, queue);
        }

        public int next() {
            TreeNode nxt = queue.remove();
            return nxt.val;
        }

        public boolean hasNext() {
            return !queue.isEmpty();
        }


        public void putNodeInQueue(TreeNode node, Queue<TreeNode> queue) {
            if (node == null) return;
            if (node.left != null) putNodeInQueue(node.left, queue);
            queue.add(node);
            if (node.right !=null) putNodeInQueue(node.right, queue);
        }
    }
}
