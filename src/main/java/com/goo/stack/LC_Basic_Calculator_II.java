/**
 * Created by Sijia on 2/21/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints: https://leetcode.com/problems/basic-calculator-ii/discuss/371392/Java-solution-with-explanation
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.goo.stack;

import java.util.Stack;

public class LC_Basic_Calculator_II {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;

//         int res = 0, num = 0;
//         char opr = '+'; // trigger start


//         Stack<Integer> stack = new Stack<Integer>();
//         for(char chr : (s + "+").toCharArray()) { // trigger end
//             if(chr == ' ')continue;
//             if(Character.isDigit(chr)) {
//                 num = num * 10 + (chr - '0');
//             } else {
//                 switch(opr) {
//                     case '+':
//                         stack.push(num);
//                         break;
//                     case '-':
//                         stack.push(-num);
//                         break;
//                     case '*':
//                         stack.push(stack.pop() * num);
//                         break;
//                     case '/':
//                         stack.push(stack.pop() / num);
//                         break;
//                     default:
//                         return -1;
//                 }
//                 num = 0;
//                 opr = chr;
//             }
//         }
//         while(!stack.isEmpty()) {
//             res += stack.pop();
//         }

//         return res;
//  不用stack的优化

        int res = 0, pre = 0, n = s.length();
        char op = '+';
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;
            if (c <= '9' && c >= '0') {
                int num = c - '0';
                while (i + 1 < n && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + s.charAt(++i) - '0';
                }
                if (op == '+' || op == '-') {
                    res += pre;
                    pre = op == '+' ? num : -num;
                } else if (op == '*') {
                    pre *= num;
                } else if (op == '/') {
                    pre /= num;
                }
            } else {
                op = c;
            }
        }
        return res + pre;
    }
}
