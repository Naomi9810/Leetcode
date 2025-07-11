package com.leetcode.bfs;

import java.util.*;

public class LC_0127_ladderLength {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);

        if (!wordSet.contains(endWord)) return 0;

        Queue<String> que = new ArrayDeque<>();

        que.add(beginWord);
        int step = 0;

        while (!que.isEmpty()) {
            int size =  que.size();
            while (size-- > 0) {
                String cur = que.remove();
                if (cur.equals(endWord))  return step+1;

                List<String> nextWordList = computeNextWord(cur);
                for (String nxt: nextWordList) {
                    if (wordSet.contains(nxt)) {
                        que.add(nxt);
                        wordSet.remove(nxt);
                    }
                }
            }
            step++;
        }
        return 0;
    }

    public List<String> computeNextWord(String word) {
        List<String> res =  new ArrayList<>();
        char[] charArr = word.toCharArray();

        for (int i = 0; i < charArr.length; i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                char pre = charArr[i];
                if (c != pre) {
                    charArr[i] = c;
                    res.add(new String(charArr));
                    charArr[i] = pre;
                }
            }
        }
        return res;
    }
}
