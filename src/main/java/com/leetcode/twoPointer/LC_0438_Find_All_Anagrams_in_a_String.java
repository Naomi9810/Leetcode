/**
 * Created by Sijia on 3/10/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.leetcode.twoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_0438_Find_All_Anagrams_in_a_String {
    public List<Integer> findAnagrams(String s, String p) {

        int len = p.length();
        List<Integer> res = new ArrayList<>();

        int[] letter = new int[26];
        for (char c: p.toCharArray()) {
            letter[c - 'a']++;
        }

        int[] window = new int[26];

        char[] charArr = s.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            window[charArr[i] - 'a']++;
            if (i >= len) {
                window[charArr[i - len] - 'a']--;  // remove
            }

            if (Arrays.equals(letter, window)) {
                res.add(i - len + 1); //  两个stirng的map一致
            }
        }
        return res;

    }

}
