/**
 * Created by Sijia on 5/11/22
 * Time Complexity:
 * Space Complexity:
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.leetcode.stack;

import java.util.*;

public class LC_0071_Simplify_Path {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 1)
            return path;

        String[] splited = path.split("/");
        Deque<String> deque = new ArrayDeque<>();

        for (String str : splited) {
            if (str.isEmpty() || str.equals(".")) {
                continue;
            }
            if (str.equals("..")) {
                if (!deque.isEmpty()) {
                    deque.pop();
                }
            } else {
                deque.push(str);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append("/").append(deque.removeLast());
        }

        return sb.isEmpty() ? "/" : sb.toString();
    }
}
