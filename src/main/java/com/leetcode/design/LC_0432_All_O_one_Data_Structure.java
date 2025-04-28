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

package com.leetcode.design;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class LC_0432_All_O_one_Data_Structure {
    /*
    * logN to query max/min TreeMap
    * Map store String
    * TreeSet store Node compared by count
    * Node include String and Count
    * */
    private final Map<String, Node> map = new HashMap<>();
    private final TreeSet<Node> set = new TreeSet<>((e1, e2) -> {
        int compare = Integer.compare(e1.count,e2.count);
        if (compare == 0) {
            return e1.s.compareTo(e2.s);
        }
        return compare;
    });

    public void inc(String key) {
        Node node = map.get(key);
        if (node == null) {
            node = new Node(key,1);
            map.put(key,node);
        } else {
            set.remove(node);
            node.count +=1;
        }
        set.add(node);
    }

    public void dec(String key) {
        Node node = map.get(key);
        set.remove(node);
        node.count--;
        if (node.count > 0) {
            set.add(node);
        } else {
            map.remove(key);
        }
    }

    public String getMaxKey() {
        if (set.isEmpty()) {
            return "";
        }
        Node node = set.last();
        return node != null ? node.s : "";
    }

    public String getMinKey() {
        if (set.isEmpty()) {
            return "";
        }
        Node node = set.first();
        return node != null ? node.s : "";
    }

    static final class Node {
        private int count;
        private final String s;
        Node(String s, int count) {
            this.s = s;
            this.count = count;
        }
    }
}
