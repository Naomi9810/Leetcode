package com.leetcode.array;

import java.util.Map;

public class LC_0013_romanToInt {
    public int romanToInt(String s) {
        Map<Character, Integer> val = Map.of(
                'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000);

//        int res = 0;
//        for (int i = 0; i < s.length(); i++) {
//            res += val.get(s.charAt(i));
//        }
//
//        for (int i = 0; i + 2 <= s.length(); i++) {
//            String sub = s.substring(i, i + 2);
//            if ("IV".equals(sub) || "IX".equals(sub)) {
//                res -= 2;
//            }
//            if ("XL".equals(sub) || "XC".equals(sub)) {
//                res -= 20;
//            }
//            if ("CD".equals(sub) || "CM".equals(sub)) {
//                res -= 200;
//            }
//
//        }
//        return res;
        int len = s.length();

        char pre = s.charAt(len - 1);
        int preVal = val.get(pre);
        int res = preVal; //  need add this

        for (int i = len - 2; i >= 0; i--) {
            char cur = s.charAt(i);
            int curVal = val.get(cur);

            if (curVal < preVal) {
                res -= curVal;
            } else {
                res += curVal;
            }
            preVal = curVal;

        }
        return res;



    }
}
