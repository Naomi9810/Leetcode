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
            if (cur.next != null && cur.next.val == cur.val) {  // if 先进入循环再 while 找到正确的node
                while (cur.next != null && cur.next.val == cur.val) {
                    cur = cur.next;
                }
                // keep 一个pre指针
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
