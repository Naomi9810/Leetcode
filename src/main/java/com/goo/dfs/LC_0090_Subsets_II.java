/**
 * Created by Sijia on 3/13/22
 * Time Complexity:
 * <p>   n * 2^n
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.goo.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_0090_Subsets_II {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        addSubSets(res, 0, new ArrayList<>(), nums);
        return res;


    }
    private void addSubSets(List<List<Integer>> res, int start, List<Integer> sub, int[] nums) {
        res.add(new ArrayList<>(sub));
        for (int i = start; i < nums.length; i++) {
            if (i == start || nums[i] != nums[i-1]) { //  first or not equal
                sub.add(nums[i]);
                addSubSets(res, i+1, sub, nums);
                sub.remove(sub.size() -1 );
            }

        }
    }
}
