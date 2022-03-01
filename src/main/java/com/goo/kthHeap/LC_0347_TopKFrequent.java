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

package com.goo.kthHeap;

import java.util.*;

public class LC_0347_TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
    if (nums.length == k) return nums;

    Map<Integer, Integer> map = new HashMap<>();
        for (int n: nums) {
        map.put(n, map.getOrDefault(n, 0)+1);
    }

    int[] uni = new int[map.size()];
    int i = 0;
        for (int n: map.keySet()) {
        uni[i++] = n;
    }

//         Queue<Integer> minHeap = new PriorityQueue<>((a,b) -> (Integer.compare(map.get(a), map.get(b))));
//         for (int n: map.keySet()) {
//             minHeap.add(n);
//             if (minHeap.size() > k) {
//                 minHeap.poll();
//             }
//         }

    //         int[] res = new int[k];
//         while (!minHeap.isEmpty()) {
//             res[--k] = minHeap.poll();
//         }
//         return res;
    int len = uni.length;
    findK(uni, map, 0, len-1, len - k); // len-k 小 == k 大

      return Arrays.copyOfRange(uni, len-k, len); //   从左往右 从大到小

}

    private int findK(int[] nums, Map<Integer, Integer> map, int start, int end, int k) {
        int pivot = partition (nums, map, start, end);
        if (pivot == k) {
            return pivot;
        } else if (pivot > k) {
            findK(nums, map, start, pivot-1, k);
        } else {
            findK(nums, map, pivot+1, end, k);
        }
        return pivot;
    }

    private int partition(int[] nums, Map<Integer, Integer> map, int start, int end) {
        if (start > end) return Integer.MAX_VALUE;

        int val = map.get(nums[end]);
        int j = start;
        for (int i = start; i < end; i++) {
            if (map.get(nums[i]) <= val) {
                swap(nums, j++, i);
            }
        }
        swap(nums, j, end);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
