package dsa.graph.problems;

import dsa.graph.util.GraphUtil;
import dsa.graph.util.GraphNode;

import java.util.*;

public class CloneGraph {

//    Given a reference of a node in a connected undirected graph.
//    Return a deep copy (clone) of the graph.
//    Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.

//    class GraphNode {
//        public int val;
//        public List<GraphNode> neighbors;
//    }

    private static void cloneDfs(GraphNode node, GraphNode nodeCopy, Map<Integer, GraphNode> visited) {
        visited.put(node.val, nodeCopy);
        for (GraphNode neighbor : node.neighbors) {
            if (!visited.containsKey(neighbor.val)) {
//                Create new copy of neighbor node
                GraphNode neighborCopy = new GraphNode(neighbor.val);
//                add it in current node neighbor list
                nodeCopy.neighbors.add(neighborCopy);
//                Clone using dfs
                cloneDfs(neighbor, neighborCopy, visited);
            } else {
//                neighbor already exist so add from visited map
                nodeCopy.neighbors.add(visited.get(neighbor.val));
            }
        }
    }

    private static GraphNode cloneGraph(GraphNode node) {
        if (node == null) return node;
//        We need map to store node and its copy
//        here we are storing integer val of node and its corresponding copy node
        Map<Integer, GraphNode> visited = new HashMap<>();
//         Create copy of start node and start cloning using dfs
        GraphNode nodeCopy = new GraphNode(node.val);
        cloneDfs(node, nodeCopy, visited);
        return nodeCopy;
    }

    private static void solve(GraphNode input){
//        Input
        System.out.println("Input: ");
        GraphUtil.printGraphNodes(input);
//        Output
        System.out.println("Output: ");
        GraphNode graphCopy = cloneGraph(input);
        GraphUtil.printGraphNodes(graphCopy);
        System.out.println();
    }

    public static void main(String[] args) {
        GraphNode node1 = new GraphNode(1);
        GraphNode node2 = new GraphNode(2);
        GraphNode node3 = new GraphNode(3);
        GraphNode node4 = new GraphNode(4);
//        1 --- 2
//        |     |
//        4 --- 3
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);
//        Input 1
        solve(node1);
//        Input 2
        solve(null);
//        Input 3
        GraphNode singleNode = new GraphNode(1);
        solve(singleNode);
    }

}
