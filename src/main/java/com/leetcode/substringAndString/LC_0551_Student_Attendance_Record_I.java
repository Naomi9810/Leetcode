/**
 * Created by Sijia on 12/29/21
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1. substring "LLL"
 * <p> 2.
 * <p> 3.
 */

package com.leetcode.substringAndString;

public class LC_0551_Student_Attendance_Record_I {
    public boolean checkRecord(String s) {
//        int absence = 0;
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (c == 'A') {
//                absence++;
//                if (absence >= 2) {
//                    return false;
//                }
//            } else if (c == 'L') {
//                int count = 0;
//                while (i + count < s.length() && s.charAt(i + count) == 'L') {
//                    count++;
//                    if (count == 3) return false;
//                }
//            }
//        }
//        return true;
        return !s.contains("LLL") && (s.indexOf("A") == s.lastIndexOf("A"));
    }
}
