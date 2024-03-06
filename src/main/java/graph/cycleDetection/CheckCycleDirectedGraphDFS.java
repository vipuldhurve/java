package graph.cycleDetection;
import java.util.*;

public class CheckCycleDirectedGraphDFS {

    public static void main(String[] args) {
        int totalNodes= 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(totalNodes);

        //Vertex - 0
        ArrayList<Integer> neighbors = new ArrayList<Integer>();
        neighbors.add(1);
        adj.add(neighbors);

        //Vertex - 1
        neighbors = new ArrayList<Integer>();
        neighbors.add(2);
        neighbors.add(5);
        adj.add(neighbors);

        //Vertex - 2
        neighbors = new ArrayList<Integer>();
        neighbors.add(3);
        adj.add(neighbors);

        //Vertex - 3
        neighbors = new ArrayList<Integer>();
        neighbors.add(4);
        adj.add(neighbors);

        //Vertex - 4
        neighbors = new ArrayList<Integer>();
        neighbors.add(0);
        neighbors.add(1);
        adj.add(neighbors);

        //Vertex - 5
        neighbors = new ArrayList<Integer>();
        adj.add(neighbors);

        if(isCyclic(totalNodes, adj))
            System.out.println("Cycle detected");
        else
            System.out.println("No cycles detected");
    }

    private static boolean isCyclic(int totalNodes, ArrayList<ArrayList<Integer>> adj) {

        boolean[] vis = new boolean[totalNodes];
        boolean[] dfsVis = new boolean[totalNodes];

        for (int i = 0; i < totalNodes; i++) {
            if(!vis[i]){
                if(checkCycleDfs(i, adj, vis, dfsVis)) return true;
            }
        }
        return false;
    }

    private static boolean checkCycleDfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, boolean[] dfsVis) {
        vis[node]=true;
        dfsVis[node]=true;
        for(int adjNode : adj.get(node)){
            if(!vis[adjNode]){
                if(checkCycleDfs(adjNode,adj,vis,dfsVis)) return true;
            } else if(vis[adjNode] && dfsVis[node]) return true;
        }
        dfsVis[node] = false;
        return false;
    }
}
