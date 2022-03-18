/**
 * Created by Sijia on 2/15/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints: two pointer 找相近的
 * 1. store String and its idx List<Integer
 * 2. store String w1+w2
 * 3. two pointer to calculate the min and save
 * ></>
 * 2.
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.goo.twoPointer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC_0244_Shortest_Word_Distance_II {
    Map<String,Integer> dist;
    Map<String, List<Integer>> map;

    public void WordDistance(String[] wordsDict) {
        dist = new HashMap<>();
        map = new HashMap<>();
        for (int i = 0; i < wordsDict.length; i++) {
            map.putIfAbsent(wordsDict[i], new ArrayList<>());
            map.get(wordsDict[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) { // O(1)  time complexity
        String key = word1.length() < word2.length()? word1+ word2: word2+word1;
        if (dist.containsKey(key)) return dist.get(key);

        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int min = Integer.MAX_VALUE;
        for(int i = 0, j = 0; i < list1.size() && j < list2.size(); ) {
            int pos1 = list1.get(i), pos2 = list2.get(j);
            if(pos1 < pos2) {
                min = Math.min(min, pos2 - pos1);
                i++;
            } else {
                min = Math.min(min, pos1 - pos2);
                j++;
            }
        }
        dist.put(key, min);
        return min;

    }
}
