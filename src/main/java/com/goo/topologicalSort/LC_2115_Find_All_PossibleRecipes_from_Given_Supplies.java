/**
 * Created by Sijia on 2/9/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints: 拓扑排序
 * 建立一个 先做完x 才可以做 y1，y2, y3 的 map  x -> y 的map
 * y的 inDegree++
 * inDegree 是0 的先出 从queue里面先出
 * = 做完了 x ， x map下的全部 inDegree-- 如果 == 0 再加到queue里面
 * 随后
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.goo.topologicalSort;

import java.util.*;

public class LC_2115_Find_All_PossibleRecipes_from_Given_Supplies {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> res = new ArrayList<>();
        if (recipes == null || ingredients == null || supplies == null || recipes.length != ingredients.size()) {
            return res;
        }

        Set<String> supplySet = new HashSet<>(Arrays.asList(supplies));
        int[] inDegree = new int[recipes.length];
        Map<String, List<Integer>> canCreate = new HashMap<>();

        // build the dependencyMap
        for (int i = 0; i < recipes.length; i++) {
            for (int j = 0; j < ingredients.get(i).size(); j++) {
                String cur = ingredients.get(i).get(j);
                if (supplySet.contains(cur)) {
                    continue;
                }
                canCreate.putIfAbsent(cur, new ArrayList<>());
                canCreate.get(cur).add(i);
                inDegree[i]++; // missing ingredients
            }
        }

        // start from inDegree == 0
        Queue<Integer> fifo = new ArrayDeque<>();
        for (int i = 0; i < recipes.length; i++) {
            if (inDegree[i] == 0) {
                fifo.add(i);
            }
        }

        while (!fifo.isEmpty()) {
            Integer cur = fifo.poll();
            String created = recipes[cur];
            res.add(created);

            if (!canCreate.containsKey(created)) {
                continue;
            }

            List<Integer> canCreateList = canCreate.get(created);
            for (int i : canCreateList) {
                inDegree[i]--;
                if (inDegree[i] == 0) {
                    fifo.add(i);
                }
            }
        }
        return res;
    }
//        boolean[] visited = new boolean[recipes.length];
//        List<String> res = new ArrayList<>();
//        Set<String> set = new HashSet<>(Arrays.asList(supplies));
//
//
//        int count = 0, preSize = 0;
//
//        while (preSize != set.size() && count < recipes.length) {
//            preSize = set.size();
//            for (int i = 0; i < recipes.length; i++) {
//                if (visited[i]) continue;
//                String dish = recipes[i];
//                List<String> ingredientsList = ingredients.get(i);
//                if (canCreate(ingredientsList, set)) {
//                    visited[i] = true;
//                    count++;
//                    set.add(dish);
//                }
//            }
//
//        }
//
//        for (int i = 0; i < recipes.length; i++) {
//            if (visited[i]) {
//                res.add (recipes[i]);
//            }
//        }
//        return res;
//    }
//
//    boolean canCreate(List<String> ingredientsList, Set<String> set) {
//        // return true if can make this dish
//        for (String s: ingredientsList) {
//            if (!set.contains(s)) {
//                return false;
//            }
//        }
//        return true;
//    }
}
