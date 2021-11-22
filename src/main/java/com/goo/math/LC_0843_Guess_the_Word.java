package com.goo.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
    for (int guess = 0, ans = 0; guess < 10 && ans < 6; guess++) {
      int count[][] = new int[6][26], best = 0;
      for (String w : wordlist) {
        for (int j = 0; j < 6; j++) {
          count[j][w.charAt(j) - 'a']++;
          // each idx the char count
        }
      }
      String guessWord = wordlist[0];

      for (String w : wordlist) {
        int score = 0;
        for (int j = 0; j < 6; j++) {
          score += count[j][w.charAt(j) - 'a'];
        }
        if (score > best) {
          guessWord = w;
          best = score;
        }
      }

      ans = Master.guess(guessWord);
      List<String> wordlist2 = new ArrayList<>();
      for (String w : wordlist) {
        if (match(guessWord, w) == ans) {
          wordlist2.add(w);
        }
      }
      wordlist = wordlist2.toArray(new String[0]);
    }
  }

  private int match(String secret, String guess) {
    int match = 0;
    for (int i = 0; i < secret.length(); i++) {
      if (secret.charAt(i) == guess.charAt(i)) {
        match++;
      }
    }
    return match;
  }
}
