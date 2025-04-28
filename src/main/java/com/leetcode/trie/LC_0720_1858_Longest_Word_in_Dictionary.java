package com.leetcode.trie;

/**
 * Time Complexity:
 * <p> O(W*L) word number * the average length worst case: longest len
 * Space Complexity:
 * <p> Trie size, height is the longest len+1
 * Hints:
 * <p> 1. Same code goes to 1858
 * <p> 2.
 * <p> 3.
 */
public class LC_0720_1858_Longest_Word_in_Dictionary {

  private TrieNode root;
  private String res = "";

  public String longestWord(String[] words) {
    root = new TrieNode();
    for (String word : words) {
      insert(word);
    }
    dfs(root);
    return res;
  }

  private void insert(String word) {
    TrieNode cur = root;
    for (char c : word.toCharArray()) {
      if (cur.children[c - 'a'] == null) {
        cur.children[c - 'a'] = new TrieNode();
      }
      cur = cur.children[c - 'a'];
    }
    cur.word = word; // the end node will has this word.
  }

  private void dfs(TrieNode node) {
    if (node == null) {
      return;
    }

    if (node.word != null) {
      if (node.word.length() > res.length() || (node.word.length() == res.length()
          && node.word.compareTo(res) < 0)) {
        // two cases that res is updated:
        res = node.word;
      }
    }

    for (TrieNode child : node.children) {
      if (child != null && child.word != null) {
        // only run dfs if this is a word
        dfs(child);
      }
    }
  }
}
