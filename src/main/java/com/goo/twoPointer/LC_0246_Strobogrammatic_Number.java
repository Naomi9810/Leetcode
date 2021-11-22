package com.goo.twoPointer;

/**
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1. pay attention to the corner case
 * <p> 2.
 * <p> 3.
 */
public class LC_0246_Strobogrammatic_Number {

  public boolean isStrobogrammatic(String num) {
    for (int i = 0, j = num.length() - 1; i <= j; i++, j--) {
      char left = num.charAt(i);
      char right = num.charAt(j);
      if (i == j) {
        if (left == '0' || left == '1' || left == '8') {
        } else {
          return false;
        }
      } else {
        if (left == '6' && right == '9' || left == '9' && right == '6') {
        } else if (left == right && left == '1' || left == '8' || left == '0') {
        } else {
          return false;
        }
      }
    }
    return true;
  }
}
