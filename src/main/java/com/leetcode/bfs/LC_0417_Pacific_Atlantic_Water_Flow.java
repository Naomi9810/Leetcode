package com.leetcode.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Time Complexity: O(M*N) - m = grid.length, n = grid[0].length.
 * <p>
 * Space Complexity: O(M*N) - m = grid.length, n = grid[0].length.
 * <p>
 * Hints:  https://leetcode.com/problems/pacific-atlantic-water-flow/discuss/90733/Java-BFS-and-DFS-from-Ocean
 * <p> 1. run search 4 direction search for all cells, see if can reach Pacific ocean and Atlantic
 * <p> 2. only the value is smaller than cur height can flow
 * <p> 3.
 */
public class LC_0417_Pacific_Atlantic_Water_Flow {

    //    public static final int[][] DIR = new int[][]{{-1, 0}, {1, 0}, {0, -1},
//            {0, 1}}; // up, down, left, right
//
//    public List<List<Integer>> pacificAtlantic(int[][] heights) {
//        int row = heights.length;
//        int col = heights[0].length;
//
//        List<List<Integer>> res = new ArrayList<>();
//
//        boolean[][] pacific = new boolean[row][col];
//        boolean[][] atlantic = new boolean[row][col];
//
//        Queue<int[]> pQueue = new LinkedList<>();
//        Queue<int[]> aQueue = new LinkedList<>();
//
//        for (int j = 0; j < col; j++) {
//            // top pacific bottom atlantic
//            pacific[0][j] = true;
//            pQueue.add(new int[]{0, j});
//            atlantic[row - 1][j] = true;
//            aQueue.add(new int[]{row - 1, j});
//        }
//
//        for (int i = 0; i < row; i++) {
//            // left pacific and right atlantic
//            pacific[i][0] = true;
//            pQueue.add(new int[]{i, 0});
//            atlantic[i][col - 1] = true;
//            aQueue.add(new int[]{i, col - 1});
//        }
//
//        bfs(heights, pQueue, pacific);
//        bfs(heights, aQueue, atlantic);
//
//
//        for (int i = 0; i < heights.length; i++) {
//            for (int j = 0; j < heights[0].length; j++) {
//                if (pacific[i][j] && atlantic[i][j]) {
//                    res.add(new ArrayList<>(Arrays.asList(i, j)));
//                }
//            }
//        }
//        return res;
//    }
//
//    private void bfs(int[][] heights, Queue<int[]> queue, boolean[][] visited) {
//        while (!queue.isEmpty()) {
//            int[] cur = queue.poll();
//            int i = cur[0];
//            int j = cur[1];
//            for (int[] d : DIR) {
//                int i2 = i + d[0];
//                int j2 = j + d[1];
//                if (i2 < 0 || j2 < 0 || i2 >= heights.length || j2 >= heights[0].length || heights[i][j] > heights[i2][j2] || visited[i2][j2]) {
//                    continue;
//                }
//                // cur is the boarder
//                // only when the cell near border height >= border height it can flow:
//                visited[i2][j2] = true;
//                queue.offer(new int[]{i2, j2});
//            }
//        }
//    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if (heights == null || heights.length == 0 || heights[0].length == 0) return new ArrayList<>();

        int row = heights.length, col = heights[0].length;

        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];

        List<List<Integer>> res = new ArrayList<>();

        for (int j = 0; j < col; j++) {
            dfs(heights, pacific, Integer.MIN_VALUE, 0, j);
            dfs(heights, atlantic, Integer.MIN_VALUE, row-1, j);
        }

        for (int i = 0; i < row; i++) {
            dfs(heights, pacific, Integer.MIN_VALUE, i, 0);
            dfs(heights, atlantic, Integer.MIN_VALUE, i, col-1); // assign the sea value
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++){
                if (atlantic[i][j] && pacific[i][j]) {
                    res.add(new ArrayList<Integer>(Arrays.asList(i, j)));
                }
            }
        }
        return res;
    }

    private void dfs(int[][] heights, boolean[][] sea, int height, int i, int j) {
        int row = heights.length, col = heights[0].length;
        if (i < 0 || j < 0 || i >= row || j >= col || sea[i][j] || heights[i][j] < height) {
            // 想象height是山的高度， 临近sea的已经可以flow 需要高于 cur height 下一步才可以flow
            return;
        }
        int[][]dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        sea[i][j] = true;
        for (int[] d: dir) {
            dfs(heights, sea, heights[i][j], i+d[0], j+d[1]);
        }
    }
}
