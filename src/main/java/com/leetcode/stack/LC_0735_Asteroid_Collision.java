/**
 * Created by Sijia on 2/11/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:  https://leetcode.com/problems/asteroid-collision/discuss/109703/Java-solution-Stack
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.leetcode.stack;

import java.util.Stack;

public class LC_0735_Asteroid_Collision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int a : asteroids) {
            if (stack.isEmpty() || a > 0) {
                stack.add(a);
            } else {
                // a < 0
                while (true) {
                    int pre = stack.peek();
                    if (pre < 0) {
                        stack.add(a);
                        break;
                    }
                    if (pre == -a) {
                        stack.pop();
                        break;
                    }
                    if (pre > -a) {
                        break;
                    }
                    stack.pop();
                    if (stack.isEmpty()) { // only when its empty otherwise continue go to the loop
                        stack.add(a);
                        break;
                    }
                }
            }
        }

        int[] res = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;

    }
}
