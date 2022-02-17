/**
 * Created by Sijia on 1/10/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints: https://leetcode.com/problems/my-calendar-ii/discuss/109550/Simple-AC-by-TreeMap
 * <p> 1. 计数法 start +1 end就-1 如果有重合 count 就会=2， 用treeMap所以 record都是ordered的 第三问一样的做法
 * <p> 2.
 * <p> 3.
 */

package com.goo.sortInterval;

import java.util.Map;
import java.util.TreeMap;

public class LC_0731_My_Calendar_II {

    TreeMap<Integer, Integer> cal;

    public void MyCalendarTwo() {
        cal = new TreeMap<>(); // ordered map
    }

    public boolean book(int start, int end) {
        cal.put(start, cal.getOrDefault(start, 0) + 1);
        cal.put(end, cal.getOrDefault(end, 0) - 1);
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : cal.entrySet()) {
            count += entry.getValue();
            if (count > 2) { // Triple booking
                cal.put(start, cal.get(start) - 1);
//                if (calendar.get(start) == 0) {
//                    calendar.remove(start);
//                }
                cal.remove(start, 0);
                cal.put(end, cal.get(end) + 1);
                cal.remove(end, 0);
                return false;
            }
        }
        return true;
    }
}
