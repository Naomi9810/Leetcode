package com.leetcode;

import com.leetcode.array.LC_0001_Two_Sum;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int [] nums = {2, 7, 11, 15};
        int target = 9;
        int[] res = new LC_0001_Two_Sum().twoSum(nums, target);
        System.out.println(Arrays.toString(res));
    }
}
