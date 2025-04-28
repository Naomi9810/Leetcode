/**
 * Created by Sijia on 3/12/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.leetcode.mathBitMatrix;

public class LC_0043_Multiply_Strings {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) return "0";
        int len1 = num1.length(), len2 = num2.length();
        char[] arr1 = num1.toCharArray();
        char[] arr2 = num2.toCharArray();

        int[] res = new int[len1 + len2 - 1];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                res[i + j] += (arr1[i] - '0') * (arr2[j] - '0');
            }
        }

        for (int i = res.length - 1; i - 1 >= 0; i--) {
            res[i - 1] += res[i] / 10;
            res[i] = res[i] % 10;
        }

        StringBuilder sb = new StringBuilder();

        for (int i : res) {
            sb.append(i);
        }

        return sb.toString();
    }
}
