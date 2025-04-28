package com.leetcode.subsequence;

import java.util.List;

/**
 * Time Complexity: worst case all the dictionary can be found in the s, so O(M*N) M is the
 * dictionary size, N is the longest len in the String
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */
public class LC_0524_Longest_Word_in_Dictionary_through_Deleting {

  public String findLongestWord(String s, List<String> dictionary) {
    String res = "";
    for (int i = 0; i < dictionary.size(); i++) {
      String sub = dictionary.get(i);
      if (isSubSq(s, sub)) {
        // find match case:
        if (res.length() < sub.length() || (res.length() == sub.length()
            && sub.compareTo(res) < 0)) {
          // two update cases:
          res = sub;
        }
      }
    }
    return res;
  }

  //  general function check is SubSq
  private boolean isSubSq(String str, String sub) {
    int i = 0, j = 0;
    while (i < str.length() && j < sub.length()) {
      if (str.charAt(i) == sub.charAt(j)) {
        i++;
        j++;
      } else {
        i++; // str delete char in str means, skip
      }
    }
    return j == sub.length(); //  sub idx finish, find all matching chars
  }
}
