package com.leetcode.array;

public class LC_0006_ZigZag {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }
        int len = s.length();
        StringBuilder sb = new StringBuilder();

        int zigLen = 2 * numRows - 2;

        // PAY P ALI S HIR I NG
        // 3 - 1 - 3 - 1
        // |   /   |   / |
        // n  n-2  n   n-2

        for (int i = 0; i <  numRows; i++) {
            for (int  j = i; j < len; j += zigLen) {
                sb.append(s.charAt(j));
                int second = j + zigLen - 2*i;
                /*
                Explanation:
                P     I    N
                A   L S  I G
                Y A   H R
                P     I

                // j = 1, i = 1, we know L is between A and S, so S = j + zigLen we need to minus the - 2*1
                */
                if (i != 0 && i != numRows-1 && second < len) {
                    sb.append(s.charAt(second));
                }
            }

        }

        return sb.toString();
    }
}
