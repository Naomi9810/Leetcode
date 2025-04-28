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
    // val, index
    Map<Integer, Integer> index;
    List<Integer> list;
    Random rand = new Random();

    public void RandomizedSet() {
        index = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if(index.containsKey(val)) return false;
        list.add(val);
        index.put(val, list.size()-1);
        return true;
    }

    public boolean remove(int val) {
        if(!index.containsKey(val)) return false;

        int indexRemove = index.get(val);
        int last = list.get(list.size()-1);  // remove the last one

        list.set(indexRemove, last);
        index.put(last, indexRemove);
        index.remove(val);
        list.remove(list.size()-1);
        return true;
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
