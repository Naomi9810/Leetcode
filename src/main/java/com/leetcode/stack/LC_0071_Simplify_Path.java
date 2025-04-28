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
        if (path == null || path.length() <= 1) return "/";
        Deque<String> stack = new ArrayDeque<>();

        Set<String> skip = new HashSet<>(Arrays.asList("..", ".", ""));
        String[] splited = path.split("/");
        for (String p : splited) {
            if ("..".equals(p) && !stack.isEmpty()) {
                stack.pollLast();
            } else if (!skip.contains(p)) {
                stack.addLast(p);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            String p = stack.pollFirst();
            sb.append("/");
            sb.append(p);
        }
        return sb.length() == 0 ? "/" : sb.toString();

    }
}
