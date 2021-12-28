/*
 * Created by Sijia on 12/26/21
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints: https://leetcode.com/problems/trapping-rain-water/discuss/244167/a-general-stack-approach-you-can-solve-42-84-85
 * when you can calculate the area ? when a shorter number comes
 * step1: maintain an increasing stack
 * step2: if this height is less than the peek, then pop it and calculate until height > or = peek
 * step3: i = len so height =0 so we can pop everything out.
 * say [3,4,5,3]
 *     0,1,2,3
 * i = 0,1,2 -> all pushed in
 * i = 3 -> calculate 5*1 and 4*2
 * i =4 -> calculate 3*4 = 12
 * <p>
 * Monotonic Stack:
 * 1. the monotonic stack helps us maintain maximum and minimum elements in the range and keeps the order of elements in the range
 * 2. range queries in an array problem
 * 3. minima/maxima element or the monotonic order of elements in a range is useful to get answer of every range query
 * 4. O(N) each element only seen one time, once popped from stack, never be used again.
 */

package com.goo.stack;

import java.util.Stack;

public class LC_0084_Largest_Rectangle_in_Histogram {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>(); // saves the idx
        int area, max = 0;
        int len = heights.length;
        for (int i = 0; i <= len; i++) {
            int height = (i == len) ?  0: heights[i]; // i = len so we can pop everything out
            while (!stack.isEmpty() && height < heights[stack.peek()]) {
                // maintain an increasing stack, if current height equal or greater than the top height, then directly put
                int top = stack.pop();
                int start = stack.isEmpty()? 0:  stack.peek();
                area = heights[top] * (i - start -1); //  max height * len
                max = Math.max(max, area);
            }
            stack.push(i);
        }
        return max;

    }
}
