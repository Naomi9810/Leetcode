package com.leetcode.twoPointer;

public class LC_0125_Valid_Palindrome {
    public boolean isPalindrome(String s) {
        if (s.length() == 1) return true;
        int len = s.length();

        int left = 0, right = len - 1;
        while (left < right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            if (!Character.isLetterOrDigit(leftChar)) {
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(rightChar)) {
                right--;
                continue;
            }
            if (Character.toLowerCase(leftChar) == Character.toLowerCase(rightChar)) {
                left++;
                right--;
            } else return false;

        }
        return true;

    }
}
