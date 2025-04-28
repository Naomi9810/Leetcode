package com.leetcode.sortInterval;

import java.util.Arrays;

/**
 * Time Complexity:
 * <p> O(NlogN) Quick sort the cars by position. (Other sort can be applied)
 * <p> O(N) One pass for all cars from the end to start (another direction also works).
 * Space Complexity:
 * <p> O(N) Space for sorted cars. O(1) space is possible if we sort pos inplace.
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */
public class LC_0853_Car_Fleet {

  public int carFleet(int target, int[] position, int[] speed) {
    int numOfCars = position.length, res = 0;
    if (numOfCars <= 1) {
      return 1;
    }
    double[][] time = new double[numOfCars][2];
    for (int i = 0; i < numOfCars; i++) {
      // 0 is the position, 1 is the time need to get to target
      time[i][0] = position[i];
      time[i][1] = (double) (target - position[i]) / speed[i];
    }
    // sort by position default sort order is ascending small ->  large
    Arrays.sort(time, (a, b) -> Double.compare(a[0], b[0]));
    double cur = 0; // cur records the slowest car time
    for (int i = numOfCars - 1; i >= 0; i--) {
      // look from the target nearest
      if (cur < time [i][1]) {
        // current car use more time than the ahead car, can only form a new fleet by itself
        cur = time[i][1];
        res++;
      }
    }
    return res;
  }
}
