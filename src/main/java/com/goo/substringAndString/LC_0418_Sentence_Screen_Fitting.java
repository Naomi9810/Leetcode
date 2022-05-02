package com.goo.substringAndString;

/**
 * Time Complexity:
 * <p> worst case for each row we need to loop O(N * cols + rows)
 * Space Complexity:
 * <p> O(N) N is the sentence len
 * Hints:
 * <p> 1. join to form a full sentence + " ", " "  is because each single space is needed.
 * <p> 2. https://github.com/wisdompeak/LeetCode/tree/master/String/418.Sentence-Screen-Fitting
 * <p> 3.
 */
public class LC_0418_Sentence_Screen_Fitting {

  public int wordsTyping(String[] sentence, int rows, int cols) {
    String full = "";
    for (String w: sentence) {
      if (w.length() > cols) return 0;
      full += w + " ";
    }
    int fullLen = full.length();
    int total = 0; // total is the counter for how many valid characters from fullSentence
    for (int j = 0; j < rows; j++) {
      total += cols; // every time add the whole cols
      while (full.charAt(total % fullLen) != ' ') {
        total--;
      }
      total++;
    }
    return total/fullLen;
  }
}
