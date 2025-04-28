/**
 * Created by Sijia on 12/9/21
 * Time Complexity:
 * <p> O(N)
 * Space Complexity:
 * <p> O(1)
 * Hints:
 * <p> 1. Whenever the current element is bigger than the previous element,
 * we need at lease a - pre operations to make this difference - greedy
 * 我们将target数组想象成连绵起伏的山峦。我们在上坡走的时候，每一步肯定都需要做“增加”的操作（相当于垒土造山）。但是在下坡走的时候实际上不需要任何操作，因为任何一个下坡的位置j，都可以找到一个对应的上坡位置i，可以认为在i位置通过“增加”操作成就了target[j]。
 * 举个例子：1 3 4 2。我们在处理j=3的时候，target[3]可以认为是在i=1的时候，对于区间[1:3]增加1而构造得到的。
 * 至于target[1]=3本身，则可以认为是再通过一步对区间[1:2]增加1得到。这两个效果的叠加，等效于在i=1的位置，
 * 直接增加2，也就是target[1]相对于target[0]的增量。
 * 下坡必有一个上坡的对应，只算上坡
 *
 * <p> 2.
 * <p> 3.
 */

package com.leetcode.greedy;

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
