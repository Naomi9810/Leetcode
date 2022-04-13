package com.goo.subsequence;

import java.util.*;

/**
 * Time Complexity: O(L ^2 * N )   N is the word size, L is the maxLen of word
 * Space Complexity: O(N) map size
 * <p>
 * Hints:
 */
public class LC_1048_Longest_String_Chain {

    public int longestStrChain(String[] words) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        Map<String, Integer> mem = new HashMap<>();
        int maxLen = 1;

        for (String word : words) {
            maxLen = Math.max(maxLen, dfs(wordSet, mem, word));

        }
        return maxLen;
    }

    public int dfs(Set<String> wordSet, Map<String, Integer> mem, String curWord) {
        if (mem.containsKey(curWord)) {
            return mem.get(curWord);
        }
        int len = 1;
        StringBuilder sb = new StringBuilder(curWord);
        for (int i = 0; i < curWord.length(); i++) {
            sb.deleteCharAt(i);
            String preWord = sb.toString();
            if (wordSet.contains(preWord)) {
                int curLen = 1 + dfs(wordSet, mem, preWord);
                len = Math.max(len, curLen);
            }
            sb.insert(i, curWord.charAt(i));
        }
        mem.put(curWord, len);
        return len;
    }

// dp 需要sort的办法
//    public int longestStrChain(String[] words) {
//        Map<String, Integer> dp = new HashMap<>();
//        Arrays.sort(words, (a, b)->a.length() - b.length());
//        int res = 0;
//        for (String word : words) {
//            int best = 0;
//            for (int i = 0; i < word.length(); ++i) {
//                String prev = word.substring(0, i) + word.substring(i + 1);
//                best = Math.max(best, dp.getOrDefault(prev, 0) + 1);
//            }
//            dp.put(word, best);
//            res = Math.max(res, best);
//        }
//        return res;
//    }

}
