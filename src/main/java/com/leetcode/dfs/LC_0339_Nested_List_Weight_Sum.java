/**
 * Created by Sijia on 3/17/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.leetcode.dfs;

import java.util.List;

public class LC_0339_Nested_List_Weight_Sum {
    public int depthSum(List<NestedInteger> nestedList) {
        int sum = 0;
        for (NestedInteger n: nestedList) {
            sum += depthSumHelper(n, 1);
        }
        return sum;
    }

    public int depthSumHelper(NestedInteger n, int depth) {
        if (n.isInteger()) return n.getInteger() * depth;
        int sum = 0;
        for (NestedInteger nested: n.getList()) {
            sum += depthSumHelper(nested, depth+1);
        }
        return sum;
    }
}
