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

package com.leetcode.binarySearch;

import java.util.ArrayList;
import java.util.List;

public class LC_0295_Find_Median_from_Data_Stream_1 {
    List<Integer> list;

    public void MedianFinder() {
        list = new ArrayList<>();
    }

    public void addNum(int num) {
        // binary search 找到insert的位置
        int left = 0, right = list.size()-1;
        while (left  <= right) {
            int mid = left + (right - left)/2;
            if (num == list.get(mid)) {
                left = mid;
                break;
            }
            else if (num < list.get(mid)) {
                right = mid -1;
            } else {
                left = mid + 1;
            }
        }
        list.add(left, num);
    }

    public double findMedian() {
        int count = list.size();
        if (count%2!=0) {
            int mid = count/2;
            return (double)list.get(mid);
        } else {
            int mid = (count-1)/2;
            return  ((double)list.get(mid)+(double)list.get(mid+1))/2;
        }

    }
}
