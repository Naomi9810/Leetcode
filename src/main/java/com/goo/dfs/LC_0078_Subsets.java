/**
 * Created by Sijia on 3/13/22
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

public class LC_0078_Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

// For coins = [10, 50, 100] and quantity = [1, 2, 1], the output should be
//solution(coins, quantity) = 9.  all possible sum

    /*
    * int solution(int[] coins, int[] quantity) {
    Set<Integer> sumSet = new HashSet<>();
    computeSum(coins, quantity, sumSet, 0, 0);
    return sumSet.size() - 1; // remove 0
}

void computeSum(int[] coins, int[] quantity, Set<Integer> sumSet, int start, int sum) {
    sumSet.add(sum);
    for (int i = start; i < coins.length; i++) {
        for (int j = 1; j <= quantity[i]; j++) {
            sum += coins[i] * j;
            computeSum(coins, quantity, sumSet, i+1, sum);
            sum -= coins[i] * j;
        }
    }
}
    *
    *
    *
    *
    * */




}
