/**
 * Created by Sijia on 2/24/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.goo.twoPointer;

public class LC_0076_Minimum_Window_Substring {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0 || t.length() > s.length()) return "";
        int [] map = new int[128];
        for (char c : t.toCharArray()) {
            map[c]++;
        }
        int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE, counter = t.length();
        while (end < s.length()) {
            final char c = s.charAt(end);
            if (map[c] > 0) counter--;
            map[c]--;
            end++;
            while (counter == 0) {
                if (minLen > end - start) {
                    minLen = end - start; //  此处的end 已经++了
                    minStart = start;
                }
                final char remove = s.charAt(start);
                map[remove]++;
                if (map[remove] > 0) counter++; //  only the char in the t will be > 0
                start++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);

    }

}
