package com.leetcode.bit;

public class LC_0067_Add_Binary {
    public String addBinary(String a, String b) {
        if (a.length() > b.length()) return addBinary(b,a);

        StringBuilder sb = new StringBuilder();
        int lenA = a.length();
        int lenB = b.length();
        int carry = 0;


        a = "0".repeat(lenB-lenA) + a;

        for (int i = lenB-1; i>=0; i--) {
            int bitA = a.charAt(i) - '0';
            int bitB = b.charAt(i) - '0';

            int sum = bitA + bitB + carry;

            sb.append(sum %2);
            carry = sum /2;
        }

        if (carry != 0) {
            sb.append('1');
        }

        return sb.reverse().toString();
    }

}
