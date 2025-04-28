package com.leetcode.design;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Time Complexity: O(N^2)
 * <p>
 * Space Complexity: O(N)
 * <p>
 * Hints:
 * <p> 1. we select a candidate who has a big "family", that is, the fewest 0 matched with other
 * words.
 * <p> 2.
 * <p> 3.
 */
public class LC_0843_Guess_the_Word {
    public void findSecretWord(String[] wordlist, Master master) {
        List<String> guessList = Arrays.asList(wordlist);
        while (true) {
            String guessed = getBestGuess(guessList);
            int match = master.guess(guessed);
            if (match == 6) return;
            guessList = getAllWordsWithMatchK(guessList, guessed, match);
        }

    }

    private String getBestGuess(List<String> wordlist) {
        int[][] count = new int[6][26];
        for (String w : wordlist) {
            for (int i = 0; i < w.length(); i++) {
                char ch = w.charAt(i);
                count[i][ch - 'a']++;
            }
        }
        int maxScore = 0;
        String bestWord = "";
        for (String w : wordlist) {
            int score = 0;
            for (int i = 0; i < w.length(); i++) {
                char ch = w.charAt(i);
                score += count[i][ch - 'a'];
            }
            if (score >= maxScore) {
                maxScore = score;
                bestWord = w;
            }
        }
        return bestWord;
    }

    private List<String> getAllWordsWithMatchK(List<String> wordlist, String input, int k) {
        List<String> result = new ArrayList<>();
        for (String w : wordlist) {
            if (getMatchCount(w, input) == k) {
                result.add(w);
            }
        }

        return result;
    }

    private int getMatchCount(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            count += (s1.charAt(i) == s2.charAt(i)) ? 1 : 0;
        }
        return count;
    }
}
