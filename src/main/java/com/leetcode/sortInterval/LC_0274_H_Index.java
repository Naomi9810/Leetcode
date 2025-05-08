package com.leetcode.sortInterval;

public class LC_0274_H_Index {
    public int hIndex(int[] citations) {
        // bucket sort
        int[] counts = new int[1001]; // covers number from 0-1000
        for (int cit: citations) {
            counts[cit]++;
        }

        int hIndex = 0;
        int sum = 0;
        for (int i = 1000; i >= 0; i--) {
            sum += counts[i];
            if (sum >= i) {
                return i;
            }

        }
        return hIndex;
    }
}
