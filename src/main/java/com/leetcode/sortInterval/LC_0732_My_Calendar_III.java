/**
 * Created by Sijia on 1/11/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints: https://leetcode.com/problems/my-calendar-iii/discuss/176950/C%2B%2B-Map-Solution-beats-95%2B
 *
 * 如果没有重叠 那么按照时间 treeMap 次序来算 就会 +1 -1 + 1- 1
 * 一旦有重叠 那么 会出现 > 1 的 次数 因为有的interval 已经开始 中间出现的max 就是重叠最多的 也就是k's booking
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.leetcode.sortInterval;

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
