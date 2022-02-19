/**
 * Created by Sijia on 2/18/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.goo.substringAndString;

public class LC_0005_Longest_Palindromic_Substring {
        private int left, maxLen;

        public String longestPalindrome(String s) {
            int len = s.length();
            if (len < 2)
                return s;

            for (int i = 0; i < len-1; i++) {
                extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
                extendPalindrome(s, i, i+1); //assume even length.
            }
            return s.substring(left, left + maxLen);
        }

        private void extendPalindrome(String s, int i, int j) {
            while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
            }
            if (maxLen < j - i - 1) {
                left = i + 1;
                maxLen = j - i - 1;
            }
        }
}
