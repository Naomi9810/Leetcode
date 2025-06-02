package com.leetcode.twoPointer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC_0030_findSubstring {
    public List<Integer> findSubstring(String s, String[] words) {
        int subLen = words[0].length();
        int catLen = subLen * words.length;
        List<Integer> res = new ArrayList<>();
        if (s.length() < catLen) return res;

        // only using seen map is not enough to cover the duplicate word case need a map
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        if (wordCount.size() == 1) {
            // only one letter aaa case
            String key = wordCount.keySet().iterator().next();
            String sub = key.repeat(wordCount.get(key));
            int idx = s.indexOf(sub);
            while (idx != -1) {
                res.add(idx);
                idx = s.indexOf(sub, idx + 1);
            }
            return res;
        }

        for (int i = 0; i + subLen <= s.length(); i++) {
            int j = i + subLen;
            String sub = s.substring(i, j);
            Map<String, Integer> wordsNeedUse = new HashMap<>(wordCount);
            while (wordsNeedUse.containsKey(sub)) {
                int count = wordsNeedUse.get(sub);
                if (count <= 1) {
                    wordsNeedUse.remove(sub);
                } else {
                    wordsNeedUse.put(sub, count - 1);
                }

                if (j + subLen <= s.length()) {
                    sub = s.substring(j, j + subLen);
                    j += subLen;
                } else sub = "";
            }
            if (wordsNeedUse.isEmpty()) {
                res.add(i);
            }
        }
        return res;
    }
}
