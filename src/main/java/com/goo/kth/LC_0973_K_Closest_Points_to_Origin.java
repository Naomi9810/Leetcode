/**
 * Created by Sijia on 2/21/22
 * Time Complexity:
 * <p> NlogK heap
 *     average quickSelect  worst case N^2
 * Space Complexity:
 * <p>
 * Hints:  https://leetcode.com/problems/k-closest-points-to-origin/discuss/220235/Java-Three-solutions-to-this-classical-K-th-problem.
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.goo.kth;

import java.util.Arrays;

public class LC_0973_K_Closest_Points_to_Origin {
    public int[][] kClosest(int[][] points, int k) {
        if (k == points.length) {
            return points;
        }
        quickSelect(points, 0, points.length - 1, k - 1);
        return Arrays.copyOfRange(points, 0, k);

//        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(getDist(b), getDist(a)));
//        int[][] res = new int[k][2];
//        int i = 0;
//
//        for (int[] point: points) {
//            maxHeap.offer(point);
//            if (maxHeap.size() > k) {
//                maxHeap.poll();
//            }
//        }
//
//        while (!maxHeap.isEmpty()) {
//            res[i++] = maxHeap.poll();
//        }
//        return res;
    }

    public void swap(int[][] points, int i, int j) {
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }

    public int partition(int[][] points, int start, int high) {
        int valuePivot = getDist(points[high]);
        int i = start;
        for (int j = start; j < high; j++) {
            if (getDist(points[j]) < valuePivot) {
                swap(points, i++, j);
            }
        }
        swap(points, i, high);
        return i;
    }

    public int quickSelect(int[][] points, int low, int high, int k) {
        int pivot = partition(points, low, high);
        if (pivot == k) {
            return pivot;
        } else if (pivot < k) {
            quickSelect(points, pivot + 1, high, k);
        } else {
            quickSelect(points, low, pivot - 1, k);
        }

        return pivot;
    }



    public int getDist(int[] arr) {
        return arr[0] * arr[0] + arr[1] * arr[1];
    }

}
