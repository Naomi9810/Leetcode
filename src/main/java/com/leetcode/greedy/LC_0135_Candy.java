package com.leetcode.greedy;

/*
1. two pass method
2. up, down flat
 */
public class LC_0135_Candy {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) return 0;
        int len = ratings.length;
        //
        // int[] min = new int[len];
        // Arrays.fill(min,1); // everyone candy 1;
        // for (int i = 1; i < len; i++) {
        //     if (ratings[i-1] > ratings[i] && min[i-1] <= min[i]) {
        //         min[i-1] = min[i]+1;
        //     } else if(ratings[i-1] < ratings[i] && min[i-1] >= min[i]) {
        //         min[i] = min[i-1]+1;
        //     }
        // }

        // for (int i = len-1; i-1 >=0; i--) {
        //     if (ratings[i-1] > ratings[i] && min[i-1] <= min[i]) {
        //         min[i-1] = min[i]+1;
        //     } else if(ratings[i-1] < ratings[i] && min[i-1] >= min[i]) {
        //         min[i] = min[i-1]+1;
        //     }
        // }

        // int total = 0;

        // for (int count: min) {
        //     total+= count;
        // }

        // return total;

        int total = 1;  // First child gets 1 candy
        int up = 0, down = 0, peak = 0;

        for (int i = 1; i < ratings.length; i++) {
            // up
            if ( ratings[i - 1] < ratings[i]) {
                up++;
                peak = up;
                down = 0;
                total += 1 + up;
            } else if (ratings[i] == ratings[i - 1]) {
                up = down = peak = 0; //  reset to 0
                total += 1;
            } else { // ratings[i] < ratings[i - 1]
                up = 0;
                down++;
                total += 1 + down - (peak >= down ? 1 : 0);
                // we already gave the peak child (the one just before the descent started) a certain number of candies during the upward sequence.
                // If the length of the downward sequence is greater than the peak height, we’re fine.
                //If it's equal to or less than the peak, we end up giving the peak child too few candies relative to the steepness of the descent.
            }
        }

        return total;

    }
}
