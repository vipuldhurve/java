package dsa.util;

import java.util.HashSet;
import java.util.Set;

public class GraphUtil {
    static Set<GraphNode> visitedGraphNode;
    private static void printGraphNodeUtil(GraphNode node){
        if(node == null) return;
        visitedGraphNode.add(node);
        System.out.println(node);
        for(GraphNode neighbor: node.neighbors){
            if(!visitedGraphNode.contains(neighbor)) printGraphNodeUtil(neighbor);
        }
    }
    public static void printGraphNodes(GraphNode node){
        visitedGraphNode = new HashSet<>();
        printGraphNodeUtil(node);
    }
}
