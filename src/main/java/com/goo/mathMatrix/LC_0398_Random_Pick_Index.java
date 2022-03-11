/**
 * Created by Sijia on 1/11/22
 * Time Complexity:
 * <p> O(N)
 * Space Complexity:
 * <p> O(1)
 * Hints:
 * 水库采样： 到n 就用1/n 的概率取 可以保证每个概率一致
 * <p> 1. (int) Math.random() * (max- min +1 ) + min   generate random number [min, max]
 * <p> 2. Random.nextInt(bound)  generate randon Int [0, bound)
 * <p> 3.
 */

package com.goo.mathMatrix;

import java.util.Random;

public class LC_0398_Random_Pick_Index {
    int[] nums;
    Random rdm;

    public void Solution(int[] nums) {
        this.nums = nums;
        this.rdm =  new Random();

    }

    public int pick(int target) {
        int res = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target)
                continue;
            if (rdm.nextInt(++count) == 0) { // everytime we meet qualified number, count++
                res = i;
            }
        }
        return res;

    }
}
