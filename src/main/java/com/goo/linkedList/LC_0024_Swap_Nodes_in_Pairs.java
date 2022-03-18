/**
 * Created by Sijia on 3/17/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.goo.linkedList;

public class LC_0024_Swap_Nodes_in_Pairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode sec = head.next;
        head.next = swapPairs(sec.next);
        sec.next = head;
        return sec;
    }
}
