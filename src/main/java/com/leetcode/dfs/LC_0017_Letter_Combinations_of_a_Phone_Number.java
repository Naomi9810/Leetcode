/*
 * Created by Sijia on 3/18/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LC_0017_Letter_Combinations_of_a_Phone_Number {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;
        Map<Character, String> letters = Map.of(
                '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
                '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");

        char[] charArr = digits.toCharArray();
        genHelper(res, new StringBuilder(), 0, letters, charArr);
        return res;
    }

    private void genHelper(List<String> res, StringBuilder sb, int i, Map<Character, String> letters, char[] charArr) {
        if (i == charArr.length) {
            res.add(sb.toString());
            return;
        }

        String letter = letters.get(charArr[i]);
        for (char c:  letter.toCharArray()) {
            sb.append(c);
            genHelper(res, sb, i+1, letters, charArr);
            sb.setLength(sb.length() -1);
        }
    }
}
