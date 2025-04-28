/**
 * Created by Sijia on 12/26/21
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints: https://leetcode.com/problems/max-value-of-equation/discuss/710434/C%2B%2BJava-O(n)-minimalizm
 * <p> 1. sorted by the x-values
 * <p> 2. yi + yj + |xi - xj| == yi + yj + xj - xi when xi > xj; first in first out.
 * <p> 3. when to calculate the equation? xi - xj <= k so when > k, we keep polling
 */

package com.leetcode.twoPointer;

import java.util.Deque;
import java.util.LinkedList;

public class LC_1499_Max_Value_of_Equation {
    public int findMaxValueOfEquation(int[][] points, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < points.length; i++) {
            while (!deque.isEmpty() && points[i][0] - points[deque.peek()][0] > k) {
                deque.poll(); // 不符合条件的 都从前面poll出去， 因为是排好序的如果临近的两个不符合条件，其他的更不可能符合条件
            }
            if (!deque.isEmpty()) {
                int top = deque.peek();// only peek, no need to poll
                // 满足条件 calculate the result
                // i must be larger than the top because top already in the deque with a smaller idx
                res = Math.max(res, points[top][1] - points[top][0] + points[i][1] + points[i][0]);
            }
            while (!deque.isEmpty() && points[deque.peekLast()][1] - points[deque.peekLast()][0] < points[i][1] - points[i][0]) {
                deque.removeLast();
                // we just remove all elements with smaller y - x from the back of the deque， y-x 的值尽可能大
            }
            deque.add(i);
        }
        return res;
    }

//    public int findMaxValueOfEquation(int[][] points, int k) {
//        int result = Integer.MIN_VALUE;
//        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[1] - b[0] - (a[1] - a[0]))); // y-x 的值
//        for (int[] point : points) {
//            while (!pq.isEmpty() && point[0] - pq.peek()[0] > k) {
//                pq.poll();
//            }
//            if (!pq.isEmpty()) {
//                int[] head = pq.peek();
//                result = Math.max(result, point[1] + head[1] + point[0] - head[0]);
//            }
//            pq.offer(point);
//        }
//
//        return result;
//    }
}
