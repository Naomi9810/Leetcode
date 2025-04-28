/**
 * Created by Sijia on 3/9/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.leetcode.substringAndString;

public class LC_0696_Count_Binary_Substrings {
    public int countBinarySubstrings(String s) {
        int count = 0;
        char[] charArr = s.toCharArray();
        int len = charArr.length;

//         for (int i = 0; i+1 < len; i++) {
//             if (charArr[i] == '0' && charArr[i+1] == '1') {
//                 int p = i, q = i+1;
//                 while (p >= 0 && q < len && charArr[p] == '0' && charArr[q] == '1') {
//                     count++;
//                     p--;
//                     q++;
//                 }
//             }
//             if (charArr[i] == '1' && charArr[i+1] == '0') {
//                 int p = i, q = i+1;
//                 while (p >= 0 && q < len && charArr[p] == '1' && charArr[q] == '0') {
//                     count++;
//                     p--;
//                     q++;
//                 }
//             }
//         }

        int[] group = new int[len];
        int k = 0;
        group[k] = 1;
        for (int i = 1; i < len; i++) {
            if (charArr[i-1] != charArr[i]) {
                group[++k] = 1;
            } else {
                group[k]++;
            }
        }

        for (int i = 1; i <= k; i++) {
            count += Math.min(group[i-1], group[i]);
        }

        return count;

    }
}
