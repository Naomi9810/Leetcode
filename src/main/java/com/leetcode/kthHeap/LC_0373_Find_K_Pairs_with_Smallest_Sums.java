/**
 * Created by Sijia on 3/16/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.leetcode.kthHeap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class LC_0373_Find_K_Pairs_with_Smallest_Sums {
    /*
    1. build a minHeap
    2. add i, 0 num1[i] + num2[0] into minHeap
    3. poll and add to res
    4. offer new i, j + 1 num1[i] + num2[j+1]  (if j+1 = len2 continue
    * */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        List<List<Integer>> res = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return res;
        for (int i = 0; i < nums1.length && i < k; i++)
            minHeap.offer(new int[]{i, 0, nums1[i] + nums2[0]});
        while (k-- > 0 && !minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int i = curr[0], j = curr[1];
            res.add(Arrays.asList(nums1[i], nums2[j]));
            if (j + 1 == nums2.length) continue;
            minHeap.offer(new int[]{i, j + 1, nums1[i] + nums2[j + 1]});
        }
        return res;
    }
}
