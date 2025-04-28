/**
 * Created by Sijia on 1/9/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:  Increment cows when either number from secret was already seen in guest or vice versa.
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.leetcode.substringAndString;

public class LC_0299_Bulls_and_Cows {
    public String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;
        int[] numbers = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if (s == g) bulls++;
            else {
                if (numbers[s - '0']++ < 0) cows++;
                if (numbers[g - '0']-- > 0) cows++;
            }
        }
        return bulls + "A" + cows + "B";
    }
}
