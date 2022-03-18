/**
 * Created by Sijia on 2/21/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.goo.dfs;

import java.util.ArrayList;
import java.util.List;

public class LC_0022_Generate_Parentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(new StringBuilder(), 0, 0, n, res);
        return res;
    }

    private void dfs(StringBuilder sb, int left, int right, int n, List<String> res) {
        if (left == n && right == n) {
            res.add(sb.toString());
        }
        // choose "("
        if (left < n) {
            sb.append("(");
            dfs(sb, left+1, right, n, res);
            sb.setLength(sb.length() -1); // back tracking
        }
        // choose ")"   不要随便加else if 这两者并不互斥
        if (left > right) { // only right < left
            sb.append(")");
            dfs(sb, left, right+1, n, res);
            sb.setLength(sb.length() -1);
        }
    }
}
