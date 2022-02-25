/*
 * Created by Sijia on 1/14/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints: saving the whole arr will cause memory exceed.
 * only saves the index and value, use List size as map key
 * https://leetcode.com/problems/snapshot-array/discuss/454280/Java-list-and-map-explained-clean-beats-95
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.goo.array;

import java.util.*;

public class LC_1146_Snapshot_Array {
    private List<Map<Integer, Integer>> list;

    public void SnapshotArray(int length) {
        list = new ArrayList<>();
        list.add(new HashMap()); // snap start from 0
    }

    public void set(int index, int val) {
        int snap_id = list.size() - 1;
        list.get(snap_id).put(index, val);
    }

    public int snap() {
        list.add(new HashMap());
        return list.size() - 2;
    }

    public int get(int index, int snap_id) { //  can't get it directly need to look history
        for (int i = snap_id; i >=0; i--) {
            if (list.get(i).containsKey(index)) {
                return list.get(i).get(index);
            }
        }
        return 0; // can't find it
    }
}
