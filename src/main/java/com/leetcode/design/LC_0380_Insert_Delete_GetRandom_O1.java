/**
 * Created by Sijia on 2/18/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints: 用map存 idx 如果有dup 就用set存
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.leetcode.design;

import java.util.*;

public class LC_0380_Insert_Delete_GetRandom_O1 {
    Map<Integer, Integer> value2Idx;
    List<Integer> list;
    Random rand = new Random();

    public void RandomizedSet() {
        value2Idx = new HashMap<>();
        list = new ArrayList<>(); // idx - value

    }

    public boolean insert(int val) {
        if (value2Idx.containsKey(val)) return false;

        value2Idx.put(val, list.size());
        list.add(val);

        return true;
    }

    public boolean remove(int val) {
        if (!value2Idx.containsKey(val)) return false;

        // no matter what value it is, swap it with the last item in the list, so that we remove the last item
        // to main the idx

        int idx = value2Idx.get(val);
        int lastVal = list.getLast();
        list.set(idx, lastVal);
        list.removeLast();

        value2Idx.put(lastVal, idx); // update the idx
        value2Idx.remove(val);

        return true;
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
