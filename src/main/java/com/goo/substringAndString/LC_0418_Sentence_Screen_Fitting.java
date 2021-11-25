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
    String s = String.join(" ", sentence) + " "; // full sentence
    int pos = 0, len = s.length(); //  pos is the counter for how many valid characters from s
    // have been put to our screen
    for (int i = 0; i < rows; i++) {
      pos += cols;
      while (pos >= 0 && s.charAt(pos % len) != ' ') { // find the " " the break point
        pos--;
      }
      pos++;
    }
    return pos / len;
  }
}
