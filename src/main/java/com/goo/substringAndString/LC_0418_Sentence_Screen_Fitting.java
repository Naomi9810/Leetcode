package com.goo.substringAndString;

/**
 * Time Complexity:
 * <p> worst case for each row we need to loop O(N * cols + rows)
 * Space Complexity:
 * <p> O(N) N is the sentence len
 * Hints:
 * <p> 1. join to form a full sentence + " ", " "  is because each single space is needed.
 * <p> 2.
 * <p> 3.
 */
public class LC_0418_Sentence_Screen_Fitting {

  public int wordsTyping(String[] sentence, int rows, int cols) {
    String fullSentence = String.join(" ", sentence) + " "; // full sentence
    int total = 0, len = fullSentence.length(); //  total is the counter for how many valid characters from fullSentence
    // have been put to our screen
    for (int i = 0; i < rows; i++) {
      total += cols; // every time add the whole cols
      while (total >= 0 && fullSentence.charAt(total % len) != ' ') { // letter can't be divided, so must find the " " as the break point
        total--; // move to left idx to find the break
      }
      total++; // move forward to fit the next char
    }
    return total / len;
  }
}
