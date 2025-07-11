package com.leetcode.trie;

import java.util.*;

public class LC_0212_Word_Search_II {
    public List<String> findWords(char[][] board, String[] words) {
        // use words to build a Trie
        TrieNode root = new TrieNode();

        for (String word:  words) {
            TrieNode cur = root;
            for (char c: word.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode();
                }
                cur = cur.children[c - 'a'];
            }
            cur.word = word;
        }

        // search through the board to find the valid word
        List<String> res = new ArrayList<>();

        int rows = board.length, cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dfs(board, i, j, root, res);
            }
        }

        return res;

    }
    public void dfs(char[][] board, int i, int j, TrieNode node, List<String> res) {
        // boundary and visited check
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return;

        char c = board[i][j];
        if (c == '#' || node.children[c - 'a'] == null) return;

        node = node.children[c - 'a'];
        if (node.word != null) {
            res.add(node.word);
            node.word = null; // prevent duplicate results
        }

        board[i][j] = '#'; // mark visited 当前word 链路不能再用 下次还是可用

        dfs(board, i + 1, j, node, res);
        dfs(board, i - 1, j, node, res);
        dfs(board, i, j + 1, node, res);
        dfs(board, i, j - 1, node, res);

        board[i][j] = c; // backtrack
    }
}
