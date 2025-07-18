/**
 * Created by Sijia on 2/19/22
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

public class LC_215_Kth_Largest_Element_in_an_Array {
    public int findKthLargest(int[] nums, int k) {
        // PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k+1);
        // for (int num: nums) {
        //     minHeap.add(num);
        //     if (minHeap.size() > k) {
        //         minHeap.poll();
        //     }
        // }
        // return minHeap.peek();

        // quick sort method

        if (nums == null || nums.length == 0) return Integer.MAX_VALUE;
        return findKthSmallest(nums, 0, nums.length - 1, nums.length - k);
        //  第k大 就是 第n+1-k 小 quick select idx n+1-k-1 = n-k
    }

    public int findKthSmallest(int[] nums, int start, int end, int k) {// quick select: kth smallest
        if (start > end) return Integer.MAX_VALUE;

        int pivot = nums[end];// Take A[end] as the pivot,
        int j = start;
        for (int i = start; i < end; i++) {
            if (nums[i] <= pivot) // Put numbers < pivot to pivot's left
                swap(nums, j++, i);
        }
        swap(nums, j, end);// Finally, swap A[end] with A[left]

        // Found the kth the smallest number
        if (j == k)
            return nums[j];
        else if (j < k)// Check right part
            return findKthSmallest(nums, j + 1, end, k);
        else // Check left part
            return findKthSmallest(nums, start, j - 1, k);
    }

    public static void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
