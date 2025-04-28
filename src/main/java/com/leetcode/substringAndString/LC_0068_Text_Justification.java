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
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int i = 0, wordLen = 0, wordCount = 0;

        while (i < words.length) {
            if (sb.length() + words[i].length() <= maxWidth) {
                wordLen += words[i].length();
                wordCount++;
                sb.append(words[i++]).append(" "); // word 加一个空格的
            } else {
                String line = genLine(sb, wordCount, wordLen, maxWidth);
                res.add(line); // 加完之后 reset
                sb.setLength(0);
                wordLen = 0;
                wordCount = 0;
            }

        }
        // last line
        while (sb.length() != 0 && sb.length() <= maxWidth) {
            sb.append(" ");
        }
        sb.setLength(maxWidth);
        res.add(sb.toString());
        return res;

    }

    private String genLine(StringBuilder sb, int wordCount, int wordLen, int maxWidth) {
        if (wordCount == 1) {
            while (sb.length() <= maxWidth) {
                sb.append(" ");
            }
            sb.setLength(maxWidth);
            return sb.toString();
        }

        int spaceCount = (maxWidth - wordLen) / (wordCount-1);
        int extraSpace =  (maxWidth - wordLen) % (wordCount-1);
        String space = " ".repeat(spaceCount);
        String[] spaceArr = new String[wordCount-1];
        Arrays.fill(spaceArr, space);
        for (int i = 0; i < extraSpace; i++) {
            spaceArr[i] += " ";
        }
        String[] splited = sb.toString().split(" ");
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < splited.length; i++) {
            line.append(splited[i]);
            if (i < spaceArr.length) {
                line.append(spaceArr[i]);
            }
        }
        return line.toString();
    }
}
