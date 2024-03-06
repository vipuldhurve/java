package graph.cycleDetection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CheckCycleDirectedGraphBFS {
    public static void main(String[] args) {
        ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();
        int totalNodes = 6;
        // adding new arraylists to 'adj' to add neighbour nodes
        for (int i = 0; i < totalNodes; i++) {
            adj.add(new ArrayList < > ());
        }


        adj.get(5).add(2);
        adj.get(0).add(5);
        adj.get(4).add(0);
        adj.get(1).add(4);
        adj.get(3).add(1);
        adj.get(2).add(3);

        if(new CheckCycleDirectedGraphBFS().isCyclic(totalNodes,adj)){
            System.out.println("Cycle detected in Graph");
        } else {
            System.out.println("Cycle not detected in Graph");
        }
    }

    private boolean isCyclic(int totalNodes, ArrayList<ArrayList<Integer>> adj) {

        //Initializing indegree array
        int[] indegree = new int[totalNodes];
        for (ArrayList<Integer> adjNodes : adj) {
            for (Integer adjNode : adjNodes) {
                indegree[adjNode]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        int topoSortOrderCount=0;

        for (int i = 0; i < totalNodes; i++) {
            if(indegree[i]==0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int node = q.poll();
            topoSortOrderCount++;
            for(int adjNode: adj.get(node)){
                indegree[adjNode]--;
                if(indegree[adjNode] == 0) {
                    q.add(adjNode);
                }
            }
        }

        return topoSortOrderCount != totalNodes;
    }
}
