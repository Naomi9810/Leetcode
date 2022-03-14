/**
 * Created by Sijia on 3/11/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.goo.substringAndString;

public class LC_0409_Longest_Palindrome {
    public int longestPalindrome(String s) {
        int[] letter = new int[128];
        for (char c: s.toCharArray()) {
            letter[c]++;
        }

        int res = 0;
        for (int i = 0; i < letter.length; i++) {
            res +=  2 * (letter[i] /2); // map
        }
        return res < s.length() ? res+1: res;


    }
}
