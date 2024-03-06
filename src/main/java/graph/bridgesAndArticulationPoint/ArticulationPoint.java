package graph.bridgesAndArticulationPoint;

import java.util.ArrayList;

public class ArticulationPoint {

    public static void main(String[] args) {
        int totalNodes = 6;
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

        ArticulationPoint obj = new ArticulationPoint();
        obj.printArticulationPoints(adj, totalNodes);

    }

    private void printArticulationPoints(ArrayList<ArrayList<Integer>> adj, int totalNodes) {

        boolean[] visited = new boolean[totalNodes];
        int[] time = new int[totalNodes];
        int[] low = new int[totalNodes];
        boolean[] AP = new boolean[totalNodes];

        for (int i = 0; i < totalNodes; i++) {
            if (!visited[i]){
                dfs(i, -1, adj, visited, time, low, 1, AP);
            }
        }

        System.out.println("Articulation Points:");
        for(int i=0; i<totalNodes; i++){
            if(AP[i]) {
                System.out.println(i);
            }
        }
    }

    private void dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] visited, int[] time, int[] low, int timer, boolean[] AP) {

        int childCount = 0;

        time[node] = low[node] = timer++;

        visited[node] = true;

        for(int adjNode : adj.get(node)){

            if(adjNode == parent) continue;

            if(!visited[adjNode]){
                dfs(adjNode, node, adj, visited, time, low, timer, AP);
                low[node] = Math.min(low[node], low[adjNode]);

                if(parent != -1 && low[adjNode] >= time[node] ){
                    AP[node] = true;
                }
                childCount++;
            } else {
                low[node] = Math.min(low[node], time[adjNode]);
            }
        }

        if(parent == -1 && childCount > 1) {
            AP[node] = true;
        }

    }


}
