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

package com.goo.substringAndString;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC_0068_Text_Justification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        Queue<String> wordList = new LinkedList<>(); // FIFO to poll the word from the list
        int textWidth = 0; //  current pure text width

        // build the wordList for each line:
        for (int i = 0; i < words.length; ) {
            if (textWidth + words[i].length() + wordList.size() <= maxWidth) { //  current pure text width + next word + current text space
                textWidth += words[i].length();
                wordList.add(words[i++]);
                continue;
            }

            int spaceBtw = (maxWidth - textWidth) / Math.max(1, wordList.size() - 1);
            int spaceExtra = (maxWidth - textWidth) % Math.max(1, wordList.size() - 1);

            String line = createLine(wordList, maxWidth, spaceBtw, spaceExtra--); // wordList will be polled empty
            res.add(line);
            textWidth = 0; // reset
        }

        String lastLine = createLine(wordList, maxWidth, 1, 0);
        res.add(lastLine);
        return res;
    }

    private String createLine(Queue<String> wordList, int maxWidth, int spaceBtw, int spaceExtra) {
        StringBuilder sb = new StringBuilder();
        while (!wordList.isEmpty()) {
            sb.append(wordList.poll())
                    .append(wordList.isEmpty() ? "" : addSpace(spaceBtw)) //no need to append last word
                    .append(spaceExtra-- > 0 ? " " : "");
        }

        if (sb.length() < maxWidth) {
            sb.append(addSpace(maxWidth - sb.length()));
        }
        return sb.toString();
    }

    private String addSpace(int spaceCount) {
        StringBuilder spaces = new StringBuilder();
        while (spaceCount-- > 0) {
            spaces.append(" ");
        }
        return spaces.toString();
    }
}
