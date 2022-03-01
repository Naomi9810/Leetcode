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

public class LC_0133_Clone_Graph {
    Map<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        if (map.containsKey(node)) return map.get(node);
        Node cur = new Node(node.val);
        map.put(node, cur); // 先put parent 再visit neighbor
        for (Node nei : node.neighbors) {
            cur.neighbors.add(cloneGraph(nei));
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

}
