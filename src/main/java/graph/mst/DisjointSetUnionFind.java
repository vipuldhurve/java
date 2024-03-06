package graph.mst;

public class DisjointSetUnionFind {
    int[] parent;
    int[] rank;
    int[] size;
    int totalNodes;

    DisjointSetUnionFind(int totalNodes){
        this.totalNodes = totalNodes;
        this.parent = new int[totalNodes];
        this.rank = new int[totalNodes];
        this.size = new int[totalNodes];
        for (int i = 0; i < totalNodes; i++) {
            parent[i] = i;
            rank[i] = 0;
            size[i] = 1;
        }
    }

    int findParent(int node){
        if(node == parent[node]) return node;
        return parent[node] = findParent(parent[node]);
    }

    void union(int u, int v){
        u = findParent(u);
        v = findParent(v);

        if(rank[u] > rank[v]){
            parent[v] = u;
        } else if (rank[v] > rank[u]){
            parent[u] = v;
        } else {
            parent[v] = u;
            rank[u]++;
        }
    }

    void unionBySize(int u, int v){
        u = findParent(u);
        v = findParent(v);

        if(size[u] > size[v]){
            parent[v] = u;
            size[u] += size[v];
        } else {
            parent[u] = v;
            size[v] += size[u];
        }
    }


    public static void main(String[] args) {
        int totalNodes = 7;

        DisjointSetUnionFind obj = new DisjointSetUnionFind(totalNodes);
        obj.union(0,1);
        obj.union(1,2);
        obj.union(3,4);
        obj.union(5,6);

        System.out.println("Parent of 2: " + obj.findParent(2));
        System.out.println("Parent of 4: " + obj.findParent(4));
        System.out.println("Parent of 6: " + obj.findParent(6));

        obj.union(3,5);

        System.out.println("Parent of 2: " + obj.findParent(2));
        System.out.println("Parent of 4: " + obj.findParent(4));
        System.out.println("Parent of 6: " + obj.findParent(6));

        obj.union(2,6);

        System.out.println("Parent of 2: " + obj.findParent(2));
        System.out.println("Parent of 4: " + obj.findParent(4));
        System.out.println("Parent of 6: " + obj.findParent(6));
    }
}
