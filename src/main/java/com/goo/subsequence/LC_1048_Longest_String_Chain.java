package com.goo.subsequence;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1. sort
 * <p> 2. start from the longest, remove one char to form new word
 * <p> 3. use hashmap to track the longest
 */
public class LC_1048_Longest_String_Chain {

  public int longestStrChain(String[] words) {
    if (words == null || words.length == 0) {
      return 0;
    }
    int max = 0;
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
      max = Math.max(max, map.get(word));
    }
    return max;
  }
}
