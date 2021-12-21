/**
 * Created by Sijia on 12/20/21
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.  once we meet the negative we swap the positive and negative, when swap twice, then negative -> positive
 * <p> 2. always calculate the positive len, because it keep track of all the element seen so far
 * <p> 3. https://leetcode.com/problems/maximum-length-of-subarray-with-positive-product/discuss/820072/EASY-soultion-with-DRY-RUN-JAVA
 * elements      :   9    5    8    2    -6    4    -3    0    2    -5    15    10    -7    9    -2
 * positive_len  :   1    2    3    4     0    1     7    0    1     0     1     2     5    6     5
 * negative_len  :   0    0    0    0     5    6     2    0    0     2     3     4     3    4     7
 */

package com.goo.dp;

public class LC_1567_Maximum_Length_Subarray_With_Positive_Product {
    public int getMaxLen(int[] nums) {
        int positive = 0, negative = 0, res = 0;
        for (int num : nums) {
            if (num == 0) {
                positive = 0;
                negative = 0;
            } else if (num > 0) {
                positive++;
                negative = negative == 0 ? 0 : negative + 1; // when there is no negative no need to add
            } else {
                // negative case swap
                int temp = positive;
                positive = negative == 0 ? 0 : negative + 1;
                negative = temp + 1;
            }
            res = Math.max(res, positive);

        }
        return res;
    }
}
