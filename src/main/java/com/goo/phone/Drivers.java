/**
 * Created by Sijia on 2/22/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.goo.phone;

public class Drivers {
     int coveredArea(int[][] drivers, int[][] needed) {
          int coveredArea = 0;
          for (int i = 0; i < drivers.length; i++) {
               for (int j = 0; j < drivers[0].length; j++) {
                    if (needed[i][j] == 1 && dfs(drivers, needed, i, j)) {
                         coveredArea++;
                    }
               }
          }
          return coveredArea;
     }

     public static void main(String[] args) {

     }

     private boolean dfs(int[][] drivers, int[][] needed, int i, int j) {

     }
}
