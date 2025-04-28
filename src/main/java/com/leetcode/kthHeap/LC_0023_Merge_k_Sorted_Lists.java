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

}
