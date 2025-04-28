/**
 * Created by Sijia on 12/28/21
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * Hints: first in first out, need to use a queue
 * <p> 1. which item should be considered, 比我当前值大的value， 没必要看比nums[i] 小的值， while keep 大值，加在后面，
 * <p> 2. 计算，queue 的 First 永远是max
 * <p> 3. Move window
 */

package com.leetcode.twoPointer;

import java.util.Deque;
import java.util.LinkedList;

public class LC_0239_Sliding_Window_Maximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) return new int[0];
        int len = nums.length;
        int[] res = new int[len - k + 1];
        Deque<Integer> idx = new LinkedList<>();

        for (int i = 0; i < len; i++) {
            while (!idx.isEmpty() && nums[idx.peekLast()] <= nums[i]) { // 如果当前的值比top的值大， 一直remove
                idx.removeLast();
            }
            idx.addLast(i); // 每次都add在后面排队， 前面的idx就小
            // calculate the result
            if (i - k + 1 >= 0) {
                res[i - k + 1] = nums[idx.peekFirst()];
            }
            // move the window 下一次就不能include idx = i-k+1的值
            if (i - k + 1 >= idx.peekFirst()) {
                idx.removeFirst(); // one time remove one
            }
        }
        return res;
    }
}
