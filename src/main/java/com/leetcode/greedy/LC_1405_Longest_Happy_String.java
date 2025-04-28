/**
 * Created by Sijia on 3/19/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.leetcode.greedy;

public class LC_1405_Longest_Happy_String {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        int countA = 0, countB = 0, countC = 0;
        int size = a + b + c;

        for (int i = 0; i < size; i++) {
            if (a >= b && a >= c && countA < 2 || countB == 2 && a > 0 || countC == 2 && a > 0) {
                a--;
                sb.append("a");
                countA++;
                countB = 0;
                countC = 0;
            } else if (b >= a && b >= c && countB < 2 || countA == 2 && b > 0 || countC == 2 && b > 0) {
                b--;
                sb.append("b");
                countB++;
                countA = 0;
                countC = 0;
            } else if (c >= a && c >= b && countC < 2 || countA == 2 && c > 0 || countB == 2 && c > 0) {
                c--;
                sb.append("c");
                countC++;
                countA = 0;
                countB = 0;
            }
        }
        return sb.toString();
    }
}
