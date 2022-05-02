/**
 * Created by Sijia on 4/23/22
 * Time Complexity:
 * Space Complexity:
 * Hints:
 * <p> 1. concatenate 就是往前挪动binary.length()次 注意要先用long 否则会导致结果不对
 * <p> 2.
 * <p> 3.
 */

package com.goo.mathBitMatrix;

public class LC_1680_Concatenation_of_Consecutive_Binary_Numbers {
    public int concatenatedBinary(int n) {
        final int MOD = 1000000007;
        long res = 0;
        for (int i = 0; i <= n; i++) {
            String binary = Integer.toBinaryString(i);
            int len = binary.length();
            res = ((res << len) + i ) % MOD;
        }
        return (int) res;
    }
}
