/**
 * Created by Sijia on 4/23/22
 * Time Complexity:
 * Space Complexity:
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.goo.mathBitMatrix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC_0835_Image_Overlap {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        List<int[]> list1 = new ArrayList<>();
        List<int[]> list2 = new ArrayList<>();


        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(img1[i][j] == 1) {
                    list1.add(new int[] {i, j});
                }
                if (img2[i][j] == 1) {
                    list2.add(new int[] {i, j});
                }
            }
        }

        for (int[] p1: list1) {
            for (int[] p2: list2) {
                String trans = (p1[0] - p2[0]) + "/" + (p1[1] - p2[1]);
                map.put(trans, map.getOrDefault(trans, 0) + 1);
            }
        }

        int res = 0;
        for (String trans: map.keySet()) {
            res = Math.max(res, map.get(trans));
        }
        return res;
    }
}
