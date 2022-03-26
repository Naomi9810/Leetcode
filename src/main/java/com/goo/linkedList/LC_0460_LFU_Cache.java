/**
 * Created by Sijia on 3/26/22
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

import java.util.HashMap;
import java.util.Map;

public class LC_0460_LFU_Cache {
    /**
     *  O(1) get the value
     *  O(1) put in the map if exceed the capacity. evict the lowest frequency one
     *  LRU的进阶版： 除了maintain 一个LinkedList 每次hit到加到head之外 还更新frequency
     *  用一个 minFreq 去记录当前最小的freq
     *  关键点在于
     *  1. 每次put的时候 updateCount 方法中如果minFreq是当前的node，且NodeList只有一个
     *  minFreq++
     *  2. get 和 update 的时候 需要 addCount
     *  3. add 新的node的时候，先要check capacity evict 然后 更新minFreq = 1
    */

    Map<Integer, Node> valMap;
    Map<Integer, NodeList> countMap;
    int capacity;
    int minFreq;

    public void LFUCache(int capacity) {
        this.valMap = new HashMap<>();
        this.countMap = new HashMap<>();
        this.capacity = capacity;
        this.minFreq = 1;
    }

    public int get(int key) {
        if (valMap.containsKey(key)) {
            Node cur = valMap.get(key);
            addCount(cur);
            return cur.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (valMap.containsKey(key)) {
            Node cur = valMap.get(key);
            cur.val = value;
            addCount(cur);
            return;
        }

        if (valMap.size() == capacity) {
            // need to evict first
            NodeList minList = countMap.get(minFreq);
            Node invalid = minList.tail.pre; // least used one
            valMap.remove(invalid.key);
            minList.deleteNode(invalid);
        }
        // need to create a new Node
        Node node = new Node(key, value);
        minFreq = 1;
        NodeList list = countMap.getOrDefault(minFreq, new NodeList());
        list.addToHead(node);

        valMap.put(key, node);
        countMap.put(minFreq, list);
    }

    public void addCount(Node node) {
        int count = node.count;
        NodeList preList = countMap.get(count);
        // remove both
        preList.deleteNode(node);
        valMap.remove(node.key);

        if (count == minFreq && preList.size == 0) minFreq++; // 如果它是当前freq 最后一个element

        NodeList list = countMap.getOrDefault(count+1, new NodeList());
        node.count++;
        list.addToHead(node);

        // add both
        valMap.put(node.key, node);
        countMap.put(node.count, list);
    }
}

class Node {
    int val;
    int key;
    int count;
    Node pre, next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.count = 1;
    }

    public Node(){

    }
}


class NodeList {
    Node head, tail;
    int size = 0;

    public NodeList() {
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    public void deleteNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        size--; // change size here so don't need to worry about it
    }

    public void addToHead(Node node) {
        Node temp = head.next;
        head.next = node;
        node.next = temp;
        node.pre = head;
        temp.pre = node;
        size++;
    }
}
