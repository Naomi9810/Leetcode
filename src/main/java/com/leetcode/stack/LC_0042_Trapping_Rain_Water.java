/**
 * Created by Sijia on 12/27/21
 * Time Complexity:
 * <p>
 * https://www.youtube.com/watch?v=cTSfu3j6G7I
 * Space Complexity:
 * <p>
 * Hints: when we calculate the water ? when higher number comes, so we maintain a decreasing stack, include the equal case.
 * <p> 1. the equal case won't trigger the calculation
 * <p> 2. water height == min of the start and i -  the lowest point (which is the top)
 * <p> 3. pop one and peek as the start.
 */

package com.leetcode.stack;

import java.util.Stack;

public class LC_0042_Trapping_Rain_Water {
    public int trap(int[] height) {
        // left scan +  right scan to find the max heigh
        int len = height.length;
        if (len < 3) return 0;

        int water = 0;
        // int[] leftMax = new int[len];
        // int[] rightMax = new int[len];

        // leftMax[0] = height[0];
        // for (int i = 1; i < len; i++) {
        //     leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        // }

        // rightMax[len - 1] = height[len - 1];
        // for (int i = len - 2; i >= 0; i--) {
        //     rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        // }

        // for (int i = 0; i < len; i++) {
        //     water += Math.min(leftMax[i], rightMax[i]) -  height[i]; // need to -  height[i]
        // }

        // *** stack we have gaps between idx so need to use * but first method, we calculate one by one, only need to +


        // we can only hold water in the lower place, when we find there is higher we can start calculating water
        Stack<Integer> stack = new Stack<>(); // we put the index as
        for (int i = 0; i < len; i++) {
            while(!stack.empty() && height[i] > height[stack.peek()]) {
                // find the higher need calculate, i = rightIdx
                int bottomIdx = stack.pop();
                if(stack.empty()) break;

                int leftIdx = stack.peek();
                int distance = i - leftIdx - 1;  // bottom left is the left bound
                int h = Math.min(height[i], height[leftIdx]) - height[bottomIdx];
                water += h * distance;
            }
            stack.push(i);
        }

        return water;
    }
}
