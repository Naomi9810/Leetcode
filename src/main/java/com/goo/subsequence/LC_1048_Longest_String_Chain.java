package com.goo.subsequence;

import java.util.Arrays;
import java.util.HashMap;

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
    if (words == null || words.length == 0) {
      return 0;
    }
    int res = 0;
    Arrays.sort(words, (a, b) -> (a.length() - b.length())); // sort by length
    HashMap<String, Integer> map = new HashMap<>(); // word : its longest chain
    for (String word : words) {
      map.putIfAbsent(word, 1);
      for (int i = 0; i < word.length(); i++) {
        StringBuilder sb = new StringBuilder(word);
        String next = sb.deleteCharAt(i).toString(); // remove one char to form new word
        if (map.containsKey(next) && map.get(next) + 1 > map.get(word)) {
          // next word in the words, and the length is longer
          map.put(word, map.get(next) + 1);
        }
      }
      res = Math.max(res, map.get(word));
    }
    return res;
  }
}
