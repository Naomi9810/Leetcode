/**
 * Created by Sijia on 1/10/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.goo.sort;

import java.util.Map;
import java.util.TreeMap;

public class LC_0731_My_Calendar_II {

    TreeMap<Integer, Integer> calendar;

    public void MyCalendarTwo() {
        calendar = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        calendar.put(start, calendar.getOrDefault(start, 0) + 1);
        calendar.put(end, calendar.getOrDefault(end, 0) - 1);
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : calendar.entrySet()) {
            count += entry.getValue();
            if (count > 2) {
                calendar.put(start, map.get(start) - 1);
//                if (calendar.get(start) == 0) {
//                    calendar.remove(start);
//                }
                calendar.remove(start, 0);
                calendar.put(end, map.get(end) + 1);
                calendar.remove(end, 0);
                return false;
            }
        }
        return true;
    }
}
