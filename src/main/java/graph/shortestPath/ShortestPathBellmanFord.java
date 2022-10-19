package graph.shortestPath;
import java.util.*;

public class ShortestPathBellmanFord {
    public static void main(String[] args) {
        int totalNodes = 6;
        ArrayList<Node> adj = new ArrayList<Node>();


        adj.add(new Node(3, 2, 6));
        adj.add(new Node(5, 3, 1));
        adj.add(new Node(0, 1, 5));
        adj.add(new Node(1, 5, -3));
        adj.add(new Node(1, 2, -2));
        adj.add(new Node(3, 4, -2));
        adj.add(new Node(2, 4, 3));


        ShortestPathBellmanFord obj = new ShortestPathBellmanFord();
        obj.bellmanFord(adj, totalNodes, 0);
    }

    private void bellmanFord(ArrayList<Node> adj, int totalNodes, int src) {

        int[] dist = new int[totalNodes];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i = 1; i <= totalNodes-1; i++) {
            for(Node node : adj){
                if(dist[node.u] != Integer.MAX_VALUE && dist[node.v] > dist[node.u] + node.w){
                    dist[node.v] = dist[node.u] + node.w;
                }
            }
        }

        boolean isNegativeCycle = false;
        for(Node node : adj){
            if(dist[node.v] > dist[node.u] + node.w){
                isNegativeCycle = true;
                System.out.println("Negative Cycle found");
                break;
            }
        }

        if(!isNegativeCycle){
            for(int i = 0;i<totalNodes;i++) {
                System.out.print(  dist[i]+" ");
            }
        }

    }

    static class Node {
        int u;
        int v;
        int w;

        Node(int u, int v, int w){
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
}


