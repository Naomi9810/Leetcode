/**
 * Created by Sijia on 2/23/22
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

public class LC_0019_Remove_Nth_Node_From_End_of_List {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && n-- > 0) {
            fast = fast.next;
        }
        if (fast == null) {
            return head.next; // 快慢指针问题，corner case 只有 remove的是head 直接返回head.next
        }

        while (slow != null && fast != null) {
            if (fast.next == null) {
                slow.next = slow.next.next;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return dummy.next;
    }
}
