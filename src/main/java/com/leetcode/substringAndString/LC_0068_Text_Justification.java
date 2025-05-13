/**
 * Created by Sijia on 1/1/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints: https://leetcode.com/problems/text-justification/discuss/1640627/Java-Much-more-readable-clean-1ms-solution-with-inline-comments!
 * <p> 1. exactly maxWidth characters
 * <p> 2. greedy approach
 * <p> 3. even space, left space >  right space
 * <p> 4. last line will be left-justified
 */

package com.leetcode.substringAndString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_0068_Text_Justification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        // greedy, if we can fit, otherwise add a new line

        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int space = 0;

        for (int i = 0; i < words.length; i++) {
            if (sb.isEmpty()) {
                sb.append(words[i]);
            } else if (sb.length() + words[i].length() + 1 <= maxWidth) {
                sb.append(" ").append(words[i]);
                space++;
            } else {
                // exceed
                res.add(justify(sb.toString(), space, maxWidth));
                sb = new StringBuilder();
                space = 0;
                i--;
            }
        }

        if (!sb.isEmpty()) {
            // last line
            res.add(justify(sb.toString(),0,maxWidth));
        }

        return res;
    }

    private String justify(String str, int space, int maxWidth) {
        if (str.length() == maxWidth) {
            return str;
        }

        int needSpace = maxWidth - str.length();
        // one word or last line
        if (space == 0) {
            return str+ " ".repeat(needSpace);
        }

        String[] spaceStr = new String[space];
        Arrays.fill(spaceStr, " ");

        // need add spaces
        int i = 0;
        while (needSpace-- > 0) {
            spaceStr[i] += " ";
            if (++i == space) {
                i=0;
            }
        }

        StringBuilder sb = new StringBuilder();

        String[] parts = str.split(" ");
        for (int j = 0; j < parts.length; j++) {
            sb.append(parts[j]);
            if (j < spaceStr.length) {
                sb.append(spaceStr[j]);
            }
        }

        return sb.toString();
    }
}
