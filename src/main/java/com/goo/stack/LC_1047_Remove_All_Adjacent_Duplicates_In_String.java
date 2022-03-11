/**
 * Created by Sijia on 3/8/22
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

import java.util.ArrayDeque;
import java.util.Deque;

public class LC_1047_Remove_All_Adjacent_Duplicates_In_String {
    public String removeDuplicates(String s) {
        if (s.length() == 1) return s;

        Deque<Character> stack = new ArrayDeque<>();
        for (char c: s.toCharArray()) {
            if (stack.isEmpty() || c != stack.peek()) {
                stack.push(c);
            } else {
                stack.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.removeLast());
        }

        return sb.toString();
    }
}
