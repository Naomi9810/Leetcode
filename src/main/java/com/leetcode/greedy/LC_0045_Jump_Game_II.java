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

package com.leetcode.greedy;

public class LC_0045_Jump_Game_II {
    public int jump(int[] nums) {
        int farthest = 0, jump = 0, len = nums.length;
        int farthestWithoutJump = 0;
        // corner case
        if (nums.length == 1) return 0;


        for (int i = 0; i < len; i++) {
            if (i + nums[i] > farthest) {
                farthest = i + nums[i];
            }
            // only jump when i == farthest
            if (i == farthestWithoutJump) {
                jump++;
                farthestWithoutJump = farthest;
                if (farthestWithoutJump >= len - 1) {
                    return jump;
                }
            }
        }
        return jump;
        // eg
        // nums =
        //[2,3,1,1,4]
        // i = 0, farthest = 2, jump = 1, farthestWithoutJump = 2
        // i = 1, farthest = 4, jump = 1, farthestWithoutJump = 2
        // i = 2, farthest = 4, jump = 2, farthestWithoutJump = 4
    }
}
