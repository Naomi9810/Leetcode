/**
 * Created by Sijia on 3/16/22
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
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LC_0272_Closest_Binary_Search_Tree_Value_II {
    // 多种方法 用priority queue / quickSelect / 最优办法是 用inOrder traverse 遍历 deque 做sliding window
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        inOrder(root, deque, target, k);
        List<Integer> res =  new ArrayList<>();
        while (!deque.isEmpty()) {
            res.add(deque.poll());
        }
        return res;
    }
    private void inOrder(TreeNode node, Deque<Integer> deque, double target, int k) {
        if (node == null) return;
        inOrder(node.left, deque, target, k);
        deque.add(node.val);
        if (deque.size() > k) {
            int first = deque.peekFirst(), last = deque.peekLast();
            if (Math.abs(first - target)  > Math.abs(last - target) ) {
                deque.pollFirst();
            } else {
                deque.pollLast();
            }
        }
        inOrder(node.right, deque, target, k);
    }
}
