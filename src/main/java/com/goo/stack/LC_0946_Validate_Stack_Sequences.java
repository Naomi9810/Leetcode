/**
 * Created by Sijia on 1/11/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints: simulation use the push array as stack.
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.goo.stack;

import java.util.Stack;

public class LC_0946_Validate_Stack_Sequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
//        Stack<Integer> stack = new Stack<>();
//        int idx = 0;
//        for (int item: pushed) {
//            stack.push(item);
//            while (!stack.isEmpty() && stack.peek() == popped[idx]) {
//                stack.pop();
//                idx++;
//            }
//        }
//        return stack.isEmpty();
        int i = 0, j = 0;
        for (int item: pushed) {
            pushed[i++] = item;
            while ( i != 0 && popped[j] == pushed[i-1]) {
                j++;
                i--;
            }
        }
        return i == 0;
    }
}
