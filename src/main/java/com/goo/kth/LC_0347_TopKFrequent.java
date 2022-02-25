/**
 * Created by Sijia on 2/24/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:   https://leetcode.com/problems/top-k-frequent-elements/discuss/179084/Bucket-Sort-Java-with-Explanation
 * // O(nums.length) time because we iterate nums to create the frequency map and then do a bucket sort.
 * // O(nums.length) space because of the array we use for bucket sort, also all numbers could be distinct
 * and in this case the HashMap would have one entry for each element.
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.goo.kth;

import java.util.*;

public class LC_0347_TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == k) return nums;

        Map<Integer, Integer> map = new HashMap<>();
        for (int n: nums) {
            map.put(n, map.getOrDefault(n, 0)+1);
        }

        Queue<Integer> minHeap = new PriorityQueue<>((a, b) -> (Integer.compare(map.get(a), map.get(b))));
        for (int n: map.keySet()) {
            minHeap.add(n);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] res = new int[k];
        while (!minHeap.isEmpty()) {
            res[--k] = minHeap.poll();
        }
        return res;
    }
}
