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
public class LC_0418_Sentence_Screen_Fitting {

  public int wordsTyping(String[] sentence, int rows, int cols) {
    String s = String.join(" ", sentence) + ""; // full sentence
    int pos = 0, len = s.length();
    for (int i = 0; i < rows; i++) {
      pos += cols;
      while (pos >= 0 && s.charAt(pos % len) != ' ') {
        pos--;
      }
      pos++;
    }
    return pos / len;
  }
}
