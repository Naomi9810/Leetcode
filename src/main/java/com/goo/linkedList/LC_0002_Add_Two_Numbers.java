/**
 * Created by Sijia on 2/17/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints: linkedList 从二位数开始加 val = sum%10 carry == sum/10
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.goo.linkedList;

public class LC_0002_Add_Two_Numbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode res = dummy;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0: l2.val;
            int sum = x + y + carry;
            res.next = new ListNode(sum % 10);
            carry = sum / 10;
            res = res.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (carry > 0) {
            res.next = new ListNode(carry);
        }
        return dummy.next;

    }

}
