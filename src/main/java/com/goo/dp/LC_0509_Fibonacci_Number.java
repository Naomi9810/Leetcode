/**
 * Created by Sijia on 12/12/21
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.goo.dp;

public class LC_0509_Fibonacci_Number {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int res = 0;
        int pre1 = 1;
        int pre2 = 2;
        for (int i = 2; i <= n; i++) {
            res = pre1 + pre2;
            pre2 = pre1;
            pre1 = res;
        }
        return res;
    }
}
