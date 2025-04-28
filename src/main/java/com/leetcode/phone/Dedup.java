/**
 * Created by Sijia on 2/22/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.leetcode.phone;

import java.util.Arrays;

public class Dedup {
    public int[] dedup(int[] arr) {
        if (arr.length == 1) return arr;
        int i = 0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[j] == arr[i]) continue;
            if (++i < arr.length) {
                arr[i] = arr[j];
            }
        }
        return Arrays.copyOfRange(arr, 0, i + 1);
    }
}




