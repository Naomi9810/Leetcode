/**
 * Created by Sijia on 2/18/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.leetcode.substringAndString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC_0811_Subdomain_Visit_Count {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();

        for (String log : cpdomains) {
            int idx = log.indexOf(" ");
            int count = Integer.parseInt(log.substring(0, idx));
            String domain = log.substring(idx + 1);
            String[] domains = domain.split("\\.");
            String base = "";
            for (int i = domains.length - 1; i >= 0; i--) {
                // 从后往前append：
                base = domains[i] + (base.equals("")? base: "." + base);
                map.put(base, map.getOrDefault(base, 0) + count);
            }
        }

        List<String> res = new ArrayList<>();
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            res.add (entry.getValue() + " " + entry.getKey());
        }

        return res;
    }
}
