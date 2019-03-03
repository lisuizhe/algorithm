package Q0133_Clone_Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};

class Solution {
    public Node cloneGraph(Node node) {
        Map<Integer, Node> visited = new HashMap<>();
        return dfs(node, visited);
    }

    private Node dfs(Node node, Map<Integer, Node> visited) {
        if (node == null) {
            return null;
        }
        Node cloned = new Node(node.val, new ArrayList<>());
        visited.put(node.val, cloned);
        for (Node neighbor: node.neighbors) {
            if (visited.containsKey(neighbor.val)) {
                cloned.neighbors.add(visited.get(neighbor.val));
            } else {
                cloned.neighbors.add(dfs(neighbor, visited));
            }
        }
        return cloned;
    }
}