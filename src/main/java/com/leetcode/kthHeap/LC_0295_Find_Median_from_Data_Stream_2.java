/**
 * Created by Sijia on 2/28/22
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

import java.util.PriorityQueue;

public class LC_0295_Find_Median_from_Data_Stream_2 {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    boolean even;

    public void MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b,a));
        minHeap = new PriorityQueue<>();
        even = true;
    }

    public void addNum(int num) {
        if (even) {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        } else {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }
        even = !even;
    }

    public double findMedian() {
        if (even) {
            return (minHeap.peek() + maxHeap.peek())/2.0;
        } else {
            return maxHeap.peek();
        }

    }

}
