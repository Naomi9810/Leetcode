/**
 * Created by Sijia on 12/30/21
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1. only one A is allows so consider the pure L and P cases then insert A
 * https://leetcode.com/problems/student-attendance-record-ii/discuss/101638/Simple-Java-O(n)-solution
 * three cases: 只有这三种 case是valid的 前面是 valid的sequence 怎么不重复的加 才能保持valid
 * 1. (valid sequence length 𝑛−1)P
 * 2. (valid sequence length 𝑛−2)PL
 * 3. (valid sequence length 𝑛−3)PLL
 * 𝑓[𝑛]=𝑓[𝑛−1]+𝑓[𝑛−2]+𝑓[𝑛−3]
 * 𝑓[𝑛−1]=𝑓[𝑛−2]+𝑓[𝑛−3]+𝑓[𝑛−4]
 * -> 𝑓[𝑛]=2𝑓[𝑛−1]−𝑓[𝑛−4]
 */

package com.leetcode.dp;

public class LC_0552_Student_Attendance_Record_II {
    static final int M = 1000000007;
    public int checkRecord(int n) {
        long[] end_PL = new long[n + 1]; // the possible valid record for P and L
        long[] end_P = new long[n + 1];

        end_PL[0] = end_P[0] = 1;
        end_PL[1] = 2; // P or L
        end_P[1] = 1; // P

        for (int i = 2; i <= n; i++) {
            end_P[i] = end_PL[i - 1]; // just append P after valid end_PL
            end_PL[i] = (end_P[i] + end_P[i - 1] + end_P[i - 2]) % M;
        }

        long res = end_PL[n]; // [0, i] n=i [i+1， n] len = n-i-1
        for (int i = 0; i < n; i++) {
            long s = end_PL[i] * end_PL[n - i - 1];
            res = (res + s) % M;
        }
        return (int) res;
    }
}
