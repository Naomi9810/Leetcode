package com.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;

public class LC_0772_Basic_Calculator_III {
    public int calculate(String s) {
        if (s == null || s.isEmpty()) return 0;

        Queue<Character> q = new ArrayDeque<>() {};
        for (char c : s.toCharArray()) {
            if (c != ' ') q.offer(c);  // Skip spaces
        }

        return evaluate(q);

    }
    private int evaluate(Queue<Character> q) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';  // Default to positive addition

        while (!q.isEmpty()) {
            char c = q.poll();

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            if (c == '(') {
                // Begin a sub-expression
                num = evaluate(q);
            }

            // Process the operation if:
            // - Current char is an operator
            // - Or we reach the end of the expression
            if (!Character.isDigit(c) || q.isEmpty()) {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }

                if (c == ')') break;  // End of sub-expression

                sign = c;
                num = 0;
            }
        }

        int result = 0;
        for (int n : stack) result += n;
        return result;
    }
}
