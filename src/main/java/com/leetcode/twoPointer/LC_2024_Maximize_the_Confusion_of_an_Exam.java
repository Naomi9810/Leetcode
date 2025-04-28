/**
 * Created by Sijia on 3/5/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.leetcode.twoPointer;

public class LC_2024_Maximize_the_Confusion_of_an_Exam {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int tCount = 0, fCount = 0;
        int start = 0, len = 0;
        for (int i = 0; i < answerKey.length(); i++) {
            char c = answerKey.charAt(i);
            if (c == 'T') tCount++;
            else {
                fCount++;
            }
            int same = Math.max(tCount, fCount);

            if (i - start + 1 - same > k) {
                char remove = answerKey.charAt(start);
                if (remove == 'T') tCount--;
                else {
                    fCount--;
                }
                start++;
            }
            len = Math.max(len, i - start + 1);
        }
        return len;

    }
}
