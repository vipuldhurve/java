package graph.shortestPath;
import java.util.*;
public class ShortestPathDijkstra {

    public static void main(String[] args) {
        int totlaNodes = 5;
        ArrayList<ArrayList<Node> > adj = new ArrayList<ArrayList<Node> >();

        for (int i = 0; i < totlaNodes; i++)
            adj.add(new ArrayList<Node>());

        adj.get(0).add(new Node(1, 2));
        adj.get(1).add(new Node(0, 2));

        adj.get(1).add(new Node(2, 4));
        adj.get(2).add(new Node(1, 4));

        adj.get(0).add(new Node(3, 1));
        adj.get(3).add(new Node(0, 1));

        adj.get(3).add(new Node(2, 3));
        adj.get(2).add(new Node(3, 3));

        adj.get(1).add(new Node(4, 5));
        adj.get(4).add(new Node(1, 5));

        adj.get(2).add(new Node(4, 1));
        adj.get(4).add(new Node(2, 1));

        shortestPath(0, adj, totlaNodes);
    }

    private static void shortestPath(int src, ArrayList<ArrayList<Node>> adj, int totlaNodes) {
        PriorityQueue<Node> q = new PriorityQueue<>(new Node());

        int[] dist = new int[totlaNodes];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        q.add(new Node(src, 0));

        while(!q.isEmpty()){
            Node node = q.poll();
            for(Node adjNode: adj.get(node.v)){
                if(dist[adjNode.v] > dist[node.v] + adjNode.weight){
                    dist[adjNode.v] = dist[node.v] + adjNode.weight;
                    q.add(new Node(adjNode.v, dist[adjNode.v]));
                }
            }
        }

        System.out.println("The distances from source "+src+" are : ");
        for (int i = 0; i < totlaNodes; i++)
        {
            System.out.print( dist[i] + " ");
        }
    }

    static class Node implements Comparator<Node> {
        int v;
        int weight;

        Node(){}
        Node(int v, int weight){
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compare(Node n1, Node n2) {
            return n1.weight - n2.weight;
        }
    }

}


