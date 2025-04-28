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

package com.leetcode.trie;

public class LC_0211_Design_Add_and_Search_Words_Data_Structure {
    TrieNode root;

    public void WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for (char c:  word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.word = word;
    }

    public boolean search(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        return searchHelper(word.toCharArray(), 0, root);
    }

    public boolean searchHelper(char[] charArr,int i,TrieNode cur) {
        if (i == charArr.length) {
            return !(cur.word == null); // only if it's not null
        }
        char c = charArr[i];
        if (c != '.') {
            return cur.children[c - 'a'] != null && searchHelper(charArr, i+1, cur.children[c - 'a']);
        } else {
            for (int j = 0; j < cur.children.length; j++) {
                if (cur.children[j] != null) {
                    if (searchHelper(charArr, i+1, cur.children[j])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
