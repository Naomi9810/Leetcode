/**
 * Created by Sijia on 3/15/22
 * Time Complexity:
 * <p>
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

public class LC_0047_Permutations_II {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res  = new ArrayList<>();
        int len = nums.length;
        dfs(nums, new boolean[len], new ArrayList<>(), res);
        return res;

    }

    private void dfs(int[] nums, boolean[] visited, List<Integer> path, List<List<Integer>> res) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            path.add(nums[i]);
            dfs(nums, visited, path, res);
            visited[i] = false;
            path.remove(path.size()-1);
            while (i+1 < nums.length && nums[i] == nums[i+1]) {
                i++; // visited skip until valid
            }
        }
    }
}
