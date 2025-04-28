/**
 * Created by Sijia on 12/20/21
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.leetcode.dp;

public class LC_1014_Best_Sightseeing_Pair {
    public int maxScoreSightseeingPair(int[] values) {
        int len = values.length;
        int plusMax = values[0];
        int res = values[0] + 0 - 1; //  i = 0; j = 1 i < j

        for (int i = 1; i < len; i++) {
            int plus = values[i] + i;
            int minus = values[i] - i;
            res = Math.max(res, plusMax + minus); //  update the res from a previous i  plusMax
            plusMax = Math.max(plusMax, plus); // update the plusMax, this order is because i < j  if update first, i could == j
        }
        return res;
    }
}
