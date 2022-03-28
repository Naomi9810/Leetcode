/**
 * Created by Sijia on 3/27/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.goo.design;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC_0362_Design_Hit_Counter {
    Deque<Integer> que;

    public void HitCounter() {
        que = new ArrayDeque<>();
    }

    public void hit(int timestamp) {
        que.add(timestamp);
    }

    public int getHits(int timestamp) {
        while (!que.isEmpty() && timestamp > 300 && timestamp - 300 >= que.peekFirst()) {
            que.pollFirst();
        }
        return que.size();
    }
}
