/**
 * Created by Sijia on 3/15/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC_0716_Max_Stack {
    Deque<Integer> stack;
    Deque<Integer> maxStack;

    /** initialize your data structure here. */
    public void MaxStack() {
        stack = new ArrayDeque<>();
        maxStack = new ArrayDeque<>();

    }

    public void push(int x) { // 5 // 5
        if (maxStack.isEmpty() || x >= maxStack.peek()) {
            maxStack.push(x);
        }
        stack.push(x);
    }

    public int pop() {
        int top = stack.pop();
        if (top == maxStack.peek()) {
            maxStack.pop();
        }
        return top;
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public int popMax() {
        int max = maxStack.pop();
        Deque<Integer> temp = new ArrayDeque<>();
        while (stack.peek() != max) {
            temp.push(stack.pop());
        }
        stack.pop(); // pop the max
        while (!temp.isEmpty()) {
            push(temp.pop());
        }
        return max;
    }
}
