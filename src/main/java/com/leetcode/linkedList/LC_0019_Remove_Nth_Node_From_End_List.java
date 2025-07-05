package com.leetcode.linkedList;

public class LC_0019_Remove_Nth_Node_From_End_List {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return head;

        int total =0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            total++;
        }
        int step = total - n;

        if (step == 0) return head.next;
        cur = head;
        while (step-- > 1) {
            cur = cur.next;
        }

        if (cur.next == null) return head;

        ListNode remove = cur.next;
        cur.next = remove.next;
        return head;
    }
}
