package com.goo.substringAndString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1. First need sort to make sure the indices is sorted
 * <p> 2. No need to think about the stringbuilder add one by one, just repeat the idx i and use
 * substring
 * <p> 3.
 */
public class LC_0833_Find_And_Replace_in_String {

  public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
    List<int[]> sorted = new ArrayList<>();
    for (int i = 0; i < indices.length; i++) {
      sorted.add(new int[]{indices[i], i});
    }
    Collections.sort(sorted,
        Comparator.comparing(a -> -a[0])); // sort based from idx in decreasing order
    for (int[] idx : sorted) {
      int i = idx[0];
      int j = idx[1]; // i is the s idx, j is the string idx
      String find = sources[j];
      String replace = targets[j];
      if (s.startsWith(find, i)) {
        s = s.substring(0, i) + replace + s.substring(i + find.length());
      }
    }
    return s;
  }

}
