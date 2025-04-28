/**
 * Created by Sijia on 5/11/22
 * Time Complexity:
 * Space Complexity:
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.leetcode.greedy;

import java.util.ArrayList;
import java.util.List;

public class LC_2178_Maximum_Split_of_Positive_Even_Integers {
    // https://leetcode.com/problems/maximum-split-of-positive-even-integers/discuss/1783721/JAVA-or-Intuitive-Explanation-or-Greedy-Approach
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> res = new ArrayList<>();
        if (finalSum % 2 != 0) {
            return res;
        }

        long cur = 2;
        long remain = finalSum;

        while (cur <= remain) {
            res.add(cur);
            remain -= cur;
            cur +=2;
        }

        long last = res.remove(res.size()-1);
        res.add(last+remain);
        return res;
    }
}
