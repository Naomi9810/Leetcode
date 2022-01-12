/**
 * Created by Sijia on 1/10/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints: TreeMap
 * floorKey/lowerKey <=/<
 * ceilingKey/higherKey >=/>
 *
 * floorkey ' end > start or ceilingkey' start < end
 *
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.goo.sort;

import java.util.TreeMap;

public class LC_0729_My_Calendar_I {
    TreeMap<Integer, Integer> cal;

    public void MyCalendar() {
        cal = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer pre = cal.floorKey(start);
        if (pre != null && cal.get(pre) > start) return false;
        Integer next = cal.ceilingKey(start);
        if (next != null && next < end) return false;

        cal.put(start, end);
        return true;
    }
}
