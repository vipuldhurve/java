package graph.mst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Prims {

    public static void main(String[] args) {
        int totalNodes = 5;
        ArrayList<ArrayList<Node> > adj = new ArrayList<ArrayList<Node> >();

        for (int i = 0; i < totalNodes; i++)
            adj.add(new ArrayList<Node>());

        adj.get(0).add(new Node(1, 2));
        adj.get(1).add(new Node(0, 2));

        adj.get(1).add(new Node(2, 3));
        adj.get(2).add(new Node(1, 3));

        adj.get(0).add(new Node(3, 6));
        adj.get(3).add(new Node(0, 6));

        adj.get(1).add(new Node(3, 8));
        adj.get(3).add(new Node(1, 8));

        adj.get(1).add(new Node(4, 5));
        adj.get(4).add(new Node(1, 5));

        adj.get(2).add(new Node(4, 7));
        adj.get(4).add(new Node(2, 7));

        Prims obj = new Prims();
        int mstCost = obj.primsAlgoMinCost(adj, totalNodes);
        obj.primsAlgoPrintMst(adj, totalNodes);
        System.out.println("Cost of minimum spanning tree: " + mstCost);
    }

    public int primsAlgoMinCost(ArrayList<ArrayList<Node>> adj, int totalNodes){

        boolean[] mst = new boolean[totalNodes];
        int minCost = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>(new Node(0,0));

        pq.add(new Node(0, 0));
        while(!pq.isEmpty()){
            Node node = pq.poll();
            if(mst[node.v]) continue;

            mst[node.v] = true;
            minCost += node.w;

            for(Node adjNode: adj.get(node.v)){
                if(!mst[adjNode.v]){
                    pq.add(adjNode);
                }
            }
        }
        return minCost;
    }

    public void primsAlgoPrintMst(ArrayList<ArrayList<Node>> adj, int totalNodes){
        boolean[] mst = new boolean[totalNodes];
        int[] key = new int[totalNodes];
        Arrays.fill(key, Integer.MAX_VALUE);
        int[] parent = new int[totalNodes];
        Arrays.fill(parent, -1);
        PriorityQueue<Node> pq = new PriorityQueue<>(new Node(0,0));

        key[0]=0;
        pq.add(new Node(0, 0));
        while(!pq.isEmpty()){
            Node node = pq.poll();
            mst[node.v] = true;
            for(Node adjNode: adj.get(node.v)){
                if(!mst[adjNode.v] && key[adjNode.v] > adjNode.w){
                    pq.add(adjNode);
                    key[adjNode.v] = adjNode.w;
                    parent[adjNode.v] = node.v;
                }
            }
        }

        System.out.println("Minimum spanning tree edges:");
        for (int i = 0; i < totalNodes; i++) {
            System.out.println(parent[i] + " -> " + i);
        }
    }

    static class Node implements Comparator<Node> {
        public int v;
        public int w;

        Node(int v, int w){
            this.v = v;
            this.w = w;
        }


        @Override
        public int compare(Node n1, Node n2) {
            return n1.w - n2.w;
        }
    }

}


