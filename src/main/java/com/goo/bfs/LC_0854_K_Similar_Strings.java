/**
 * Created by Sijia on 2/16/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.goo.bfs;

import java.util.*;

public class LC_0854_K_Similar_Strings {
    public int kSimilarity(String A, String B) {
        Queue<String> que = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        que.offer(A);
        visited.add(A);
        int swap = 0;

        while (!que.isEmpty()) {
            int size = que.size();
            while (size-- > 0) {
                String cur = que.poll();
                if (cur.equals(B)) {
                    return swap;
                }
                for (String next: getNext(cur, B)) {
                    if(!visited.contains(next)) {
                        que.offer(next);
                        visited.add(next);
                    }
                }
            }
            swap++;
        }
        return -1;
    }

    private List<String> getNext(String A, String B) {
        List<String> res = new ArrayList<>();
        char[] arr = A.toCharArray();

        int i = 0;
        // find the first not equal idx
        for (;i < arr.length; i++) {
            if (arr[i] != B.charAt(i)) {
                break;
            }
        }

        for (int j = i+1; j < arr.length; j++) {
            if (arr[j] == B.charAt(i)) {
                // find the matching char
                swap(arr, i, j);
                res.add(new String(arr));
                swap(arr, i, j); //  backtracking
            }
        }

        return res;
    }
    private void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
