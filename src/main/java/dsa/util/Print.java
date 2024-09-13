package dsa.util;

import java.util.HashSet;
import java.util.Set;

public class Print {

    public static void intMatrix(int[][] arr){
        for(int[] x: arr){
            for(int y: x) System.out.print( y + "   ");
            System.out.println();
        }
    }

    private static void printGraphNodesDFS(GraphNode node, Set<GraphNode> visitedGraphNode){
        if(node == null) return;
        visitedGraphNode.add(node);
        System.out.println(node);
        for(GraphNode neighbor: node.neighbors){
            if(!visitedGraphNode.contains(neighbor)) printGraphNodesDFS(neighbor, visitedGraphNode);
        }
    }
    public static void graphNodes(GraphNode node){
        Set<GraphNode> visitedGraphNode = new HashSet<>();
        printGraphNodesDFS(node, visitedGraphNode);
    }
}
