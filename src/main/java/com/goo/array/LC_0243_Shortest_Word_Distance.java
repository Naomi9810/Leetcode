/**
 * Created by Sijia on 3/15/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.goo.array;

public class LC_0243_Shortest_Word_Distance {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int idx1 = -1, idx2 = -1, shortest = Integer.MAX_VALUE;
        for (int i = 0; i < wordsDict.length;  i++) {
            if (word1.equals(wordsDict[i])) {
                idx1 = i;
            } else if (word2.equals(wordsDict[i])) {
                idx2 = i;
            }
            if (idx1 != -1 && idx2 != -1) {
                shortest = Math.min(shortest, Math.abs(idx1 - idx2));
            }
        }
        return shortest;
    }
}
