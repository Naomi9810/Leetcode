/**
 * Created by Sijia on 4/4/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.leetcode.design;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class LC_0359_Logger_Rate_Limiter {
    Deque<Data> que;
    Set<String> set;

    public void Logger() {
        que = new LinkedList<>();
        set = new HashSet<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        // clear queue and make it only contain active data
        while (!que.isEmpty() && que.peekFirst().time + 10 <= timestamp) {
            Data expired = que.poll();
            set.remove(expired.str);
        }

        if (set.contains(message)) {
            return false;
        } else {
            set.add(message);
            que.addLast(new Data(message, timestamp));
            return true;
        }

    }

    static class Data {
        String str;
        int time;

        public Data (String str, int time) {
            this.str = str;
            this.time = time;
        }
    }
}
