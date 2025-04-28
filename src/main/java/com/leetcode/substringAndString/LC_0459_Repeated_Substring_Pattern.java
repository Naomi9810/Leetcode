package com.leetcode.substringAndString;

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
    int[] prefix = kmp(s);
    int len = s.length();
    int patternLen = prefix[len - 1];
    return (patternLen > 0 && len % (len - patternLen) == 0);
  }

  private int[] kmp(String s) {
    int len = s.length();
    int[] res = new int[len];
    int i = 0, j = 1;
    res[0] = 0;
    while (i < len && j < len) {
      if (s.charAt(i) == s.charAt(j)) {
        res[j] = i + 1; // pattern的长度
        i++;
        j++;
      } else {
        if (i == 0) {
          res[j] = 0; // no pattern was found since start
          j++;
        } else {
          i = res[i - 1];
          // no pattern was found after i moved, i goes back to the previous pattern len
        }
      }
    }
    return res;
  }

}
