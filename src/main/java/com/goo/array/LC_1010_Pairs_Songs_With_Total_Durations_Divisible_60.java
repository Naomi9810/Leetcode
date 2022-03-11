/**
 * Created by Sijia on 3/10/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.goo.array;

public class LC_1010_Pairs_Songs_With_Total_Durations_Divisible_60 {
    public int numPairsDivisibleBy60(int[] time) {
        int count = 0;
        int[] map = new int[60];

        for (int t: time) {
            int remain = t % 60;
            if (remain == 0) {
                count += map[0];
            } else {
                count += map[60 - remain];
            }
            map[remain]++;
        }
        return count;
    }
}
