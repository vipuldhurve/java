package graph.shortestPath;
import java.util.*;

public class ShortestPathWeightedDirectedAcyclicGraph {

    public static void main(String[] args) {
        int totalNodes = 6;
        ArrayList<ArrayList<Pair> > adj = new ArrayList<ArrayList<Pair> >();

        for (int i = 0; i < totalNodes; i++)
            adj.add(new ArrayList<Pair>());

        adj.get(0).add(new Pair(1, 2));
        adj.get(0).add(new Pair(4, 1));
        adj.get(1).add(new Pair(2, 3));
        adj.get(2).add(new Pair(3, 6));
        adj.get(4).add(new Pair(2, 2));
        adj.get(4).add(new Pair(5, 4));
        adj.get(5).add(new Pair(3, 1));
        ShortestPathWeightedDirectedAcyclicGraph obj = new ShortestPathWeightedDirectedAcyclicGraph();
        obj.shortestPath(0, adj, totalNodes);
    }

    private void shortestPath(int src, ArrayList<ArrayList<Pair>> adj, int totalNodes) {

        Stack<Integer> stack = new Stack<>();
        boolean[] vis = new boolean[totalNodes];

        for (int i = 0; i < totalNodes; i++) {
            if(!vis[i]){
                topoSort(i, adj, vis, stack);
            }
        }

        int[] dist = new int[totalNodes];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;

        while(!stack.isEmpty()){
            int node = stack.pop();
            if(dist[node] != Integer.MAX_VALUE){
                for(Pair adjNode : adj.get(node)){
                    if(dist[adjNode.v] > dist[node] + adjNode.weight){
                        dist[adjNode.v] = dist[node] + adjNode.weight;
                    }
                }
            }
        }

        for (int i = 0; i < totalNodes; i++)
        {
            if (dist[i] == Integer.MAX_VALUE)
                System.out.print( "INF ");
            else
                System.out.print( dist[i] + " ");
        }

    }

    private void topoSort(int node, ArrayList<ArrayList<Pair>> adj, boolean[] vis, Stack<Integer> stack) {
        vis[node] = true;
        for(Pair adjNode : adj.get(node)){
            if(!vis[adjNode.v]){
                topoSort(adjNode.v, adj, vis, stack);
            }
        }
        stack.add(node);
    }

}

class Pair {
    int v;
    int weight;

    Pair(int v, int weight){
        this.v = v;
        this.weight = weight;
    }
}
