package com.goo.tree;

import com.goo.tree.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Time Complexity: O(N^2) N is the # of TreeNode, for each TreeNode we need to build the postOrder
 * Improvement is to replace the String with Integer, use another map to store to O(N^2)
 * <p>
 * Space Complexity: O(N) - N is the # of TreeNode
 * <p>
 * Hints: post order Traverse, Hashmap stores order - frequency only add to res when frequency is
 * 2.
 *
 *    A
 *   / \
 *  B  C
 *    / \
 *   D   E
 *
 *    C
 *   / \
 *   A  E
 *  / \
 * B  D
 *
 * same inOrder traverse string: B-A-D-C-E
 * preOrder and postOrder gives unique Str
 */
public class LC_0652_Find_Duplicate_Subtrees {
  public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    Map<String, Integer> countMap = new HashMap<>();
    List<TreeNode> res = new ArrayList<>();
    postOrder(root, countMap, res);
    return res;
  }

  private String postOrder(TreeNode node, Map<String, Integer> map, List<TreeNode> res) {
    if (node == null) {
      return "N";
    }
    String postOrderStr =
        node.val + "," + postOrder(node.left, map, res) + "," + postOrder(node.right, map, res);
    map.put(postOrderStr, map.getOrDefault(postOrderStr, 0) + 1); // count the frequency
    if (map.get(postOrderStr) == 2) {
      // only add it when this is 2
      res.add(node);
    }
    return postOrderStr;
  }
}
