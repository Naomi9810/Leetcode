/**
 * Created by Sijia on 3/23/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:  https://leetcode.com/problems/find-the-winner-of-the-circular-game/discuss/1152705/JavaC%2B%2BPython-4-lines-O(n)-time-O(1)-space
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.goo.mathBitMatrix;

import java.util.ArrayDeque;
import java.util.Queue;

public class LC_1823_Find_the_Winner_of_the_Circular_Game {
    public int findTheWinner(int n, int k) {
//        int res = 0;
//        for (int i = 1; i <= n; ++i)
//            res = (res + k) % i;
//        return res + 1;

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        while (queue.size() > 1) {
            int delete = k - 1;
            while (delete-- > 0) {
                queue.offer(queue.poll());
            }
            queue.poll();
        }
        return queue.poll();
    }
}
