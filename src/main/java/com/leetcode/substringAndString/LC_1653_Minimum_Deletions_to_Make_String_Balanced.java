/**
 * Created by Sijia on 3/28/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints: https://leetcode.com/problems/minimum-deletions-to-make-string-balanced/discuss/997750/6-different-approaches%3A-from-basic-to-the-most-optimal-(C%2B%2B)
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.leetcode.substringAndString;

public class LC_1653_Minimum_Deletions_to_Make_String_Balanced {
    public int minimumDeletions(String s) {
        int countA = 0;
        char[] arr = s.toCharArray();
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            char c = arr[i];
            if (c =='a') countA++;
        }
        if (countA == 0 || countA == len) return 0;

        int curB = 0;
        int res = len;
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (c == 'a') countA--;
            res = Math.min(res, countA + curB); // 一定要在bcount之前
            if (c == 'b') curB++;

        }
        return res;

    }

}
