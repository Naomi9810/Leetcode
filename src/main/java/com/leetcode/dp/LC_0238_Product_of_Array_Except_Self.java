/**
 * Created by Sijia on 2/23/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.leetcode.dp;

public class LC_0238_Product_of_Array_Except_Self {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];

        int product = 1;
        for (int i = 0; i < len; i++) {
            res[i] =  product;
            // first assign the product, then do the * , in that way, it will pass to the nex number
            product *= nums[i];
        }

        product = 1;
        for (int j = len-1; j >=0 ;j--) {
            res[j] *=  product; // make sure this is *= we don't want to lose the previous product
            product *= nums[j];
        }
        return res;
    }
}
