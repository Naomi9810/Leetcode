/**
 * Created by Sijia on 1/15/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints: arr[2 * i + 1] = 2 * arr[2 * i]
 * <p> 1. sort + scan  NlogN + N can't solve the duplicate issue
 * <p> 2.
 * <p> 3.
 */

package com.leetcode.array;

import java.util.*;

public class LC_0954_Array_of_Doubled_Pairs {
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> map = new TreeMap<>(); // store the count of the num
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            if (count == 0) continue; //  don't miss this, updated map need skip this
            int pair = num > 0 ? num * 2 : num / 2; // the pair num we are looking for
            if (num < 0 && num % 2 != 0 || count > map.getOrDefault(pair, 0)) {
                // negative num pair is different
                return false;
            }
            map.put(pair, map.get(pair) - count); // need to update the map to remove the paired arr
        }
        return true;
    }
}
