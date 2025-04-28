/**
 * Created by Sijia on 1/20/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints: 两个stack 一个数字stack 一个 Str stack
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.leetcode.dfs;

import java.util.Stack;

public class LC_0394_Decode_String {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) return "";
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> stack = new Stack<>();
        stack.push(new StringBuilder());

        int val = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                val = val * 10 + (c - '0');
            } else if (c == '[') {
                stack.push(new StringBuilder());
                numStack.push(val);
                val = 0;
            } else if (c == ']') {
                StringBuilder sb = new StringBuilder();
                StringBuilder temp = stack.pop();
                int dup = numStack.pop();
                for (int j = 0; j < dup; j++) {
                    sb.append(temp);
                }
                stack.peek().append(sb);
            } else {
                stack.peek().append(c);
            }
        }
        return stack.peek().toString();
    }
}
