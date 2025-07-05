/**
 * Created by Sijia on 2/14/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * No need to count the frequency, just everytime there is a cache hit, move it to the head
 * 每次都move到head
 * moveTohead = remove+ addToHead
 * <p>
 * move to head = remove node + add to head
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.leetcode.linkedList;

import java.util.HashMap;
import java.util.Map;

public class LC_0146_LRU_Cache {
    private Map<Integer, Node> cache;
    private int capacity;
    private Node head;
    private Node tail;

    public void LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.capacity = capacity;
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            // update
            Node trash = cache.get(key);
            removeNode(trash);
        } else if (cache.size() == capacity) {
            // need to evict
            cache.remove(tail.pre.key);
            removeNode(tail.pre);
        }

        Node node = new Node(key,value);
        cache.put(key, node);
        addToHead(node);
    }

    private void moveToHead(Node cur) {
        removeNode(cur);
        addToHead(cur);
    }

    private void removeNode(Node cur) {
        cur.pre.next = cur.next;
        cur.next.pre = cur.pre;
    }

    private void addToHead(Node cur) {
        Node second = head.next;
        head.next = cur;
        cur.pre = head;
        cur.next = second;
        second.pre = cur;
    }

    private class Node {
        int key;
        int value;
        Node pre;
        Node next;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
