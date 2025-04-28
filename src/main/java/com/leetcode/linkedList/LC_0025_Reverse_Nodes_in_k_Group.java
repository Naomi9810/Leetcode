/**
 * Created by Sijia on 3/20/22
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

public class LC_0025_Reverse_Nodes_in_k_Group {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        int count = 0;
        ListNode cur = head;
        while (cur != null && count < k) {
            count++;
            cur = cur.next;
        }
        if (count == k) {
            cur = reverseKGroup(cur, k); //  cur is the classical pre because the end of listNode is null
            while (count-- > 0) {
                ListNode next = head.next;
                head.next = cur;
                cur = head;
                head = next;
            }
            head = cur;
        }
        return head;




    }
}
