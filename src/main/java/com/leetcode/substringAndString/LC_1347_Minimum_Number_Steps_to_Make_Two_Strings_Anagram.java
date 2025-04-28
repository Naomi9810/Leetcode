/**
 * Created by Sijia on 2/16/22
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

public class LC_1347_Minimum_Number_Steps_to_Make_Two_Strings_Anagram {
    public int minSteps(String s, String t) {
        int[] tLetter = new int[26];
        for (int i = 0; i < t.length(); i++) {
            tLetter[s.charAt(i) - 'a']++;
            tLetter[t.charAt(i) - 'a']--;
        }

        int res = 0;
        for (int i = 0; i < 26; i++) {
            if (tLetter[i] > 0) { // only counts the positive number not to double count
                res += tLetter[i];
            }
        }
        return res;
    }
}
