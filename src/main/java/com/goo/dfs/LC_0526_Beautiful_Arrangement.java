/**
 * Created by Sijia on 3/16/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints: 还是permutation 一个路数的 题目 不要求结果 只算count 所以只需要计数即可 记一个当前的idx
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.goo.dfs;

public class LC_0526_Beautiful_Arrangement {
    int count = 0;

    public int countArrangement(int n) {
        int[] nums = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            nums[i] = i;
        }
        dfs(nums, visited, n, 1);
        return count;
    }

    private void dfs(int[] nums, boolean[] visited, int n, int start) {
        if (start == n + 1) {
            count++;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;
            if (start % nums[i] == 0 || nums[i] % start == 0) {
                visited[i] = true;
                dfs(nums, visited, n, start + 1);
                visited[i] = false;
            }
        }
    }
}
