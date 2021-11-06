package com.goo.unionFind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/**
 * Time Complexity: O(NKlogNK) N is the number of accounts and K is the maximum length of an
 * account
 * <p>
 * Using link-by-size, any UNION or FIND operation takes O(log n) time in the worst case, where n is
 * the number of elements. Pf. ・The running time of each operation is bounded by the tree height.
 * <p>
 * Space Complexity: O(NK) - N is the number of accounts and K is the maximum length of an
 *  * account
 * <p>
 * Hints: Use union find or DFS
 */
public class LC_0721_Accounts_Merge {

  public List<List<String>> accountsMerge(List<List<String>> accounts) {
    int size = accounts.size();
    int[] roots = new int[size]; //  represent merged user id
    for (int i = 0; i < size; i++) {
      roots[i] = i; //  use idx as the user id for each account, because there is dup names
    }

    Map<String, Integer> emailMap = new HashMap<>(); // email and user id

    // union find process:
    for (int i = 0; i < size; i++) {
      int emailSize = accounts.get(i).size();
      for (int j = 1; j < emailSize; j++) {
        String email = accounts.get(i).get(j);
        if (!emailMap.containsKey(email)) {
          emailMap.put(email, i);
        } else {
          // this is already seen need to union
          int root1 = findRoot(roots, emailMap.get(email));
          int root2 = findRoot(roots, i);
          if (root1 != root2) {
            roots[root2] = root1;
          }
        }
      }
    }

    // use treeSet to sort:
    Map<Integer, TreeSet<String>> users = new HashMap<>(); //  merged user id and users sorted emails
    for (int i = 0; i < size; i++) {
      int root = findRoot(roots, i);
      List<String> emails = new ArrayList<>(accounts.get(i));
      users.putIfAbsent(root, new TreeSet<String>());
      // add all the sorted emails that belong to this user
      users.get(root).addAll(emails.subList(1, emails.size())); // exclude name
    }

    // assemble the result:
    List<List<String>> res = new ArrayList<>();
    for (Integer idx : users.keySet()) {
      List<String> sortedEmails = new ArrayList<>();
      sortedEmails.add(accounts.get(idx).get(0)); // insert the name in the first
      sortedEmails.addAll(users.get(idx));
      res.add(sortedEmails);
    }
    return res;
  }

  private int findRoot(int[] roots, int idx) {
    while (roots[idx] != idx) {
      roots[idx] = roots[roots[idx]];
      idx = roots[idx];
    }
    return idx;
  }
}
