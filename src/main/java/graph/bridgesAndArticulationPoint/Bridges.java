package graph.bridgesAndArticulationPoint;

import java.util.ArrayList;
import java.util.Arrays;

public class Bridges {

    public static void main(String[] args) {
        int totalNodes = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < totalNodes; i++)
            adj.add(new ArrayList<>());

        adj.get(0).add(1);
        adj.get(1).add(0);

        adj.get(0).add(2);
        adj.get(2).add(0);

        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(1).add(3);
        adj.get(3).add(1);

        adj.get(3).add(4);
        adj.get(4).add(3);

        Bridges obj = new Bridges();
        obj.printBridges(adj, totalNodes);
    }

    private void printBridges(ArrayList<ArrayList<Integer>> adj, int totalNodes) {

        boolean[] visited = new boolean[totalNodes];
        Arrays.fill(visited, false);

        int[] time = new int[totalNodes];
        int[] low = new int[totalNodes];

        for (int i = 0; i < totalNodes; i++) {
            if(!visited[i]){
                dfs(i, -1, adj, visited,time,low, 1);
            }
        }
    }

    private void dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] visited, int[] time, int[] low, int timer) {
        visited[node] = true;
        time[node] = low[node] = timer++;

        for (int adjNode : adj.get(node)) {
            if(adjNode == parent) continue;
            if(!visited[adjNode]){
                dfs(adjNode, node, adj, visited, time, low, timer);
                low[node] = Math.min(low[node], low[adjNode]);
                if(low[adjNode] > time[node]){
                    System.out.println(node + "->" + adjNode);
                }
            } else {
                low[node] = Math.min(low[node], time[adjNode]);
            }

        }
    }
}
