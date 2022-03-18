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

public class LC_0160_Intersection_of_Two_Linked_Lists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode a = headA, b = headB;
        while (a != b) {
            a = a == null? headB: a.next; // 必须用一个新的node 如果是空就回到起点 要保留起点的指针
            b = b == null? headA: b.next;
        }
        return a;
    }

}
