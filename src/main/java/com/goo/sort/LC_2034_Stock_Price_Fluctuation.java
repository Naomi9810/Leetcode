/**
 * Created by Sijia on 1/20/22
 * Time Complexity:
 * <p> O(logn) for each function
 * Space Complexity:
 * <p> O(N)
 * Hints: problem is that the updated new price will correct the price, this can be a max or a min where we need to remove,
 * then need to find the second max or min, so need to use treemap again.
 * <p> 1. can't simply use a treeSet because there are dup prices
 * <p> 2. https://leetcode.com/problems/stock-price-fluctuation/discuss/1513413/JavaC%2B%2BPython-Strightforward-Solutions
 * <p> 3.
 */

package com.goo.sort;

import java.util.*;

public class LC_2034_Stock_Price_Fluctuation {
    private TreeMap<Integer, Integer> record; // time : val
    private TreeMap<Integer, Set<Integer>> vals; // val: time set

    public void StockPrice() {
        record = new TreeMap<>(); // ordered map based on time
        vals = new TreeMap<>();
    }

    public void update(int timestamp, int price) {
        if (record.containsKey(timestamp)) {
            // the previous val is wrong
            int pre = record.get(timestamp);
            Set<Integer> timeSet = vals.get(pre);
            timeSet.remove(timestamp);
            if (timeSet.isEmpty()) {
                vals.remove(pre);
            }
        }
        record.put(timestamp, price);
        vals.putIfAbsent(price, new HashSet<>());
        vals.get(price).add(timestamp);
    }

    public int current() {
        return record.lastEntry().getValue();
    }

    public int maximum() {
        return vals.lastKey();
    }

    public int minimum() {
        return vals.firstKey();
    }
}
