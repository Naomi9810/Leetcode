/**
 * Created by Sijia on 4/26/22
 * Time Complexity:
 * Space Complexity:
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.leetcode.design;

import java.util.ArrayList;
import java.util.List;

public class LC_1472_Design_Browser_History {
    List<String> history;
    int cur = 0;

    public void BrowserHistory(String homepage) {
        history = new ArrayList<>();
        history.add(homepage);
    }

    public void visit(String url) {
        while (!history.isEmpty() && cur < history.size()-1) {
            history.remove(history.size()-1);
        }
        history.add(url);
        cur = history.size()-1;
    }

    public String back(int steps) {
        int newPos = cur - steps;
        cur = Math.max(newPos, 0);
        return history.get(cur);
    }

    public String forward(int steps) {
        int newPos = cur + steps;
        cur = Math.min(newPos, history.size() -1);
        return history.get(cur);

    }
}
