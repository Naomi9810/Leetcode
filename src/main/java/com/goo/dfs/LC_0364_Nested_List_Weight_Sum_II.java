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

package com.goo.dfs;

import java.util.List;

public class LC_0364_Nested_List_Weight_Sum_II {
    int maxDepth = 1;
    public int depthSumInverse(List<NestedInteger> nestedList) {
        Integer[] sum = new Integer[1];
        sum[0] = 0;
        getMaxDepth(nestedList, 1);

        for (NestedInteger n: nestedList) {
            depthSumHelper(n, sum, maxDepth);
        }
        return sum[0];
    }

    private void depthSumHelper(NestedInteger n, Integer[] sum, int depth) {
        if (n.isInteger()) {
            sum[0] += n.getInteger() * depth;
        } else {
            for (NestedInteger nested:  n.getList()) {
                depthSumHelper(nested, sum, depth-1);
            }
        }
    }

    private void getMaxDepth(List<NestedInteger> nestedList, int curDepth) {
        for (NestedInteger n:  nestedList) {
            if (!n.isInteger()) {
                getMaxDepth(n.getList(), curDepth+1);
            }
        }
        maxDepth = Math.max(maxDepth, curDepth);
    }
}
