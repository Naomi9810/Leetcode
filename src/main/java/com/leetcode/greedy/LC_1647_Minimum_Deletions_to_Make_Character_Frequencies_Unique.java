/**
 * Created by Sijia on 3/25/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.leetcode.greedy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC_1647_Minimum_Deletions_to_Make_Character_Frequencies_Unique {
    public int minDeletions(String s) {
        int[] letter = new int[26];
        for (char c : s.toCharArray()) {
            letter[c - 'a']++;
        }

        Arrays.sort(letter);
        Set<Integer> set = new HashSet<>();
        int delete = 0;
        for (int i = letter.length - 1; i >= 0; i--) {
            int num = letter[i];
            while (set.contains(num)) {
                delete++;
                num--;
            }
            if (num > 0) {
                set.add(num);
            }
        }
        return delete;
    }
}
