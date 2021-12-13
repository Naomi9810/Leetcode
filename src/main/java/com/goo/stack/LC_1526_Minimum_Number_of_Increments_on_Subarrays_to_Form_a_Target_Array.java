/**
 * Created by Sijia on 12/9/21
 * Time Complexity:
 * <p> O(N)
 * Space Complexity:
 * <p> O(1)
 * Hints:
 * <p> 1. Whenever the current element is bigger than the previous element,
 * we need at lease a - pre operations to make this difference - greedy
 * <p> 2.
 * <p> 3.
 */

package com.goo.stack;

public class LC_1526_Minimum_Number_of_Increments_on_Subarrays_to_Form_a_Target_Array {
    public int minNumberOperations(int[] target) {
        int res = 0, pre = 0;
        for (int n : target) {
            res += Math.max(n - pre, 0);
            pre = n;
        }
        return res;
    }
}
