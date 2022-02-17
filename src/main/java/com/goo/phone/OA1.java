/**
 * Created by Sijia on 2/13/22
 */

package com.goo.phone;

public class OA1 {
    public int solution(int[] A) {
        // write your code in Java SE 8
        if (A == null || A.length == 0) return 0; // invalid input
        int count = 0; // negative number count
        for (int num : A) {
            if (num == 0) return 0;
            else if (num < 0) {
                count++;
            }
        }
        return count % 2 == 0 ? 1 : -1;
    }

}
