/**
 * Created by Sijia on 12/30/21
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1. only one A is allows so consider the pure L and P cases then insert A
 * https://leetcode.com/problems/student-attendance-record-ii/discuss/101638/Simple-Java-O(n)-solution
 * three cases:
 * 1. (valid sequence length 𝑛−1)P
 * 2. (valid sequence length 𝑛−2)PL
 * 3. (valid sequence length 𝑛−3)PLL
 * 𝑓[𝑛]=𝑓[𝑛−1]+𝑓[𝑛−2]+𝑓[𝑛−3]
 * 𝑓[𝑛−1]=𝑓[𝑛−2]+𝑓[𝑛−3]+𝑓[𝑛−4]
 * -> 𝑓[𝑛]=2𝑓[𝑛−1]−𝑓[𝑛−4]
 */

package com.goo.dp;

public class LC_0552_Student_Attendance_Record_II {
    public int checkRecord(int n) {
        long[] PorL = new long[n + 1]; //  valid reward with ending P or L, no A
        long[] P = new long[n + 1]; //  valid reward with ending P, no A
        PorL[0] = P[0] = 1;
        PorL[1] = 2; P[1] = 1;

        for (int i = 1; i <=n ;i++) {
            P[i] = PorL[i-1]; // just appending P in the PorL
            PorL[i] = (P[i] + P[i - 1] + P[i - 2]) % M; //P[i] end with P, P[i-1], end with one L(or PL), P[i-2], end with two L(or LL).
        }

    }
}
