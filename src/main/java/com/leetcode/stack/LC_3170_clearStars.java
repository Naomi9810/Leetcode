package com.leetcode.stack;

import java.util.Stack;

/*
greedy +
*/

public class LC_3170_clearStars {
    public String clearStars(String s) {
        if (!s.contains("*"))
            return s;
        Stack<Integer>[] count = new Stack[26]; // FILO
        for (int i = 0; i < 26; i++) {
            count[i] = new Stack<>();
        }
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != '*') {
                count[arr[i] - 'a'].push(i);
            } else {
                // need to remove
                for (int j = 0; j < 26; j++) {
                    if (!count[j].isEmpty()) {
                        arr[count[j].pop()] = '*';
                        break;
                    }
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        for (char c : arr) {
            if (c != '*') {
                ans.append(c);
            }
        }
        return ans.toString();

    }
}
