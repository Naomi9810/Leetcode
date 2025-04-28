/**
 * Created by Sijia on 1/18/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.leetcode.array;

import java.util.Map;
import java.util.TreeMap;

public class LC_2007_Find_Original_Array_From_Doubled_Array {
    public int[] findOriginalArray(int[] changed) {
        int len = changed.length, i = 0;
        if (len % 2 == 1) return new int[0];
        int[] res = new int[len / 2];
        Map<Integer, Integer> map = new TreeMap<>();
        for (int num : changed)
            map.put(num, map.getOrDefault(num, 0) + 1);
        for (int x : map.keySet()) {
            if (map.get(x) > map.getOrDefault(x + x, 0))
                return new int[0];
            for (int j = 0; j < map.get(x); j++) {
                res[i++] = x;
                map.put(x + x, map.get(x + x) - 1);
            }
        }
        return res;
    }
}
