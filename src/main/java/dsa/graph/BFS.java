package dsa.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    static class Edge{
        int src;
        int dest;
        public Edge(int s, int d){
            this.src=s;
            this.dest=d;
        }
    }

    //This is a traversal method used for printing the traversal technique
    public static void traverse(ArrayList<Edge> graph[]){
        int totalNodes = graph.length;

        //Visited array
        boolean[] visited = new boolean[totalNodes];

        //A graph can have multiple components
        //Do traversal on all components of graph
        int totalComponents=0;
        for(int i=0; i<totalNodes; i++){
            if(!visited[i]){
                ArrayList<Integer> bfsGraphComponent = bfs(i, graph, visited);
                // Print graph component and increment
                printArr(bfsGraphComponent);
                totalComponents++;
            }
        }

        System.out.println("Total components in graph: "+ totalComponents);
    }

    public static ArrayList<Integer> bfs(int startNode, ArrayList<Edge> graph[], boolean[] visited){
        // Output
        ArrayList<Integer> bfsOutput = new ArrayList<>();

        //Data Structures we need:
        //1. Queue       2. Visited Array
        Queue<Integer> q = new LinkedList<>();
        q.add(startNode);

        while(!q.isEmpty()){
            int curr = q.poll();
            // If current node not visited
            if(!visited[curr]){
                bfsOutput.add(curr);
                visited[curr]=true; // mark visited
                //Adding neighbours in queue
                for(int i=0; i<graph[curr].size(); i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }

        return bfsOutput;
    }

    //  Method for creating graph
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        // 0--2---3
        //    \  /
        //     1
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 3));
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 2));

        //  4---5---7
        //     / \  |
        //    6    8
        graph[4].add(new Edge(4, 5));
        graph[5].add(new Edge(5, 6));
        graph[5].add(new Edge(5, 7));
        graph[5].add(new Edge(5, 8));
        graph[6].add(new Edge(6, 5));
        graph[7].add(new Edge(7, 5));
        graph[7].add(new Edge(7, 8));
        graph[8].add(new Edge(8, 5));
        graph[8].add(new Edge(8, 7));
    }

    public static void main(String args[]){
        int v=9;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        traverse(graph);
    }

    //Method for printing list
    static void printArr(ArrayList < Integer > ans) {
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println(" ");
    }
}
