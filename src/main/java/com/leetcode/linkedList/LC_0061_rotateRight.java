package com.leetcode.linkedList;

public class LC_0061_rotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null ) return head;

        // find the total
        int total = 0;
        ListNode cur = head;
        while (cur !=null) {
            cur = cur.next;
            total++;
        }

        if (k % total == 0) return head;

        int rotate = k % total;
        int step = total - rotate;

        // find the new head;
        ListNode newHead = head;
        ListNode pre = null;
        while (step-- > 0) {
            pre = newHead;
            newHead = newHead.next;
        }
        pre.next = null; // end
        ListNode connect = newHead;
        while (connect.next != null) {
            connect = connect.next;
        }
        connect.next = head;
        return newHead;
    }
}
