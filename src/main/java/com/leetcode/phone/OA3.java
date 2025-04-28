/**
 * Created by Sijia on 2/13/22
 */

package com.leetcode.phone;

public class OA3 {
    public int solution(int N) {
        // write your code in Java SE 8
        if (N == 5) return 0;
        String str = String.valueOf(N);
        StringBuilder sb = new StringBuilder(str);
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '5') {
                sb.deleteCharAt(i);
                res = Math.max(res, Integer.parseInt(sb.toString()));
                sb = new StringBuilder(str);
            }
        }
        return res;
    }

}
