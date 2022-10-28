package graph.mst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Kruskal {

    int[] parent;
    int[] rank;

    Kruskal(int totalNodes){
        parent = new int[totalNodes];
        rank = new int[totalNodes];
        for (int i = 0; i < totalNodes; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public static void main(String[] args) {

        int totalNodes = 5;
        ArrayList<Edge> edges = new ArrayList<Edge>();


        edges.add(new Edge(0, 1, 2));
        edges.add(new Edge(0, 3, 6));
        edges.add(new Edge(1, 3, 8));
        edges.add(new Edge(1, 2, 3));
        edges.add(new Edge(1, 4, 5));
        edges.add(new Edge(2, 4, 7));


        Kruskal obj = new Kruskal(totalNodes);
        obj.findMst(edges, totalNodes);

    }

    public void findMst(ArrayList<Edge> edges, int totalNodes){
        edges.sort(new Edge(0,0,0));

        int mstCost = 0;
        List<Edge> mstEdges = new ArrayList<>();
        for (Edge edge :
                edges) {
            if(findParent(edge.u) != findParent(edge.v)){
                mstCost += edge.w;
                union(edge.u, edge.v);
                mstEdges.add(edge);
            }
        }

        for (Edge mstEdge :
                mstEdges) {
            System.out.println(mstEdge.u + "->" + mstEdge.v);
        }

        System.out.println("Cost of MST: " + mstCost);
    }

    public int findParent(int node){
        if(parent[node] == node) return node;
        return parent[node] = findParent(parent[node]);
    }

    public void union(int u , int v){
        u = findParent(u);
        v = findParent(v);

        if(rank[u] > rank[v]){
            parent[v] = u;
        } else if (rank[u] < rank[v]){
            parent[u] = v;
        } else {
            parent[v] = u;
            rank[u]++;
        }
    }

    public static class Edge implements Comparator<Edge> {
        public int u;
        public int v;
        public int w;

        Edge(int u, int v, int w){
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compare(Edge e1, Edge e2) {
            return e1.w - e2.w;
        }
    }

}
