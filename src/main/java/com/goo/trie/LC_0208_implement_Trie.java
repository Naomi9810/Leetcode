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

package com.goo.trie;

public class LC_0208_implement_Trie {
    class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode cur = root;
            for (char c: word.toCharArray()) {
                if ( cur.children[c - 'a'] == null) { // 确保不在再加 否则会override
                    cur.children[c - 'a'] = new TrieNode();
                }
                cur = cur.children[c - 'a'];
            }
            cur.word = word;
        }

        public boolean search(String word) {
            TrieNode cur = root;
            for (char c: word.toCharArray()) {
                if (cur.children[c - 'a'] == null) return false;
                cur = cur.children[c - 'a'];
            }
            return word.equals(cur.word);
        }

        public boolean startsWith(String prefix) {
            TrieNode cur = root;
            for (char c: prefix.toCharArray()) {
                if (cur.children[c - 'a'] == null) return false;
                cur = cur.children[c - 'a'];
            }
            return true;
        }


    }
}
