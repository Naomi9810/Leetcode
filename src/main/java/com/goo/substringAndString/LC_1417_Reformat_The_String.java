package com.goo.substringAndString;

/**
 * Time Complexity: O(N) go it twice
 * <p>
 * Space Complexity:
 * <p>
 * Hints: String.valueOf(char[]) -> will convert it to String,  char[] can't directly toString()
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */
public class LC_1417_Reformat_The_String {

  public String reformat(String s) {
    if (s == null || s.length() == 0) {
      return "";
    }
    int digitCount = 0;
    int letterCount = 0;

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c >= '0' && c <= '9') {
        digitCount++;
      } else {
        letterCount++;
      }
    }
    if (Math.abs(digitCount - letterCount) > 1) {
      return "";
    }

    boolean firstNum = digitCount >= letterCount;
    StringBuilder sb = new StringBuilder();
    char[] arr = s.toCharArray();
    for (int i = 0, d = 0, l = 0; i < s.length(); i++) {
      if (firstNum) {
        while(!Character.isDigit(arr[d])) {
          d++;
        }
        sb.append(arr[d++]);
      } else {
        while(!Character.isLetter(arr[l])) {
          l++;
        }
        sb.append(arr[l++]);
      }
      firstNum = !firstNum;
    }
    return sb.toString();
  }

}
