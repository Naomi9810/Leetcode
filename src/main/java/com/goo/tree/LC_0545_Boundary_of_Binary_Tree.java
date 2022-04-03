/**
 * Created by Sijia on 3/28/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.goo.tree;

import java.util.ArrayList;
import java.util.List;

public class LC_0545_Boundary_of_Binary_Tree {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        res.add(root.val);
        dfs(root.left, res, true, false);
        dfs(root.right, res, false, true);
        return res;
    }

    private void dfs(TreeNode node, List<Integer> res, boolean isLeft, boolean isRight) {
        if (node == null) return;

        if (isLeft) res.add(node.val);
        dfs(node.left, res, isLeft, isRight && node.right == null);
        if (!isLeft && !isRight && node.left == null && node.right == null) res.add(node.val);
        dfs (node.right, res, isLeft && node.left == null, isRight);
        if (isRight) res.add(node.val);
    }

}
