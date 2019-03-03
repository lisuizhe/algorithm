import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class DirectedGraphNode<T> {
    public T val;
    public List<DirectedGraphNode<T>> neighbors;

    public DirectedGraphNode(T val) {
        this.val = val;
        this.neighbors = new ArrayList<>();
    }
}

class UndirectedGraphNode<T> {
    public T val;
    public List<UndirectedGraphNode<T>> neighbors;

    public UndirectedGraphNode(T val) {
        this.val = val;
        this.neighbors = new ArrayList<>();
    }
}

class GraphSolution {

    public static <T> boolean hasRouteByDFS(List<DirectedGraphNode<T>> graph,
            DirectedGraphNode<T> start, DirectedGraphNode<T> end) {
        Set<DirectedGraphNode<T>> visited = new HashSet<>();
        return dfsForHasRoute(graph, visited, end, end);
    }

    private static <T> boolean dfsForHasRoute(List<DirectedGraphNode<T>> graph, Set<DirectedGraphNode<T>> visited,
            DirectedGraphNode<T> start, DirectedGraphNode<T> end) {
        if (start == end) {
            return true;
        } else {
            if (start == null || end == null) {
                return false;
            }
            visited.add(start);
            if (start.neighbors.size() > 0) {
                for (DirectedGraphNode<T> neighbor: start.neighbors) {
                    if (visited.contains(neighbor)) {
                        continue;
                    }
                    if (dfsForHasRoute(graph, visited, neighbor, end)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static <T> boolean hasRouteByBFS(List<DirectedGraphNode<T>> graph,
            DirectedGraphNode<T> start, DirectedGraphNode<T> end) {
        if (graph == null || start == null || end == null) {
            return false;
        }

        Set<DirectedGraphNode<T>> visited = new HashSet<>();
        Queue<DirectedGraphNode<T>> queue = new ArrayDeque<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            DirectedGraphNode<T> node = queue.poll();
            visited.add(node);
            if (node == end) {
                return true;
            }
            for (DirectedGraphNode<T> neighbor: node.neighbors) {
                if (visited.contains(neighbor)) {
                    continue;
                }
                queue.offer(neighbor);
            }
        }
        return false;
    }

    public static <T extends Comparable<T>> List<List<T>> connectedComponentsByDFS(List<UndirectedGraphNode<T>> nodes) {
        if (nodes == null || nodes.isEmpty()) {
            return null;
        }
        List<List<T>> results = new ArrayList<>();
        Set<UndirectedGraphNode<T>> visited = new HashSet<>();
        for (UndirectedGraphNode<T> node : nodes) {
            if (visited.contains(node)) {
                continue;
            }
            List<T> result = new ArrayList<>();
            dfsForConnectedComponents(node, visited, result);
            Collections.sort(result);
            results.add(result);
        }
        return results;
    }

    private static <T> void dfsForConnectedComponents(UndirectedGraphNode<T> node, Set<UndirectedGraphNode<T>> visited, List<T> result) {
        result.add(node.val);
        visited.add(node);
        for (UndirectedGraphNode<T> neighbor : node.neighbors) {
            if (visited.contains(neighbor.val)) {
                continue;
            }
            dfsForConnectedComponents(neighbor, visited, result);
        }
    }

    public static <T extends Comparable<T>> List<List<T>> connectedComponentsByBFS(List<UndirectedGraphNode<T>> nodes) {
        if (nodes == null || nodes.isEmpty()) {
            return null;
        }
        List<List<T>> results = new ArrayList<>();
        Set<UndirectedGraphNode<T>> visited = new HashSet<>();
        for (UndirectedGraphNode<T> node : nodes) {
            if (visited.contains(node)) {
                continue;
            }
            List<T> result = bfsForConnectedComponents(node, visited);
            Collections.sort(result);
            results.add(result);
        }
        return results;
    }

    private static <T> List<T> bfsForConnectedComponents(UndirectedGraphNode<T> node, Set<UndirectedGraphNode<T>> visited) {
        List<T> result = new ArrayList<>();
        Queue<UndirectedGraphNode<T>> queue = new ArrayDeque<>();
        queue.offer(node);
        visited.add(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode<T> current = queue.poll();
            result.add(current.val);
            for (UndirectedGraphNode<T> neighbor: current.neighbors) {
                if (visited.contains(neighbor)) {
                    continue;
                }
                queue.offer(neighbor);
                visited.add(neighbor);
            }
        }
        return result;
    }
}