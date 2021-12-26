/**
 * Created by Sijia on 12/25/21
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1. directly use the int[] encoding , pointer i and n
 * <p> 2. [3, 8, 0, 9, 2, 5] - 2,1,1,2
 * <p> 3. [0, 1, 2, 3, 4, 5]
 */

package com.goo.array;

public class LC_0900_RLE_Iterator {
    int[] seq;
    int i;

    public void RLEIterator(int[] encoding) {
        seq = encoding;
        i = 0;
    }

    public int next(int n) {
        int len = seq.length;
        while (i < len) {
            if (n > seq[i]) { //  include the 0 case
                n -= seq[i];
                i += 2;
            } else {
                seq[i] -= n;
                return seq[i + 1];
            }
        }
        return -1;
    }
}
