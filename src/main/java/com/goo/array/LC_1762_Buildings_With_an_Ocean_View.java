/**
 * Created by Sijia on 3/9/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.goo.array;

import java.util.ArrayList;
import java.util.List;

public class LC_1762_Buildings_With_an_Ocean_View {
    public int[] findBuildings(int[] heights) {
        List<Integer> res = new ArrayList<>();
        int len = heights.length;
        int pre = 0;

        for (int i = len - 1; i >= 0; i--) {
            if (heights[i] > pre) {
                res.add(i);
            }
            pre = Math.max(pre, heights[i]);
        }

        int size = res.size();
        int[] resArr = new int[size];
        for (int i = 0; i < size; i++) {
            resArr[i] = res.get(size - 1 - i);
        }
        return resArr;
    }
}

}
