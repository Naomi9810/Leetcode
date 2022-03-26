/**
 * Created by Sijia on 3/24/22
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

import com.goo.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC_0113_Path_Sum_II {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), targetSum, root);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> path, int sum, TreeNode cur) {
        if (cur == null) {
            return;
        }
        int val = cur.val;
        path.add(val);

        if (cur.left == null && cur.right == null) {
            if (sum - val == 0) {
                res.add(new ArrayList<>(path));
            } // 是叶子或者不是叶子的两种选择
        } else {
            dfs(res, path, sum-val, cur.left);
            dfs(res, path, sum-val, cur.right);
        }
        path.remove(path.size()-1);

    }
}
