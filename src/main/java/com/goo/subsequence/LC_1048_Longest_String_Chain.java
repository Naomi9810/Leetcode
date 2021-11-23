package com.goo.subsequence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1. longest word chain,
 * <p> 2.  the start from the longest by deleting the letter and see if we can find it in the set?
 * <p> 3.
 */
public class LC_1048_Longest_String_Chain {

  public int longestStrChain(String[] words) {
    Map<String, Integer> wordMap = new HashMap<>();
    for (String word : words) {
      wordMap.putIfAbsent(word, 0);
    }
    int max = 1;
    for (String word : words) {
      max = Math.max(max, getChainLen(wordMap, word));
    }
    return max;
  }

  private int getChainLen(Map<String, Integer> wordMap, String word) {
    // try remove one letter from the given word and see if we can find a match in wordSet:
    if (wordMap.containsKey(word) && wordMap.get(word) != 0) {
      return wordMap.get(word);
    }
    boolean match = true;
    while (match) {
      for (String newWord : deleteOneChar(word)) {
        if (wordMap.containsKey(newWord)) {
          wordMap.put(word, wordMap.get(word) +1);
          return wordMap.get(word);
        }
      }
      match = false;
    }
    wordMap.put(word, 1);
    return 1;
  }

  private Set<String> deleteOneChar(String word) {
    // generate list of string by delete one char
    Set<String> res = new HashSet<>();
    if (word.length() <= 1) {
      return res;
    }
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < word.length(); i++) {
      for (int j = 0; j < word.length(); j++) {
        if (i != j) {
          sb.append(word.charAt(j));
        }
      }
      res.add(sb.toString());
      sb = new StringBuffer();
    }
    return res;
  }
}
