/**
 * Created by Sijia on 3/7/22
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

public class LC_0706_Design_HashMap {
    final int size = 10001;
    ListNode[] map;

    public void MyHashMap() {
        map = new ListNode[size];
    }

    public void put(int key, int value) {
        int hashKey = hash(key);
        if (map[hashKey] == null) {
            map[hashKey] = new ListNode(key, value);
        } else {
            ListNode cur = map[hashKey];
            while (cur != null) {
                if (cur.key == key) {
                    cur.val = value;
                    return;
                }
                cur = cur.next;
            }
            ListNode head = new ListNode(key, value);
            head.next = map[hashKey];
            map[hashKey] = head;
        }
    }

    public int get(int key) {
        int hashKey = hash(key);
        if (map[hashKey] == null) return -1;
        ListNode cur = map[hashKey];
        while (cur != null) {
            if (cur.key == key) {
                return cur.val;
            }
            cur = cur.next;
        }
        return -1;
    }

    public void remove(int key) {
        int hashKey = hash(key);
        if (map[hashKey] == null) return;
        ListNode cur = map[hashKey];
        if (cur.key == key) {
            map[hashKey] = cur.next;
        } else {
            while (cur != null && cur.next != null) {
                if (cur.next.key == key) {
                    cur.next = cur.next.next;
                }
                cur = cur.next;
            }
        }

    }

    private int hash(int key) {
        return Integer.hashCode(key)% size;
    }
}
