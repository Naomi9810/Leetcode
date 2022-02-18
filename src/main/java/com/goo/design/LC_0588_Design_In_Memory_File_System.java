/**
 * Created by Sijia on 2/17/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.goo.design;

import java.util.*;

public class LC_0588_Design_In_Memory_File_System {
    Node root;

    public void FileSystem() {
        root = new Node("");
    }

    public List<String> ls(String path) {
        List<String> res = new ArrayList<>();
        Node leave = getLeave(path);
        if (leave.isFile) {
            res.add(leave.name);
        } else {
            res.addAll(leave.children.keySet());
        }
        Collections.sort(res);
        return res;
    }

    public void mkdir(String path) {
        getLeave(path);
    }

    private Node getLeave(String path) {
        String[] dirs = path.split("/");
        Node node = root;
        for (String dir: dirs) {
            if (dir.length() == 0) continue;
            node.children.putIfAbsent(dir,new Node(dir));
            node = node.children.get(dir);
        }
        return node;
    }

    public void addContentToFile(String filePath, String content) {
        Node leave = getLeave(filePath);
        leave.isFile = true;
        leave.content += content;
    }

    public String readContentFromFile(String filePath) {
        Node leave = getLeave(filePath);
        return leave.content;
    }

    private class Node {
        boolean isFile = false;
        Map<String, Node> children = new HashMap<>();
        String name;
        String content="";

        Node(String path) {
            this.name = path;
        }
    }
}
