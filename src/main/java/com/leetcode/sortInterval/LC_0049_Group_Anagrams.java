/**
 * Created by Sijia on 2/21/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.leetcode.sortInterval;

import java.util.*;

public class LC_0049_Group_Anagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();


        for (String str: strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr); // sort it to create a common key
            String sorted = String.valueOf(arr);
            map.putIfAbsent(sorted, new ArrayList<>());
            map.get(sorted).add(str);
        }

        for (List<String> list: map.values()) {
            res.add(list);
        }
        return res;
    }
}
