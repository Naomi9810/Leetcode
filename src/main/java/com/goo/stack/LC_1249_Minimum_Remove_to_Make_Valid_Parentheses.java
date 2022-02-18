/**
 * Created by Sijia on 2/17/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints: 两种方法
 * 1. pass1 用stack 存左括号的idx，右括号--  pass2 从尾巴pop 多余的左括号
 * 2. pass 不用stack 用计数法， 要remove 标记一下， pass2 从尾巴 用stringBuilder append
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.goo.stack;

public class LC_1249_Minimum_Remove_to_Make_Valid_Parentheses {
    public String minRemoveToMakeValid(String s) {
//         Stack<Integer> stack = new Stack<>();
//         String[] arr = s.split("");
//         for (int i = 0; i < arr.length; i++) {
//             if (arr[i].equals("(")) {
//                 stack.push(i);
//             } else if (arr[i].equals(")")) {
//                 if (stack.isEmpty()) {
//                     arr[i] = "";
//                 } else {
//                     stack.pop();
//                 }
//             }
//         }

//         while(!stack.isEmpty()) {
//             arr[stack.pop()] = "";
//         }

//         return String.join("", arr);

        int open = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                open++;
            } else if (arr[i] == ')') {
                if (open > 0) {
                    open--;
                } else {
                    arr[i] = '*';
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) { // 多余的（ 从右边出
            if (open > 0 && arr[i] == '(') {
                open--;
                // skip this
            } else if (arr[i] != '*') {
                sb.append(arr[i]);
            }
        }
        return sb.reverse().toString();
    }
}
