/**
 * Created by Sijia on 1/11/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1. Method 1: Use Treemap/Two Heaps to keep track of the max and min Time Complexity is NlogN
 * <p> 2. Method 2: Use two deques similar like 0239 need to use a queue, FIFO
 * https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/discuss/609771/JavaC%2B%2BPython-Deques-O(N)
 * <p> 3.
 */

package com.goo.twoPointer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeMap;

public class LC_1438_Longest_Continuous_Subarray_With_Absolute_Diff_Less_Than_or_Equal_to_Limit {
    public int longestSubarray(int[] nums, int limit) {
//        TreeMap<Integer, Integer> map =  new TreeMap<>();
//        int i = 0, j;
//        for (j = 0; j < nums.length; j++) {
//            map.put(nums[j], map.getOrDefault(nums[j], 0) +1); // count
//            if (map.lastKey() - map.firstKey() > limit) {
//                map.put(nums[i], map.getOrDefault(nums[i], 0) -1);
//                map.remove(nums[i], 0);
//                i++; // move the window
//            }
//        }
//        return j-i;
        Deque<Integer> maxDeque = new ArrayDeque<>(); // monotonic increasing Deque, the last is the max
        Deque<Integer> minDeque = new ArrayDeque<>(); // monotonic decreasing Deque, the last is the min
        int i = 0, j;
        for (j = 0; j < nums.length; j++) {
            while (!maxDeque.isEmpty() && nums[j] > maxDeque.peekLast()) {
                maxDeque.pollLast();
            }
            while (!minDeque.isEmpty() && nums[j] < minDeque.peekLast()) {
                minDeque.pollLast();
            }
            maxDeque.add(nums[j]);
            minDeque.add(nums[j]);
            // move the window
            if (maxDeque.peek() - minDeque.peek() > limit) {
                if (maxDeque.peek() == nums[i]) {
                    maxDeque.poll();
                }
                if (minDeque.peek() == nums[i]) {
                    minDeque.poll();
                }
                i++;
            }
        }
        return j - i;
    }

}
