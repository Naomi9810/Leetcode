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

package com.leetcode.linkedList;

public class LC_0082_Remove_Duplicates_from_Sorted_List_II {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        if (head == null || head.next == null) return head;

        ListNode cur = head;
        ListNode pre = dummy;

        while (cur != null) {
            // Move cur forward while next exists and values match
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }

            // If no duplicates were found, just move pre forward
            if (pre.next == cur) {
                pre = pre.next;
            } else {
                // Skip the duplicate group
                pre.next = cur.next;
            }

            cur = cur.next;
        }
        return dummy.next;
    }
}
