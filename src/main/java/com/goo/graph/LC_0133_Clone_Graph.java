/**
 * Created by Sijia on 2/25/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.goo.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC_0133_Clone_Graph {
    Map<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        if (map.containsKey(node)) return map.get(node);
        Node cur = new Node(node.val);
        map.put(node, cur); // 先put parent 再visit neighbor
        for (Node nei : node.neighbors) {
            cur.neighbors.add(cloneGraph(nei)); // 关键就是 拿到nei的clone 放到 clone 版本里去
        }
        return cur;

//         Queue<Node> que = new ArrayDeque<>();
//         que.add(node);
//         map.put(node, new Node(node.val, new ArrayList<>()));

//         while (!que.isEmpty()) {
//             Node cur = que.poll();

//             for (Node next: cur.neighbors) {
//                 if (!map.containsKey(next)) {
//                     map.put(next, new Node(next.val, new ArrayList<>()));
//                     que.add(next);
//                 }
//                 map.get(cur).neighbors.add(map.get(next));
//             }
//         }
//         return map.get(node);



    }

    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

}
