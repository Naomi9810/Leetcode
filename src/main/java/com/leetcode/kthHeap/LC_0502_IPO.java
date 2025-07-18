package com.leetcode.kthHeap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC_0502_IPO {
    // if（w >= capital[i]），can do this project for free and get profit[i]
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;

        // Step 1: minCap
        Queue<int[]> minCapHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        for (int i = 0; i < n; i++) {
            minCapHeap.offer(new int[] { profits[i], capital[i] });
        }

        // Step 2: maxProfit
        Queue<Integer> maxProfitHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < k; i++) {
            // move the current can do project to maxProfit
            while (!minCapHeap.isEmpty() && minCapHeap.peek()[1] <= w) {
                maxProfitHeap.offer(minCapHeap.poll()[0]);
            }

            // no prj, break
            if (maxProfitHeap.isEmpty())
                break;

            // find the Max profit
            w += maxProfitHeap.poll();
        }

        return w;

    }
}
