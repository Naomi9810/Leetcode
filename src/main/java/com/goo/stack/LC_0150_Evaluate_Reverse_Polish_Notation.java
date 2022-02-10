/**
 * Created by Sijia on 2/2/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.goo.stack;

import java.util.Stack;

public class LC_0150_Evaluate_Reverse_Polish_Notation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> numStack = new Stack<>();

        for (String str : tokens) {
            if ("+-*/".contains(str)) {
                int n2 = numStack.pop(), n1 = numStack.pop();
                int next = 0;
                switch (str) {
                    case "+":
                        next = n1 + n2;
                        break;
                    case "-":
                        next = n1 - n2;
                        break;
                    case "*":
                        next = n1 * n2;
                        break;
                    case "/":
                        next = n1 / n2;
                        break;
                }
                numStack.add(next);
            } else {
                numStack.add(Integer.valueOf(str));
            }
        }

        return numStack.peek();
    }
}
