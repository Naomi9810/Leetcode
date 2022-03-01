/**
 * Created by Sijia on 2/28/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.goo.kthHeap;

import com.goo.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC_0230_Kth_Smallest_Element_in_a_BST {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();
        inOrder(root, res);
        return res.get(k-1);
    }
    public void inOrder(TreeNode node, List<Integer> res) {
        if (node == null) return;
        inOrder(node.left, res);
        res.add(node.val);
        inOrder(node.right, res);
    }
}
