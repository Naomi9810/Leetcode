/**
 * Created by Sijia on 1/20/22
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

/**
 * ListNode structure.
 */
public class ListNode {
    public int key;
    public int val;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
