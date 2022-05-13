/**
 * Created by Sijia on 5/10/22
 * Time Complexity:
 * Space Complexity:
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.goo.dp;

public class LC_1641_Count_Sorted_Vowel_Strings {
    public int countVowelStrings(int n) {
        int a = 1, e = 1, i = 1, o = 1, u = 1;
        int res = 0;
        while (--n > 0) {
            // add new char before prev string
            a = a + e + i + o + u;
            e = e + i + o + u;
            i = i + o + u;
            o = o + u;
            u = u;
        }
        res += a + e + i + o + u;
        return res;
    }
}
