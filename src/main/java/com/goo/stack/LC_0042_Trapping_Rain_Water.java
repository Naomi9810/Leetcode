/**
 * Created by Sijia on 12/27/21
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints: when we calculate the water ? when higher number comes, so we maintain a decreasing stack, include the equal case.
 * <p> 1. the equal case won't trigger the calculation
 * <p> 2. water height == min of the start and i -  the lowest point (which is the top)
 * <p> 3. pop one and peek as the start.
 */

package com.goo.stack;

import java.util.Stack;

public class LC_0042_Trapping_Rain_Water {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int water = 0;
        for (int i = 0; i < height.length; i++) {
            int h = height[i];
            while (!stack.isEmpty() && h > height[stack.peek()]) {
                int top = stack.pop(); // top is the lowest point
                int start = stack.isEmpty() ? i - 1 : stack.peek(); // if stack is empty, there is no water, then i - start - 1 == 0;
                int waterHeight = Math.min(height[start], h) - height[top];
                water += waterHeight * (i - start - 1);
            }
            stack.push(i);
        }
        return water;
    }
}
