/**
 * Created by Sijia on 3/12/22
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

import java.util.ArrayDeque;
import java.util.Deque;

public class LC_0117_Populating_Next_Right_Pointers_in_Each_NodeII {
    /*Level order travers
     keep a pre Node pointer*/
    public Node connect(Node root) {
        // validation

        if (root == null) return root;
        Deque<Node> que = new ArrayDeque<>();
        que.offer(root);
        Node pre = null;

        while (!que.isEmpty()) {
            int size = que.size();
            while (size-- > 0) {
                Node cur = que.poll();
                if (size == 0) {
                    cur.next = null;
                }
                if (pre != null) {
                    pre.next = cur;
                }
                pre = cur;

                if (cur.left != null) {
                    que.offer(cur.left);
                }
                if (cur.right != null) {
                    que.offer(cur.right);
                }
            }
            pre = null;
        }
        return root;

    }
}
