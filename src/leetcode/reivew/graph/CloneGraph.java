package leetcode.reivew.graph;

import java.util.ArrayList;
import java.util.List;

public class CloneGraph {

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

    Node[] visited;
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        visited = new Node[101];
        return recursive(node);
    }

    private Node recursive(Node node) {
        if(visited[node.val] != null) return visited[node.val];
        visited[node.val] = new Node(node.val);
        for(Node n : node.neighbors) {
            visited[node.val].neighbors.add(recursive(n));
        }
        return visited[node.val];
    }

}
