/**
 * Created by Sijia on 3/12/22
 * Time Complexity:
 * <p> O(N)
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1. map 存当前char最大的 idx
 * <p> 2. scan 扫一遍 当 i = idx 说明看过的 char 包含在i之前了 可以partition了 记录一个pre 的位置
 * <p> 3.
 */

package com.goo.greedy;

import java.util.ArrayList;
import java.util.List;

public class LC_0763_Partition_Labels {
    public List<Integer> partitionLabels(String S) {
        int[] maxIdx = new int[26];
        char[] charArr = S.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            char c = charArr[i];
            maxIdx[ c - 'a'] = i;
        }
        List<Integer> res = new ArrayList<>();

        int pre = 0, idx = 0;
        for (int i = 0; i < charArr.length; i++) {
            char c = charArr[i];
            idx = Math.max(idx,  maxIdx[ c - 'a']);
            if (i == idx) {
                res.add(i - pre + 1);
                pre = i+1;
            }
        }
        return res;
    }
}
