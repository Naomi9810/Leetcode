/**
 * Created by Sijia on 2/21/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>   https://leetcode.com/problems/merge-k-sorted-lists/discuss/429518/JAVA-SUMMARY-of-all-solutions-(B-F-minPQ-Divide-And-Conquer)
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.leetcode.kthHeap;

import com.leetcode.linkedList.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class LC_0023_Merge_k_Sorted_Lists {
    public ListNode mergeKLists(ListNode[] lists) {
        // N is the total #Node
        // sort: NlogN
        // Priority Queue: NlogK
        // merge2 divide and Conquer merge two 的两种方法 iteration = dummy recursion
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        for (ListNode node: lists) {
            if (node != null) {
                pq.add(node);
            }

        }
        ListNode node = new ListNode(0);
        ListNode dummy = node;
        while (!pq.isEmpty()) {
            ListNode cur = pq.poll();
            node.next = cur;
            if (cur.next != null) {
                pq.add(cur.next);
            }
            node = node.next;
        }
        return dummy.next;
    }


    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        if (lists.length == 1)
            return lists[0];
        if (lists.length == 2)
            return merge2Lists(lists[0], lists[1]);

        List<ListNode> merged = new ArrayList<>();
        for (int i = 0; i < lists.length; i = i + 2) {
            if (i + 1 < lists.length) {
                merged.add(merge2Lists(lists[i], lists[i + 1]));
            } else {
                // Odd number of lists: add the last one as-is
                merged.add(lists[i]);
            }
        }
        return mergeKLists(merged.toArray(new ListNode[0]));

    }

    public ListNode merge2Lists(ListNode n1, ListNode n2) {
        if (n1 == null && n2 == null)
            return null;
        if (n1 == null)
            return n2;
        if (n2 == null)
            return n1;

        if (n1.val <= n2.val) {
            ListNode nxt = n1.next;
            n1.next = merge2Lists(nxt, n2);
            return n1;
        } else {
            ListNode nxt = n2.next;
            n2.next = merge2Lists(n1, nxt);
            return n2;
        }
    }

}
