/**
 * Created by Sijia on 3/20/22
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

public class LC_0921_Minimum_Add_to_Make_Parentheses_Valid {
    public int minAddToMakeValid(String s) {
        int left = 0, right = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') left++;
            else if (left > 0 && c == ')') left--;
            else right++;
        }
        return left + right;
    }
}
