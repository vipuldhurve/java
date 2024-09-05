package dsa.graph.algorithm;

import java.util.*;

public class DFS {

    public static void dfsRecursive(int node, Map<Integer, List<Integer>> adjMap, Set<Integer> visited) {
//        Process node
        System.out.print(node + " ");
//        Mark visited
        visited.add(node);
//        Checking Adjacent Nodes
        for (int neighbour : adjMap.getOrDefault(node, Collections.emptyList())) {
            if (!visited.contains(neighbour)) {
                dfsRecursive(neighbour, adjMap, visited);
            }
        }
    }

    public static void dfsIterative(int node, Map<Integer, List<Integer>> adjMap, Set<Integer> visited) {
//        Stack for the iterative DFS
        Stack<Integer> stack = new Stack<>();
//        Start with the initial node
        stack.push(node);
        while (!stack.isEmpty()) {
            int vertex = stack.pop();
//            If the node has not been visited, process it
            if (!visited.contains(vertex)) {
                System.out.print(vertex + " ");
                visited.add(vertex);
//                Push all neighbours to stack
                for (int neighbour : adjMap.getOrDefault(vertex, Collections.emptyList())) {
                    if (!visited.contains(neighbour)) stack.push(neighbour);
                }
            }
        }
    }

    private static void addEdge(int u, int v, Map<Integer, List<Integer>> adjMap) {
//        undirected graph
        adjMap.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        adjMap.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        int totalNodes = 5;

        addEdge(0, 1, adjMap);
        addEdge(0, 2, adjMap);
        addEdge(0, 3, adjMap);
        addEdge(2, 4, adjMap);

        Set<Integer> visited = new HashSet<>();

//         A graph can have multiple components
//         do traversal on all components of Graph.
        System.out.println("DFS Recursive");
        int totalComponents = 0;
        for (int i = 0; i < totalNodes; i++) {
            if (!visited.contains(i)) {
                dfsRecursive(i, adjMap, visited);
                totalComponents++;
                System.out.println(" ");
            }
        }
        System.out.println();

        visited = new HashSet<>();
        System.out.println("DFS Stack Iterative");
        for (int i = 0; i < totalNodes; i++) {
            if (!visited.contains(i)) {
                dfsIterative(i, adjMap, visited);
                totalComponents++;
                System.out.println(" ");
            }
        }
        System.out.println();

        System.out.println("Total components in graph: " + totalComponents);
    }
}
