package com.goo.substringAndString;

/**
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */
public class LC_1525_Number_of_Good_Ways_to_Split_a_String {

  public int numSplits(String s) {
    int len = s.length();
    int[] leftUni = new int[len];
    int[] rightUni = new int[len];
    int left = 0, right = 0;
    Integer[] letter = new Integer[26];
    for (int i = 0; i < len; i++) {
      char c = s.charAt(i);
      if (letter[c - 'a'] == null) {
        // find the unique letter
        letter[c - 'a']++;
        left++;
      }
      leftUni[i] = left;
    }
    letter = new Integer[26];
    for (int j = len - 1; j > 0; j--) {
      char c = s.charAt(j);
      if (letter[c - 'a'] == null) {
        // find the unique letter
        letter[c - 'a']++;
        right++;
      }
      rightUni[j] = right;
    }
    int count = 0;
    for (int i = 0; i + 1 < len; i++) {
      if (leftUni[i] == rightUni[i + 1]) {
        count++;
      }
    }
    return count;
  }

}
