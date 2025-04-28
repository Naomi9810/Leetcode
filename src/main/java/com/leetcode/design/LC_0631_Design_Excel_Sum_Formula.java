/**
 * Created by Sijia on 2/4/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.leetcode.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC_0631_Design_Excel_Sum_Formula {
    int[][] matrix;
    HashMap<Integer, List<int[]>> map;
    int height;
    int width;


    public void Excel(int height, char width) {
        this.matrix = new int[height][width - 'A' + 1];
        this.map = new HashMap<>();
        this.height = height;
        this.width = width - 'A' + 1;

    }

    public void set(int row, char column, int val) {
        int pre = get(row, column);
        int delta = val - pre;
        int[] pos = convertPos(row, column);
        matrix[pos[0]][pos[1]] = val;
        int key = convertKey(pos, width);
        if (map.containsKey(key)) {
            List<int[]> relatedSum = map.get(key);
            for (int[] sum : relatedSum) {
                matrix[sum[0]][sum[1]] += delta;
            }
        }
    }

    public int get(int row, char column) {
        int[] pos = convertPos(row, column);
        return matrix[pos[0]][pos[1]];
    }

    public int sum(int row, char column, String[] numbers) {
        int[] cur = convertPos(row, column);
        int sum = 0;
        for (String num : numbers) {
            if (num.length() <= 3) {
                int[] numPos = strToPos(num);
                int key = convertKey(numPos, width);
                map.putIfAbsent(key, new ArrayList<>());
                map.get(key).add(cur);
                sum += matrix[numPos[0]][numPos[1]];
            } else {
                sum += getSum(num, width, cur);
            }
        }
        return sum;
    }

    private int[] convertPos(int row, char column) {
        return new int[]{row - 1, column - 'A'};
    }

    private int convertKey(int[] pos, int width) {
        return pos[0] * width + pos[1];
    }

    private int[] strToPos(String str) {
        return new int[]{Integer.parseInt(str.substring(1)), str.charAt(0) - 'A'};
    }

    private int getSum(String str, int width, int[] cur) {
        int sum = 0;
        String[] split = str.split(":");
        String start = split[0], end = split[1];
        int[] startPos = strToPos(start);
        int[] endPos = strToPos(end);
        for (int i = startPos[0]; i < endPos[0]; i++) {
            for (int j = startPos[1]; j < endPos[1]; j++) {
                sum += matrix[i][j];
                int key = i * width + j;
                map.putIfAbsent(key, new ArrayList<>());
                map.get(key).add(cur);
            }
        }
        return sum;
    }
}
