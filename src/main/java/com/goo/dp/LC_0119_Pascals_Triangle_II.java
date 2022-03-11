/**
 * Created by Sijia on 3/7/22
 * Time Complexity:
 * <p> O(k)
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.goo.dp;

public class LC_0119_Pascals_Triangle_II {
    public List<Integer> getRow(int k) {
        Integer[] arr = new Integer[k + 1];
        Arrays.fill(arr, 0);
        arr[0] = 1;

        for (int i = 1; i <= k; i++)
            for (int j = i; j > 0; j--) {
                //System.out.println("j = " + j + ", " + arr[j] + " + " +  arr[j-1]);
                arr[j] = arr[j] + arr[j - 1];
            }


        return Arrays.asList(arr);
    }
}
