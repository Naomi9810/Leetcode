/**
 * Created by Sijia on 1/11/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.goo.sortInterval;

import java.util.Map;
import java.util.TreeMap;

public class LC_0732_My_Calendar_III {
    TreeMap<Integer, Integer> cal;

    public void MyCalendarThree() {
        cal = new TreeMap<>();
    }

    public int book(int start, int end) {
        cal.put(start, cal.getOrDefault(start, 0) + 1);
        cal.put(end, cal.getOrDefault(end, 0) - 1);
        int res = 0, max = Integer.MIN_VALUE;
        for (Map.Entry<Integer,Integer> entry: cal.entrySet()) {
            res += entry.getValue();
            max = Math.max(res, max);
        }
        return max;
    }
}
