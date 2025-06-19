/**
 * Created by Sijia on 2/21/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints: https://leetcode.com/problems/basic-calculator-ii/discuss/371392/Java-solution-with-explanation
 * pre 暂时保存「当前还不能加进总结果 res 的值」。
 * 当你遇到 + 或 - 时，表示之前的 pre 终于可以安全地加到 res 了，因为它不会再被 * / 修改。
 * * 和 / 操作都直接作用在 pre 上，确保优先计算。
 */  

package com.leetcode.stack;

public class LC_0227_Basic_Calculator_II {
    public int calculate(String s) {
//        if (s == null || s.length() == 0) return 0;
//
//        int res = 0, num = 0, pre = '+';

        // 为什么前面要加 + 因为计算"3+2*2"的时候 只有 当2出现才可以计算
        // 所以 我们计算的用的是前一个op 要用一个pre来计算， case 如果是*号的话 必须先用一个+放数字进去//
        // 为什么后面结束要加+ 因为 我们算的是前一个 op
        // 我们总是在当前的op出现的时候 计算上一组计算 最后一个+不会放进去计算 只是trigger 最后一个op

//        char[] charArr = (s + "+").toCharArray();
//        Stack<Integer> numStack = new Stack<Integer>();
//
//        for (int i = 0; i < charArr.length; i++) {
//            char c = charArr[i];
//            if (c == ' ') continue;
//            if (Character.isDigit(c)) {
//                num = num * 10 + (c - '0');
//            } else {
//                // not a digit:
//                switch (pre) {
//                    case '+':
//                        numStack.push(num);
//                        break;
//                    case '-':
//                        numStack.push(-num);
//                        break;
//                    case '*':
//                        numStack.push(numStack.pop() * num);
//
//                        break;
//                    case '/':
//                        numStack.push(numStack.pop() / num);
//                        break;
//                }
//                num = 0;
//                pre = c;
//            }
//        }
//
//        while (!numStack.isEmpty()) {
//            res += numStack.pop();
//        }
//        return res;
//    }

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
