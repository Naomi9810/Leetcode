/**
 * Created by Sijia on 2/13/22
 */

package com.goo.phone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OA2 {
    int solution(int[] A) {
        Map<Integer, int[]> valueToIdx = new HashMap<>();
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            valueToIdx.putIfAbsent(A[i], new int[]{i, i});
            int[] minMax = valueToIdx.get(A[i]);
            if (i < minMax[0]) {
                minMax[0] = i;
            } else if (i > minMax[1]) {
                minMax[1] = i;
            }
            res = Math.max(res, minMax[1] - minMax[0]);
            valueToIdx.put(A[i], minMax);
        }
        return res;
    }

}
