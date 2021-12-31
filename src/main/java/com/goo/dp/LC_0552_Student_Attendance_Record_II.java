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
    static final long M = 1000000007;
    public int checkRecord(int n) {
        long[] f = new long[n <= 5 ? 6 : n + 1]; // only has P and L
        f[0] = 1;
        f[1] = 2;
        f[2] = 4; // LL, PP, LP, PL
        f[3] = 7; // 2*2*2 = 8 - 1 (LLL)
        for (int i = 4; i <= n; i++)
            f[i] = ((2 * f[i - 1]) % M + (M - f[i - 4])) % M;
        long sum = f[n];
        for (int i = 1; i <= n; i++) { //  insert A
            sum += (f[i - 1] * f[n - i]) % M;
        }
        return (int)(sum % M);
    }
}
