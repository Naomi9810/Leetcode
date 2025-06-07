package com.leetcode.hashMap;

import java.util.*;

public class LC_0049_Group_Anagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        // corner null OR len=0


        Map<String, List<String>> map = new HashMap<>();

        for(String str: strs) {
            String sorted = sortedString(str);
            map.putIfAbsent(sorted, new ArrayList<>());
            map.get(sorted).add(str);
        }
        return new ArrayList<>(map.values());
    }

    String sortedString(String str) {
        // corner null / len = 0;
        char[] charArr = str.toCharArray();
        Arrays.sort(charArr);
        return new String(charArr);
    }


}
