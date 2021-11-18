package com.goo.substring;

/**
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1. KMP issue, find pattern:  https://www.geeksforgeeks.org/kmp-algorithm-for-pattern-searching/
 * <p> 2.
 * <p> 3.
 */
public class LC_0459_Repeated_Substring_Pattern {

  public boolean repeatedSubstringPattern(String s) {
    // two pointer:
    int i = 0;
    int j = 1; //  move fast
    int len = s.length();
    while (i < len && j < len) {
      if (s.charAt(i) == s.charAt(j)) {
        i++;
        j++;
      } else {
        j++;
      }
    }
    return (i > 0 && len % (len - i) == 0);
  }

}
