/**
 * Created by Sijia on 12/19/21
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.goo.greedy;

import java.util.Arrays;

public class LC_0045_Jump_Game_II {
    public int jump(int[] nums) {
        int step = 0, lastPos = 0, max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            // pay attention to i < len-1 only need to get to len-1 pos
            max = Math.max(nums[i] + i, max); // first the max far we can reach
            if (i == lastPos) {
                // when we already reach the last max, we need to jump
                step++;
                lastPos = max;
            }
        }
        return step;
    }
}
