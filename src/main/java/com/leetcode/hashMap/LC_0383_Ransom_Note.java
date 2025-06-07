package com.leetcode.hashMap;

public class LC_0383_Ransom_Note {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;
        int[] letters = new int[26];

        for (char c : magazine.toCharArray())
            letters[c-'a']++;

        for (char c : ransomNote.toCharArray()){
            if (letters[c-'a'] == 0) return false;
            letters[c-'a']--;
        }
        return true;
    }
}
