package com.leetcode.linkedList;

public class LC_0086_partition_List {
    public ListNode partition(ListNode head, int x) {
        // less than keep, greater than add to new head

        ListNode pHead = new ListNode(0);
        ListNode pointer = pHead;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode cur = head;
        ListNode pre = dummy;

        while (cur != null) {

            if (cur.val >= x) {
                pre.next = cur.next;
                pointer.next = new ListNode(cur.val);
                pointer = pointer.next;
            } else {
                pre = cur;

            }
            cur = cur.next;
        }
        // connect
        pre.next = pHead.next;
        return dummy.next;
    }
}
