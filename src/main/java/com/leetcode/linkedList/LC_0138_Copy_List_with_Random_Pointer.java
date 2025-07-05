package com.leetcode.linkedList;

import java.util.HashMap;
import java.util.Map;

public class LC_0138_Copy_List_with_Random_Pointer {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Map<Node, Node> map = new HashMap<>();

        Node dummy = new Node(0), prev = dummy;

        for (Node cur = head; cur != null; cur = cur.next) {
            // Get or create the clone for cur
            Node clone = map.computeIfAbsent(cur, k -> new Node(k.val));
            prev.next = clone;

            // If there's a random pointer, get/create its clone too
            if (cur.random != null) {
                clone.random = map.computeIfAbsent(cur.random, k -> new Node(k.val));
            }

            prev = clone;
        }

        return dummy.next;

    }
}
