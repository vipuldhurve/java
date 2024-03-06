package graph.shortestPath;
import java.util.*;

public class ShortestPathUndirectedUnitWeightGraphBFS {
    public static void main(String[] args) {

    }

    private void shortestPath(ArrayList<ArrayList<Integer>> adj,int totalNodes,int startNode)
    {

        int[] dist = new int[totalNodes];
        for(int i = 0; i < totalNodes; i++)
            dist[i] = 1000000000;

        Queue<Integer> q = new LinkedList<>();


        dist[startNode] = 0;
        q.add(startNode);

        while(!q.isEmpty())
        {
            int node = q.poll();
            for(int adjNode : adj.get(node)){
                if(dist[node] + 1 < dist[adjNode]){
                    dist[adjNode] = dist[node] + 1;
                    q.add(adjNode);
                }
            }
        }

        for(int i = 0;i < totalNodes;i++) {
            System.out.print(dist[i] + " ");
        }
    }
}
