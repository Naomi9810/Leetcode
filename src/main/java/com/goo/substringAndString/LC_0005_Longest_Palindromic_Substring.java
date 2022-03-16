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
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        char[] charArr = s.toCharArray();
        int maxLen = 1;
        int maxStart = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i-1 >=0 && charArr[i] == charArr[i-1] ) {
                int[] res = span(charArr, i-1, i);
                if ( res[1] > maxLen) {
                    maxLen = res[1];
                    maxStart = res[0];
                }
            } // 不要轻易写else 互斥结果
            if (i-1 >=0 && i+1 < s.length() && charArr[i+1] == charArr[i-1] ) {
                int[] res = span(charArr, i-1, i+1);
                if ( res[1] > maxLen) {
                    maxLen = res[1];
                    maxStart = res[0];
                }
            }
        }
        return s.substring(maxStart, maxStart+maxLen);

    }

    private int[] span(char[] charArr, int start, int end) {
        while (start >= 0 && end < charArr.length && charArr[start] == charArr[end]) {
            start--;
            end++;
        }
        return new int[] {start + 1, end - start - 1}; //start, maxLen;
    }
}
