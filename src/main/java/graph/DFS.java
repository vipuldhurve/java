package graph;

import java.util.ArrayList;

public class DFS {

    public static void dfs(int node, ArrayList < ArrayList < Integer >> adj, boolean[] vis){

        System.out.print(node + " ");
        vis[node] = true;

        //Checking Adjacent Nodes
        ArrayList<Integer> adjNodes = adj.get(node);
        for(int adjNode : adjNodes){
            if(!vis[adjNode]){
                dfs(adjNode, adj, vis);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList <ArrayList< Integer >> adj = new ArrayList < > ();
        int totalNodes = 10;
        for (int i = 0; i < totalNodes; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(2).add(4);
        adj.get(4).add(2);

        boolean[] vis = new boolean[totalNodes];

        // A graph can have multiple components
        // do traversal on all components of Graph.
        int totalComponents = 0;
        for (int i = 0; i < totalNodes; i++) {
            if(!vis[i]) {
                dfs(i, adj, vis);
                totalComponents++;
                System.out.println(" ");
            }
        }

        System.out.println("Total components in graph: " + totalComponents);
    }

    static void printAns(ArrayList < Integer > ans) {
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println(" ");
    }
}
