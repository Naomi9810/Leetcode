package com.leetcode.bit;

public class LC_0201_Bitwise_AND_of_Numbers_Range {
    public int rangeBitwiseAnd(int left, int right) {
        int shift = 0;
        // find the common 1111
        // if there is one 0, result will be 0
        while (left < right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }
        return left <<=shift;
    }
}
