/*
 * Created by Sijia on 2/17/22
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

import java.util.HashSet;
import java.util.Set;

public class LC_0003_Longest_Substring_Without_Repeating_Char {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        Set<Character> set = new HashSet<>();
        int i = 0, res = 0;

        for (int j = 0; j < s.length(); ) {
            char c = s.charAt(j);
            if (!set.contains(c)) {
                set.add(c);
                res = Math.max(res, set.size()); // size 就是长度
                j++; // 只有符合条件才往前move
            } else {
                // 不存idx 一直删除直到再次满足条件为止
                set.remove(s.charAt(i++));
            }
        }
        return res;
    }
}
