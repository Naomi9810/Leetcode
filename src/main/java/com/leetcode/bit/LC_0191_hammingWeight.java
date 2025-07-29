package com.leetcode.bit;

public class LC_0191_hammingWeight {
    public int hammingWeight(int n) {
        int res = 0;

        for (int i = 0; i < 31; i++) {
            res += (n & 1);
            n >>=1;
        }
        return res;

    }
}
