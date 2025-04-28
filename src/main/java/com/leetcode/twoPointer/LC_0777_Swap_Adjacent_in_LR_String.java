/**
 * Created by Sijia on 2/10/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints: https://leetcode.com/problems/swap-adjacent-in-lr-string/discuss/113789/Simple-Java-one-pass-O(n)-solution-with-explaination
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.leetcode.twoPointer;

public class LC_0777_Swap_Adjacent_in_LR_String {
    public boolean canTransform(String start, String end) {
        if (!start.replace("X", "").equals(end.replace("X", ""))) {
            return false; //  without x the order should be the same
        }
        int p1 = 0, p2 = 0, len = start.length();
        while (p1 < len && p2 < len) {
            // all go to non-x position
            while (p1 < len && start.charAt(p1) == 'X') {
                p1++;
            }

            while (p2 < len && end.charAt(p2) == 'X') {
                p2++;
            }

            if (p1 == len && p2 == len) {
                return true;
            }

            if (p1 == len || p2 == len) {
                return false;
            }

            //XL -> LX left only goes left, RX -> XR: right only goes right
            if (start.charAt(p1) == 'L' && p1 < p2) {
                return false;
            }

            if (start.charAt(p1) == 'R' && p1 > p2) {
                return false;
            }
            // can swap
            p1++;
            p2++;
        }
        return true;
    }
}
