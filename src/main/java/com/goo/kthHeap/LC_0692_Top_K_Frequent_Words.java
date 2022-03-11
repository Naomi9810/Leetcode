/**
 * Created by Sijia on 3/10/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.goo.kthHeap;

import java.util.*;

public class LC_0692_Top_K_Frequent_Words {
    /*
    1. Map to store frequency
    2. add to a priorityQueue<>()  minHeap override the comparator first compare counts, then compare lexicographical order
    3. collect the result

    */
    public List<String> topKFrequent(String[] words, int k) {
        // count
        Map<String, Integer> map = new HashMap<>();
        for (String word:  words) {
            map.put(word, map.getOrDefault(word, 0)+1);
        }

        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>((a, b) -> {
            if (a.getValue() != b.getValue()) {
                return Integer.compare(a.getValue(), b.getValue());
            } else {
                return b.getKey().compareTo(a.getKey());
            }
        });

        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        List<String> res = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            res.add(0, minHeap.poll().getKey());
        }
        return res;
    }
}
