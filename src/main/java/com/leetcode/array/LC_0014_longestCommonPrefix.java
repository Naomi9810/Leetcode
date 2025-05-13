package com.leetcode.array;

public class LC_0014_longestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {

        String shortest = strs[0];
        for (String str: strs) {
            if (str.length() < shortest.length()) {
                shortest = str;
            }
        }

        while (!shortest.isEmpty()) {
            for (int i = 0; i < strs.length; i++) {
                int len = shortest.length();
                if (!strs[i].substring(0, len).equals(shortest)) {
                    shortest = shortest.substring(0, len-1);
                    break;
                }
                if (i == strs.length - 1) {
                    return shortest;
                }
            }
        }
        return shortest;

    }
}
