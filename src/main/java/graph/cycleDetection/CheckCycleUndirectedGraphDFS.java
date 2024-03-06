package graph.cycleDetection;

import java.util.ArrayList;

public class CheckCycleUndirectedGraphDFS {

    public static void main(String[] args) {
        int totalNodes = 5;

        ArrayList <ArrayList< Integer >> adj = new ArrayList < > ();
        for (int i = 0; i < totalNodes; i++) {
            adj.add(new ArrayList < > ());
        }
        // edge 0---1
        adj.get(0).add(1);
        adj.get(1).add(0);

        // edge 1---2
        adj.get(1).add(2);
        adj.get(2).add(1);

        // adge 2--3
        adj.get(2).add(3);
        adj.get(3).add(2);

        // adge 3--4
        adj.get(3).add(4);
        adj.get(4).add(3);

        // adge 1--4
        adj.get(1).add(4);
        adj.get(4).add(1);


        CheckCycleUndirectedGraphDFS obj = new CheckCycleUndirectedGraphDFS();
        boolean ans = obj.isCycle(totalNodes, adj);
        if (ans == true) {
            System.out.println("Cycle Detected");
        } else {
            System.out.println("No Cycle Detected");

        }
    }

    public boolean isCycle(int totalNodes, ArrayList<ArrayList<Integer>> adj){

        boolean[] vis = new boolean[totalNodes];

        for (int i = 0; i < totalNodes; i++) {
            if(!vis[i]){
                if(checkForCycleDFS(i, -1, adj, vis)) return true;
            }
        }
        return false;
    }

    public boolean checkForCycleDFS(int node, int parentNode, ArrayList<ArrayList<Integer>> adj, boolean[] vis){

        vis[node] = true;

        for (int adjNode : adj.get(node)) {
            if(!vis[adjNode] ){
                if(checkForCycleDFS(adjNode, node, adj, vis))
                    return true;
            } else if (adjNode!=parentNode){
                return true;
            }
        }
        return false;
    }

}
